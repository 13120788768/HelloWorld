package com.wayyer.HelloWorld.javapattern.listener;

/**
 * @Author: wayyer
 * @Description: the observer of listener
 * @Program: HelloWorld
 * @Date: 2019.05.12
 */
public class Observer1 {


    MouseListener[] mouseListener = new MouseListener[5];
    int index = 0;


    public void addListener(MouseListener mouseListener) {
        this.mouseListener[index++] = mouseListener;
    }

    public void clickObserver1(){

        //调用所有listener
        for (int i = 0; i < this.index; i++) {
            this.mouseListener[i].click();
        }

    }

    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();
        observer1.addListener(new MouseListener() {
            @Override
            public void click() {
                System.out.println("click me for first inner analymous class");
            }
        });

        observer1.addListener(new MouseListener() {
            @Override
            public void click() {
                System.out.println("click me for second inner analymous class");
            }
        });

        observer1.clickObserver1();
    }


}
