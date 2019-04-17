package com.jnj.pangea.wcao.test.lambda;

import java.io.RandomAccessFile;

/**
 * @Author: wayyer
 * @Description: test lambda bean
 * @Program: local_test
 * @Date: 2018.05.25
 */
public class Person {



    private String firstName;

    private String lastName;

    private int age;

    public Person(String firstName, String lastName, int age){
        super();
        this.firstName = firstName;
        this.lastName = lastName;

        this.age = age;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public void write(RandomAccessFile raf) throws Exception{
        raf.writeUTF(firstName);
        raf.writeUTF(lastName);
        raf.writeUTF(age + "");


    }
}
