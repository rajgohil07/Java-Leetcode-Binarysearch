/*
Intersection of Two Arrays
Link: https://leetcode.com/problems/intersection-of-two-arrays/

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
package com.raj;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        // Initialization.
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Set<Integer> ans = new LinkedHashSet<>();

        // Sort the both array.
        bubbleSorting(nums1);
        bubbleSorting(nums2);

        // Logic.
        if (nums1.length > nums2.length) {
            for (int i : nums2) {
                int index = binarySearch(nums1, i);
                if (index != -1) {
                    ans.add(i);
                }
            }
        } else {
            for (int i : nums1) {
                int index = binarySearch(nums2, i);
                if (index != -1) {
                    ans.add(i);
                }
            }
        }

        int[] finalAnswer = new int[ans.size()];
        int i=0;

        for (int s:ans) {
            finalAnswer[i++] = s;
        }

        // Display the result.
        System.out.println("Intersection of Two Arrays: " + Arrays.toString(finalAnswer));
    }

    // To perform the binary search and return the target index.
    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                index = middle;
                break;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return index;
    }

    // Sort the provided array using the bubble sort technique.
    private static void bubbleSorting(int[] arr) {

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
    }
}
