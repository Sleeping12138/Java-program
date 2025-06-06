package com.ojtest.demo;

import java.util.Arrays;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array = new int[10][10];
        Arrays.sort(array, (int[] a, int[] b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
    }
}
