/*
Binary Search
Link: https://leetcode.com/problems/binary-search/

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */
package com.raj;

public class BinarySearch {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                ans = middle;
                break;
            } else if (middleValue > target) {
                end = middle - 1;

            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        if (ans == -1) {
            System.out.println("Sorry, the provided target " + target + " does not exist in the provided array.");
        } else {
            System.out.println("The provided target " + target + " is exist at the " + ans + " position.");
        }
    }
}
