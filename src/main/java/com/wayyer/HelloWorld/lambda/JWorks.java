package com.jnj.pangea.wcao.test.lambda;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

/**
 * @Author: wayyer
 * @Description: the first actor class of AKKA
 * @Program: local_test
 * @Date: 2018.06.04
 */
public class JWorks  {

    private int count = 0;

    //protocol
    static class Message{
        private String text;

        public Message(String text){
            this.text = text;
        }
    }

    /*public JWorks(){
        receive(
                //ReceiveBuilder.
        );

    }*/



}
