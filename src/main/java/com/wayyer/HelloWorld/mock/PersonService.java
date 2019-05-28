package com.wayyer.HelloWorld.mock;

/**
 * @Author: wayyer
 * @Description: service
 * @Program: HelloWorld
 * @Date: 2019.05.28
 */
public class PersonService {

    private PersonDao personDao;

    public PersonService(PersonDao personDao){
        this.personDao = personDao;
    }

    public boolean updatePerson(int id, String name){
        Person person = personDao.findById(id);
        if (person == null){
            return false;
        }
        Person personUpdate = new Person(person.getId(), name);
        return personDao.updatePerson(personUpdate);
    }
}
