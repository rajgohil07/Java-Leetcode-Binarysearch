/*
Peak Index in a Mountain Array
Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
package com.raj;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        // Initialization.
        int[] arr = {3, 5, 3, 2, 0};
        int ans = 0;
        int start = 0;
        int end = arr.length - 1;

        // Logic.
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
                ans = middle;
                break;
            } else if (middleValue > arr[middle - 1]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        // Display the result.
        System.out.println("Representation:");
        System.out.println("   " + arr[ans]);
        System.out.println(arr[ans - 1] + "      " + arr[ans + 1]);
        System.out.println("Mountain index of the array is: " + ans);
    }
}
