package com.raj;

import java.util.Arrays;
import java.util.Scanner;

public class HelperClass {

    // Sort the provided array using the bubble sort technique.
    protected static void bubbleSorting(int[] arr) {

        // Getting the array length.
        int arrLength = arr.length;

        for (int loopCounter = 0; loopCounter < arrLength; loopCounter++) {

            // Taking the first and second index.
            int previousIndex = 0;
            int index = 1;

            // Taking the boolean to break the for loop for the optimization.
            boolean isModificationMade = false;

            // While loop till current index less than the array length.
            while (index < arrLength) {

                // Get the values of the previous and current index.
                int valueAtPreviousIndex = arr[previousIndex];
                int valueAtIndex = arr[index];

                // If the previous index value is greater than current index value then flip thr values.
                if (valueAtPreviousIndex > valueAtIndex) {
                    arr[index] = valueAtPreviousIndex;
                    arr[previousIndex] = valueAtIndex;
                    isModificationMade = true;
                }

                // Increment the previous and current index values by one.
                index++;
                previousIndex++;
            }

            // If there were no modifications where made then simply break the outer for loop.
            if (!isModificationMade) {
                break;
            }
        }

        // Print the sorted array with the bubble sort technique.
        System.out.println("\n\nSorted array: " + Arrays.toString(arr));
    }

    // Take the user input with the min max array length validation.
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
