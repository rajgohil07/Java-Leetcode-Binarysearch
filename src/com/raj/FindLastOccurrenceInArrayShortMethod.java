package com.raj;

public class FindLastOccurrenceInArrayShortMethod {
    public static void main(String[] args) {

        // Initialization.
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int target = 3;
        int start = 0;
        int end = arr.length - 1;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];
            if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println("The last occurrence of " + target + " value exist at " + end + " position.");

    }
}
