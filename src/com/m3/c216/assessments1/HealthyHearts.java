package com.m3.c216.assessments1;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("What is your age? ");
        int age = input.nextInt();

        int maxHeartRate = 220 - age;
        int maxTargetHeartRateZone = (maxHeartRate/ 100)*145;
        int minTargetHeartRateZone = (maxHeartRate/ 100)*85;

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + minTargetHeartRateZone + " - " + maxTargetHeartRateZone + " beats per minute.");


    }
}
