package com.company.newpackage;

/**
 * Created by apeshkov on 28.10.2015.
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] a = {15, 2, 16, 5, 7, 3, 28, 2};
        print(a);
        mergesort(a);
        print(a);
    }

    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void mergesort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        mergesort(arr, 0, arr.length - 1);
    }

    public static void print(int[] arr) {
        for (int el : arr) {
            System.out.print(el);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void mergesort(int[] arr, int left, int right) {
        if (left < right) {

            int middle = left + (right - left) / 2;

            mergesort(arr, left, middle);
            mergesort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if (tmp[i] <= tmp[j]) {
                arr[k++] = tmp[i++];
            } else {
                arr[k++] = tmp[j++];
            }
        }

        while (i <= middle) {
            arr[k++] = tmp[i++];
        }

        while (j <= right) {
            arr[k++] = tmp[j++];
        }
    }
}
