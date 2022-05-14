package com.m3.c216.assessments1;

import java.util.stream.IntStream;

public class SummativeSums {
    static int[] intArray1  = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
    static int[] intArray2  = { 999, -60, -77, 14, 160, 301 };
    static int[] intArray3  = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };

    public static void main(String[] args){

        int sum1 = IntStream.of(intArray1).sum();
        int sum2 = IntStream.of(intArray2).sum();
        int sum3 = IntStream.of(intArray3).sum();
        System.out.printf("#1 Array sum: " + sum1+ "%n" + "#2 Array sum: " + sum2 + "%n" + "#3 Array sum: " + sum3);

    }
}
