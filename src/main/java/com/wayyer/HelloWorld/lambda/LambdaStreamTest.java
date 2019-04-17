package com.jnj.pangea.wcao.test.lambda;

import com.google.common.collect.Lists;
import scala.Int;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Streams : a sequence of eles supporting sequential and parallel aggregate operations.
 *
 * I. the stream comprise the file stream, collection stream and array stream.
 * II. the immediate conduction contains filter, distinct, sorted, limit, skip, map and flatMap
 * III. the terminal operations contains allMatch, anyMatch, noneMatch, findFirst, findAny, count,
 *      sum(reduction operations) and collect
 */
public class LambdaStreamTest {

    static List<Integer> nums = Lists.newArrayList(1,2,3,4);

    static String[] strs = {"feature", "java8", "author", "caowei", "company", "jnj"};

    static List<Person> people = Arrays.asList(
            new Person("Cao", "Wei", 25),
            new Person("Guo", "Liu", 24),
            new Person("Cao1", "Wei", 25),
            new Person("Guo1", "Liu", 24),
            new Person("Cao2", "Wei", 25),
            new Person("Guo2", "Liu", 24),
            new Person("Cao3", "Wei", 25),
            new Person("Guo3", "Liu", 24),
            new Person("Caoguo", "Meili", 18));

    public static void main(String[] args) {
        //the method stream can trans the collection into a stream
        //the filter method will filter the specific logic we defined with lambda expression
        //distinct all the duplicated ele
        //mapToInt method will handle all the num and return what we want, such as get all the int nums
        //the sum method will deal and sum counts


        Integer[] a = {1,2,3};
        Arrays.stream(a).filter(e -> e!=0).mapToInt(e -> e+2).collect(Collectors.toCollection());

        int sum = nums.stream().filter(num -> num!= null).distinct().mapToInt(num -> num+2).sum();

        System.out.println("1.1. calculate the array with the sum = " + sum);

        //reduce method is used for all the reduction operations, such as the typical sum, count.
        Long countPeo = people.stream().count();

        // int sum = nums.stream().filter(num -> num!= null).distinct().mapToInt(num -> num+2).sum();

        System.out.println("1.2. count method countPeo = " + countPeo);

        //the Collectors is a new class with version 8, this util is used for the reduction operations
        //the asList method will return a new collection
        nums = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        System.out.println("2. filter all the ele without odd num, new array = " + nums);


        List<Person> caoPeo = people
                .stream()
                .filter(person -> person.getFirstName()!=person.getLastName())
                .collect(Collectors.toList());

        System.out.println("3. filter all the people with different xxx and return caoPeo = " + caoPeo);


        List<Person> distinctPro = people
                .stream().distinct().collect(Collectors.toList());


        System.out.println("4. filter all the people with no duplicated and return distinctPro = " + distinctPro);


        List<Person> limitPeo = people
                .stream().limit(2).collect(Collectors.toList());

        System.out.println("5. limit 2 peo limitPeo = " + limitPeo);


        List<Person> skipPeo = people
                .stream().skip(6).collect(Collectors.toList());

        System.out.println("6. skip the early six skipPeo = " + skipPeo);


        List<Person> sortedDefaultPeo = people.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());

        System.out.println("7. the sortedDefaultPeo = " + sortedDefaultPeo);

        //mapToInt, mapToDouble, mapToLong ---> IntStream, DoubleStream, LongStream
        OptionalInt optionalInt = people
                .stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .mapToInt(Person::getAge).findFirst();

        System.out.println("8. the optionalInt = " + optionalInt);

        List<String> lastnamePeo = people.stream().map(Person::getLastName).distinct().collect(Collectors.toList());

        System.out.println("9. the person map to string list = " + lastnamePeo);


        //the map operation just do operate within the ele
        List<String[]> reductionList = Arrays.stream(strs).map(str -> str.split("")).distinct().collect(Collectors.toList());

        System.out.println("10. operate the arrays with map reductionList = " + reductionList);

        //if i want to get all the alphabet with no duplication, the flatMap is available
        List<String> flatReducationList = Arrays.stream(strs)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("11. flat map with operating the arrays with map flatReducationList = " + flatReducationList);

