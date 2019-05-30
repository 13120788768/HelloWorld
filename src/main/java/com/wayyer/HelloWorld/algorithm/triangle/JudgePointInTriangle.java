package com.wayyer.HelloWorld.algorithm.triangle;

/**
 * @Author: wayyer
 * @Description: judge a point is in trangle or not
 * @Program: HelloWorld
 * @Date: 2019.05.30
 */
public class JudgePointInTriangle {

    public static void main(String[] args) {
        Point A = new Point(0, 0);
        Point B = new Point(2, 0);
        Point C = new Point(0, 2);

        Triangle triangle = new Triangle(A, B, C);

        System.out.println("triangle.areas() = " + triangle.areas());

        Point point = new Point(0.1, 0.1);

        boolean isIn = isInTriangle(triangle, point);
        System.out.println("isIn = " + isIn);
        

    }

    public static boolean isInTriangle(Triangle triangle, Point point){
        System.out.println("triangleABC = " + triangle);
        double triangleABC_areas = triangle.areas();
        System.out.println("triangleABC_areas = " + triangleABC_areas);
        
        Point A = triangle.getA();
        Point B = triangle.getB();
        Point C = triangle.getC();

        Triangle triangleABP = new Triangle(A, B, point);
        System.out.println("triangleABP = " + triangleABP);
        double triangleABP_areas = triangleABP.areas();
        System.out.println("triangleABP_areas = " + triangleABP_areas);

        Triangle triangleBCP = new Triangle(B, C, point);
        System.out.println("triangleBCP = " + triangleBCP);
        double triangleBCP_areas = triangleABP.areas();
        System.out.println("triangleBCP_areas = " + triangleBCP_areas);

        Triangle triangleCAP = new Triangle(C, A, point);
        System.out.println("triangleCAP = " + triangleCAP);
        double triangleCAP_areas = triangleABP.areas();
        System.out.println("triangleCAP_areas = " + triangleCAP_areas);
        double minus = (triangleABP_areas + triangleBCP_areas + triangleCAP_areas) - triangleABC_areas;
        System.out.println("minus = " + minus);
        
        return (minus / triangleABC_areas) <= 0.00001;
    }


}
