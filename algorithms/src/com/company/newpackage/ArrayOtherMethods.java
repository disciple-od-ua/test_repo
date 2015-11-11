package com.company.newpackage;

/**
 * Created by apeshkov on 29.10.2015.
 */
public class ArrayOtherMethods {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArraySort.print(arr);
        reverse(arr, 0, arr.length - 1);
        ArraySort.print(arr);
        rotate(arr, 2);
        ArraySort.print(arr);
    }

    public static void doNothing() {
        System.out.println("Doing nothing");
		System.out.println("Doing nthg");
		System.out.println("Doing nothing at all");
    }

    public static void rotate(int[] arr, int order) {

        if(arr == null || order < 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        order = order % arr.length;

        int a = arr.length - order;

        reverse(arr, 0, a - 1);
        reverse(arr, a, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }

    public static void reverse(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int i = start;
        int j = end;

        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
