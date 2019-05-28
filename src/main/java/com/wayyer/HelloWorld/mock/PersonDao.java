package com.wayyer.HelloWorld.mock;

/**
 * @Author: wayyer
 * @Description: dao
 * @Program: HelloWorld
 * @Date: 2019.05.28
 */
public interface PersonDao {

    Person findById(int id);

    boolean updatePerson(Person person);


}
