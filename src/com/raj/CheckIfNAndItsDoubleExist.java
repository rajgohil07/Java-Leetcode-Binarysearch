/*
Check If N and Its Double Exist
Link: https://leetcode.com/problems/check-if-n-and-its-double-exist/

Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

Constraints:
2 <= arr.length <= 500
-103 <= arr[i] <= 103
 */
package com.raj;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        // Initialization.
        int[] arr = {10, 2, 5, 3};
        int counter = 0;
        boolean ans = false;
        int value = 0;

        // Logic.
        // Sort the array first.
        Arrays.sort(arr);
        while (!ans && counter < arr.length) {
            value = arr[counter];
            // Perform the binary search action to find the doubles of its value.
            ans = findDoubleExist(arr, 2 * arr[counter]);
            counter++;
        }

        // Display the result.
        if (ans) {
            System.out.println("Yes, " + (value * 2) + " is the double of the value " + value + " in the provided array.");
            System.out.println("Array: " + Arrays.toString(arr));
        } else {
            System.out.println("Sorry there is no value exist which is double of its value in the provided array.");
            System.out.println("Array: " + Arrays.toString(arr));
        }
    }

    // Function to perform the binary search action to find the doubles of its value.
    private static boolean findDoubleExist(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isFound = false;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];
            if (middleValue == target) {
                isFound = true;
                break;
            } else if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return isFound;
    }
}
