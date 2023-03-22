/*
Single Element in a Sorted Array
Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 105
 */
package com.raj;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int start = 0;
        int end = nums.length - 1;

        // Logic.
        if (nums.length == 1) {
            start = nums[0];
        } else if (nums[0] != nums[1]) {
            start = nums[0];
        } else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            start = nums[nums.length - 2];
        } else {
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if (middle < 2) {
                    start = 2;
                    break;
                }
                int remainder = middle % 2;
                if (remainder == 0) {
                    if (nums[middle] == nums[middle + 1]) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                } else {
                    if (nums[middle] == nums[middle + 1]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            }

            // Display the result.
            System.out.println("Single element in the provided array is: " + nums[start]);
        }

    }
}
