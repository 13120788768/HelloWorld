package com.wayyer.HelloWorld.javapattern.prototype;

/**
 * @Author: wayyer
 * @Description: abstract class
 * @Program: HelloWorld
 * @Date: 2019.06.11
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
