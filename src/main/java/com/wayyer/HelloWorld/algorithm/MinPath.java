package com.wayyer.HelloWorld.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayyer
 * @Description: the minium path among two points
 * @Program: HelloWorld
 * @Date: 2019.05.10
 */
public class MinPath {
    private static int INF = Integer.MAX_VALUE;
    //dist[i][j]=INF<==>i 和 j之间没有边
    private int[][] dist;
    //顶点i 到 j的最短路径长度，初值是i到j的边的权重
    private int[][] path;
    private List<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        MinPath graph = new MinPath(5);
        int[][] matrix =
                {{INF, 30, INF, 10, 50}, {INF, INF, 60, INF, INF}, {INF, INF, INF, INF, INF}, {INF, INF, INF, INF, 30},
                        {50, INF, 40, INF, INF},};
        /* 最下面的图
		int[][] matrix = {
    {0 ,20,INF,INF,20,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {20,0 ,30,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,30,0 ,20,INF,30,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,20,0 ,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {20,INF,INF,INF,0 ,10,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,30,INF,10,0 ,20,50,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,20,0 ,40,10,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,50,40,0 ,INF,20,20,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,10,INF,0 ,20,INF,INF,INF,30,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,20,20,0 ,20,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,20,INF,20,0 ,20,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,0 ,10,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,10,0 ,INF,INF,20,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,30,INF,INF,INF,INF,0 ,20,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,0 ,20,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,INF,20,0 ,40},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,40,0 }
    };
    */

        int begin = 0;
        int end = 4;
        graph.findCheapestPath(begin, end, matrix);
        List<Integer> list = graph.result;
        System.out.println(begin + " to " + end + ",the cheapest path is:");
        System.out.println(list.toString());
        System.out.println(graph.dist[begin][end]);
    }

    public void findCheapestPath(int begin, int end, int[][] matrix) {
        floyd(matrix);
        result.add(begin);
        findPath(begin, end);
        result.add(end);
    }

    public void findPath(int i, int j) {
        int k = path[i][j];
        if (k == -1) {
            return;
        }
        findPath(i, k);   //递归
        result.add(k);
        findPath(k, j);
    }

    public void floyd(int[][] matrix) {
        int size = matrix.length;
        //initialize dist and path
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path[i][j] = -1;
                dist[i][j] = matrix[i][j];
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] != INF &&
                            dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }

    }

    public MinPath(int size) {
        this.path = new int[size][size];
        this.dist = new int[size][size];
    }


}
