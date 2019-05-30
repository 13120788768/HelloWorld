package com.wayyer.HelloWorld.algorithm.triangle;

/**
 * @Author: wayyer
 * @Description: a triangle
 * @Program: HelloWorld
 * @Date: 2019.05.30
 */
public class Triangle {
    private Point A;

    private Point B;

    private Point C;

    public Triangle(){}

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        A.setX(x1);
        A.setY(y1);

        B.setX(x2);
        B.setY(y2);

        C.setX(x3);
        C.setY(y3);
    }

    /**
     * 海伦公式
     * s=(a+b+c)/2;
     * area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
     * @return
     */
    public double areas(){
        double x1=A.getX(),y1=A.getY(),x2=B.getX(),y2=B.getY(),x3=C.getX(),y3=C.getY();
        double s1=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        double s2=Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
        double s3=Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
        double p=(s1+s2+s3)/2;
        double a=Math.sqrt(p*(p-s1)*(p-s2)*(p-s3));
        return a;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
