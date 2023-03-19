package com.raj;

public class FindFirstTargetInMountainArray {
    public static void main(String[] args) {
        // Initialization.
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int ans = -1;

        /*
          Logic: Get the max value index from mountain array.
          Explanation: Split the array into two parts from the peak index.
          So first split we can search for element in the ascending order.
          and in another last split we can search for element in the descending order.
        */
        int mountainIndex = findMountainIndex(arr);
        ans = binarySearchAscendingOrder(arr, 0, mountainIndex, target);
        if (ans == -1) {
            ans = binarySearchDescendingOrder(arr, mountainIndex + 1, arr.length - 1, target);
        }

        // Display the result.
        if (ans == -1) {
            System.out.println("Sorry the target " + target + " does not exist in the given array.");
        } else {
            System.out.println("The given target " + target + " is exist in the array at " + ans + " index.");
        }

    }

    // Function to find the mountain index from the array. mountain index is the index of the largest element value from the array.
    private static int findMountainIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mountainIndex = 0;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            /*
             if middle value is set to 0 index then increment middle and index.
             Because it will throw error when we search for middle = 0
             Which is middle - 1 = -1, and -1 index does not exist.
             */
            if (middle == 0) {
                middle = middle + 1;
                end = end + 1;
            }

            int middleValue = arr[middle];
            if (middleValue > arr[middle - 1] && middleValue > arr[middle + 1]) {
                mountainIndex = middle;
                break;
            } else if (middleValue > arr[middle - 1]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return mountainIndex;
    }

    // Binary search in the ascending order.
    private static int binarySearchAscendingOrder(int[] arr, int start, int end, int target) {
        int targetIndex = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];

            if (middleValue > target) {
                end = middle - 1;
            } else if (middleValue < target) {

                start = middle + 1;


            } else {
                targetIndex = middle;
                break;
            }
        }
        return targetIndex;
    }

    // Binary search in the descending order.
    private static int binarySearchDescendingOrder(int[] arr, int start, int end, int target) {
        int targetIndex = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];
            if (middleValue > target) {
                start = middle + 1;
            } else if (middleValue < target) {
                end = middle - 1;
            } else {
                targetIndex = middle;
                break;
            }
        }
        return targetIndex;
    }
}
