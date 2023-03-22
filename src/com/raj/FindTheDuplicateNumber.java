/*
Find the Duplicate Number
Link: https://leetcode.com/problems/find-the-duplicate-number/description/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
package com.raj;

import java.util.Arrays;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {2, 2, 2, 2, 2};
        int ans = 0;

        // Sort the array.
        Arrays.sort(nums);

        // Logic.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }

        // Display the result.
        System.out.println("Duplicate is " + ans + " in the array.");
    }
}
