package main.java.com.wayyer.HelloWorld.lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaSolutionTest1 {
    private static LambdaSolutionTest1 ourInstance = new LambdaSolutionTest1();

    public static LambdaSolutionTest1 getInstance() {
        return ourInstance;
    }

    private LambdaSolutionTest1() {
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Cao", "Wei", 22),
                new Person("Gao", "Xiao", 28),
                new Person("Cai", "Dan", 24),
                new Person("Xuan", "Huan", 25),
                new Person("Yang", "Xin", 22)
        );

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -(o1.getAge() - o2.getAge());
        }
        });

        for(int i =0; i < people.size() ; i++){

        }

        for(Person p : people){

        }

        Iterator<Person> personIterator =  people.iterator();
        if(personIterator.hasNext()){
            personIterator.next();
        }

        //step 1: sort all the people with the last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));


        //strp 2:print all the people
        printConditionally(people, p -> true, p -> System.out.println(p));

        //step 3: print all the people with the first name starting with 'C'
        printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));


    }


    public static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p : people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }


    }
}
