package com.wayyer.HelloWorld.algorithm.circle;

import com.wayyer.HelloWorld.algorithm.triangle.Point;

/**
 * @Author: wayyer
 * @Description: circle
 * @Program: HelloWorld
 * @Date: 2019.05.30
 */
public class Circle {

    private Point center = new Point(0, 0);
    private double radius = 1;

    public Circle(){}

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
