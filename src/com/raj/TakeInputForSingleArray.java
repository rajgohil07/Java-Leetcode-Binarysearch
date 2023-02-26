package com.raj;

import java.util.Scanner;

public class TakeInputForSingleArray {
    protected static int[] takeInputAndReturnArray(int min, int max) {
        System.out.print("Enter the number for the length of the array: ");
        Scanner input = new Scanner(System.in);
        int arrayLength = input.nextInt();

        // Take the input from the user again if he enters the invalid input.
        while (arrayLength < min || max < arrayLength) {
            System.out.print("Please the valid input type between the " + min + " and " + max + ": ");
            arrayLength = input.nextInt();
        }

        // Initialize the array as per the user's input length.
        int[] arr = new int[arrayLength];

        // Store the values into the array
        for (int index = 0; index < arrayLength; index++) {
            System.out.print("Please input the value for the " + index + " element: ");
            arr[index] = input.nextInt();
        }

        // Return the user inputted array.
        return arr;
    }
}
