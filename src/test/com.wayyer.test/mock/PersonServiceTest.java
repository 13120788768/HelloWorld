package com.wayyer.test.mock;

import com.wayyer.HelloWorld.mock.Person;
import com.wayyer.HelloWorld.mock.PersonDao;
import com.wayyer.HelloWorld.mock.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @Author: wayyer
 * @Description: test service a
 * @Program: HelloWorld
 * @Date: 2019.05.28
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

    private PersonDao personDaoMock;
    private PersonService personService;

    @Before
    public void setup(){
        personDaoMock = mock(PersonDao.class);
        when(personDaoMock.findById(1)).thenReturn(new Person(1, "Cao Wei"));
        when(personDaoMock.updatePerson(isA(Person.class))).thenReturn(true);
        personService = new PersonService(personDaoMock);
    }

    /**
     * 更新id为1的Person的名字，预期：能在DAO中找到Person并更新成功
     */
    @Test
    public void testUpdatePerson(){
        boolean result = personService.updatePerson(1, "wayyer");
        assertTrue("true", result);

        /**
         * isA（）：Object argument - that implements the given class.
         * eq（）：int argument - that is equal to the given value
         *
         * Mockito使用verify去校验方法是否被调用，然后使用isA和eq这些内置的参数匹配器可以更加灵活，
         */
        //validate if the method findById has been executed
        verify(personDaoMock, times(1)).findById(eq(1));
        //validate the updatePerson
        verify(personDaoMock, times(1)).updatePerson(isA(Person.class));
    }


    /**
     * 更新id为2的Person的名字，预期：不能在DAO中找到Person，更新失败
     */
    @Test
    public void testUpdatePersonWhichNotExist(){
        boolean result = personService.updatePerson(2, "wayyer");
        assertFalse("false", result);

        /**
         * isA（）：Object argument - that implements the given class.
         * eq（）：int argument - that is equal to the given value
         *
         * Mockito使用verify去校验方法是否被调用，然后使用isA和eq这些内置的参数匹配器可以更加灵活，
         */
        //validate if the method findById has been executed
        verify(personDaoMock, times(1)).findById(eq(2));
        //validate the updatePerson
        verify(personDaoMock, times(0));
    }



}
