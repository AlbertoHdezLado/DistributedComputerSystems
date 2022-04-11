package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Lab2 {
    static String name;
    static int ID = 0;
    static ArrayList<Integer> array;
    static Vector<Integer> v;
    public static void myinfo() {
        Scanner input = new Scanner(System.in);

        System.out.print("Type your name: ");
        name = input.nextLine();

        try {
            System.out.print("Type your Student ID: ");
            ID = input.nextInt();
        } catch (Exception ex) {
            System.out.println("Error. Wrong format.");
        }
    }

    public static void arraylist() {
        array = new ArrayList<>();
        System.out.println("ArrayList content:");
        for (int i = 0; i < 5 ; i++) {
            array.add((int) (Math.random() * 10) + 1);
            System.out.println("El valor del elemento " + i + " es " + array.get(i));
        }
    }

    public static void vector() {
        v = new Vector<Integer>(5);
        System.out.println("Vector content:");
        for (int i = 0; i < 10 ; i++) {
            v.add((int) (Math.random() * 10) + 1);
            System.out.println("El valor del elemento " + i + " es " + v.get(i));
        }
    }

}
