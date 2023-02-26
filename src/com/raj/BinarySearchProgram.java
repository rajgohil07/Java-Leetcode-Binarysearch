package com.raj;

import java.util.Scanner;

public class BinarySearchProgram extends BubbleSort{
    public static void main(String[] args) {
        System.out.print("Enter the number for the length of the array: ");
        Scanner input = new Scanner(System.in);
        int arrayLength = input.nextInt();

        // Take the input from the user again if he enters the invalid input.
        while (arrayLength < 1 || 11 < arrayLength) {
            System.out.print("Please the valid input type between the 1 and 11: ");
            arrayLength = input.nextInt();
        }

        // Initialize the array as per the user's input length.
        int[] arr = new int[arrayLength];

        // Store the values into the array
        for (int index = 0; index < arrayLength; index++) {
            System.out.print("Please input the value for the " + index + " element: ");
            arr[index] = input.nextInt();
        }

        // Sort the user provided array.
        bubbleSorting(arr);
    }
}
