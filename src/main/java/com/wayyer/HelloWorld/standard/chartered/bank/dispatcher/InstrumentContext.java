package com.wayyer.HelloWorld.standard.chartered.bank.dispatcher;

/**
 * @Author: wayyer
 * @Description: the context of instrument type
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class InstrumentContext {
    private Instrument instrument;


    public InstrumentContext(Instrument instrument){
        this.instrument = instrument;
    }

    public Object loadPublish(){
        return instrument.publish();
    }



}
