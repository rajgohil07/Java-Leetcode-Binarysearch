/*
Peak Index in a Mountain Array
Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
package com.raj;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        // Initialization.
        int[] arr = {0, 10, 5, 2};
        int ans = 0;
        int start = 0;
        int end = arr.length - 1;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
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
