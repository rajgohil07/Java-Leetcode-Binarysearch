/*
Find in Mountain Array
Link: https://leetcode.com/problems/find-in-mountain-array/

(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

Constraints:
3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
 */
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
