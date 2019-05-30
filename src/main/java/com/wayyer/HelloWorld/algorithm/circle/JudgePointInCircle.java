package com.wayyer.HelloWorld.algorithm.circle;

import com.wayyer.HelloWorld.algorithm.triangle.Point;

/**
 * @Author: wayyer
 * @Description: judge a point is in a circle
 * @Program: HelloWorld
 * @Date: 2019.05.30
 */
public class JudgePointInCircle {

    public static void main(String[] args) {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 2);

        Point point = new Point(1,1);

        boolean isInCircle = isInCircle(circle, point);
        System.out.println("isInCircle = " + isInCircle);
    }

    /**
     * 圆心到点之间的距离，小于等于半径，就是在圆内，否则外
     * @param circle
     * @param point
     * @return
     */
    public static boolean isInCircle(Circle circle, Point point){
        Point center = circle.getCenter();
        double radius = circle.getRadius();
        double centerX = center.getX();
        double centerY = center.getY();

        double pointX = point.getX();
        double pointY = point.getY();

        double lengthX = pointX - centerX;
        double lengthY = pointY - centerY;

        double length = Math.sqrt(lengthX*lengthX + lengthY*lengthY);
        System.out.println("length = " + length);


        return radius > length ;

    }


}
