package main.java.com.wayyer.HelloWorld.lambda;

import java.util.function.BiConsumer;

//lesson 18
public class ExceptionHandlingSolution {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int key = 0;

        process(numbers, key, (va, k) -> {
            try{
                System.out.println(va / k);

            }catch (Exception e){
                System.out.println("arithmetic exception!");
            }

        });



    }

    public static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : numbers){
            consumer.accept(i, key);
        }
    }
}
