package com.m3.c216.assessments1;
import java.util.*;

public class DogGenetics {
    public static void main(String[] args) {

        //user input
        Scanner dog = new Scanner(System.in);
        System.out.printf("What is your dog's name? ");
        String dogName = dog.nextLine();
        System.out.println("Well then, I have this highly reliable report on " +dogName+ "'s prestigious background right here. ");
        System.out.println(" ");
        System.out.println(dogName + " is: ");

        //assign a random percentage
        Random rand = new Random();
        float p1 = rand.nextFloat();
        float p2 = rand.nextFloat();
        float p3 = rand.nextFloat();
        float p4 = rand.nextFloat();
        float p5 = rand.nextFloat();
        float sum = p1 + p2 + p3 + p4 + p5;

        //assign a random breed
        int breed1 = Math.round((p1*100)/sum);
        int breed2 = Math.round((p2*100)/sum);
        int breed3 = Math.round((p3*100)/sum);
        int breed4 = Math.round((p4*100)/sum);
        int breed5 = Math.round((p5*100)/sum);

        System.out.println(breed1 + "% St. Bernard");
        System.out.println(breed2 + "% Chihuahua");
        System.out.println(breed3 + "% Dramatic RedNosed Asian Pug");
        System.out.println(breed4 + "% Common Cur");
        System.out.println(breed5 + "% King Doberman");

    }

}
