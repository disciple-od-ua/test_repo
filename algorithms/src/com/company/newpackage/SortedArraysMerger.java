package com.company.newpackage;

import java.util.ArrayList;

/**
 * Created by apeshkov on 26.10.2015.
 */
public class SortedArraysMerger {

    public static void main(String[] args) {
        int[] a = {1, 1, 6, 17, 31};
        int[] b = {1, 4, 5, 25};
        print(merge(a, b));
    }


   public static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstIndex = 0 , secondIndex = 0, resultIndex = 0;
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                result[resultIndex++] = first[firstIndex++];
            } else {
                result[resultIndex++] = second[secondIndex++];
            }
        }

        while (firstIndex < first.length) {
            result[resultIndex++] = first[firstIndex++];
        }

        while (secondIndex < second.length) {
            result[resultIndex++] = second[secondIndex++];
        }

        return result;
    }

    public static void print(int[] arr) {
        for (int el : arr) {
            System.out.print(el);
            System.out.print(" ");
        }
        System.out.println();
    }
}
