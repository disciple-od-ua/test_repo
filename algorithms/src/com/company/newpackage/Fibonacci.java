package com.company.newpackage;

/**
 * Created by apeshkov on 26.10.2015.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));

        for (int i = 1; i <= 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int number) {
        //int a = 1, b = 1, c = 1;

        if (number == 1 || number == 2) {
            return 1;
        } else {
            return fibonacci(number - 2) + fibonacci(number - 1);
        }
    }
}
