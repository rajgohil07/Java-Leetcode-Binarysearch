package com.raj;

import java.util.Arrays;

public class BubbleSort {

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
}
