package com.company.newpackage;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by apeshkov on 29.10.2015.
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] arr = {"4", "13", "5", "/", "+"};
        int res = evaluate(arr);
        System.out.println("Result: " + res);
    }

    public static int evaluate(String[] expression) {
        int returnValue = 0;
        String operations="+-*/";
        LinkedList<String> stack = new LinkedList<>();

        for (String ex : expression) {
            if (!operations.contains(ex)) {
                stack.push(ex);
            } else {
                int o2 = Integer.parseInt(stack.pop());
                int o1 = Integer.parseInt(stack.pop());

                switch (ex) {
                    case "+" :
                        stack.push(String.valueOf(o1 + o2));
                        break;
                    case "-" :
                        stack.push(String.valueOf(o1 - o2));
                        break;
                    case "*" :
                        stack.push(String.valueOf(o1 * o2));
                        break;
                    case "/" :
                        stack.push(String.valueOf(o1 / o2));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }
}