        List<Boolean> agePeo = people.stream().map(person -> person.getAge() > 17).collect(Collectors.toList());
        System.out.println("12. agePeo = " + agePeo);


        //omit the other flatMap related method: flatMapToInt, flatMapToDouble, flatMapToLong
        //...


        //reduction operation on terminal end

        //allMatch method is used for handling if all matching the corresponding characters
        boolean lastnameConstainI = people.stream().allMatch(person -> person.getLastName().contains("i"));

        System.out.println("13. judge if any person's last name cannot contains character i lastnameConstainI = " + lastnameConstainI);

        //anyMatch: poorer valid than allMatch, it will return true with just only one ele is true
        boolean caoweiIsInPeo = people.stream().anyMatch(person -> "CaoWei".equals(person.getFirstName() + person.getLastName()));

        System.out.println("14. judge if people contains one whose full name is CaoWei caoweiIsInPeo = " + caoweiIsInPeo);

        //noneMatch method is opposite from allMatch method, it only returns true if none matched
        boolean weeIsNotLastnamePeo = people.stream().noneMatch(person -> person.getLastName().contains("Wee"));

        System.out.println("15. judge if wee does not exist in any last name weeIsNotLastnamePeo = " + weeIsNotLastnamePeo);


        //findFirst method is used for searching the first ele position we want and return this ele
        //this method parameter is null, any criteria make sense in filter method
        Optional<Person> thefirstnameCaoInfoPeo = people.stream().filter(person -> "Cao".equals(person.getFirstName())).findFirst();
        System.out.println("16. get the first person whose first name 'Cao' thefirstnameCaoInfoPeo = " + thefirstnameCaoInfoPeo);

        //findAny method is used for searching any one who is suitable.

        //in stream method which stream is order by sequence, this findAny is the same with findFirst
        Optional<Person> anyoneAdultInfoInStreamPeo = people.stream().filter(person -> person.getAge() > 17).findAny();

        System.out.println("17.1. find a person who is a adult anyoneAdultInfoInStreamPeo = " + anyoneAdultInfoInStreamPeo);

        //the parallel stream is used for multiple threads to search
        Optional<Person> anyoneAdultInfoInParallelPeo = people.parallelStream().filter(person -> person.getAge() > 17).findAny();

        System.out.println("17.2. find a person who is a adult anyoneAdultInfoInParallelPeo = " + anyoneAdultInfoInParallelPeo);



        //reduction operation

        int reduceSumPeo = people.stream().mapToInt(Person::getAge).reduce(0, (a, b) -> a+b);
        System.out.println("18.1. the reduction operation of summarilizing reduceSumPeo = " + reduceSumPeo);

        int reduceSumNum = nums.stream().reduce(0, (a, b) -> a+b);
        System.out.println("18.2. the reduction operation of summarilizing reduceSumNum = " + reduceSumNum);

        int reduceSumNum2 = nums.stream().reduce(0, Integer::sum);
        System.out.println("18.3. the reduction operation of summarilizing reduceSumNum2 = " + reduceSumNum2);

        Optional<Integer> reduceSumNum3 = nums.stream().reduce(Integer::sum);
        System.out.println("18.4. the reduction operation of summarilizing reduceSumNum3 = " + reduceSumNum3.get());



        //Collectors: Collectors.reducing

        long countCollectorsPeo = people.stream().collect(Collectors.counting());

        System.out.println("19.1. the reducing operation : counting countCollectorsPeo = " + countCollectorsPeo);

        long countCollectorsPeo1 = people.stream().count();
        System.out.println("19.2. directly count method countCollectorsPeo1 = " + countCollectorsPeo1);


        //Collectors.maxBy, minBy : the maximum and minimum of the given collections

        String joiningFirstname = people.stream().map(Person::getFirstName).collect(Collectors.joining());
        System.out.println("20.1. join the strings joiningFirstname = " + joiningFirstname);


        //method reference: the method reference is used for java8 lambda expression
        //foreach iteration acts as the same functionality of iteration, for loop
        people.forEach(System.out::println);

        people.stream().forEach(System.out::println);


    }
}
