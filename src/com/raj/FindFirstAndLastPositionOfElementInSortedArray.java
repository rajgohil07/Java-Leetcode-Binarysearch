/*
Find First and Last Position of Element in Sorted Array.
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
package com.raj;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int length = nums.length;
        int[] ans = new int[]{-1, -1};
        int start = 0;
        int end = length - 1;

        // Manual checking if the array length is 1.
        if (length == 1) {
            if (nums[0] == target) {
                ans[0] = 0;
                ans[1] = 0;
            }
        } else if (length > 1) {
            while (start <= end) {
                int middle = start + (end - start) / 2;
                int middleValue = nums[middle];
                // if value is found then move index left and right to get the start and end position of the array.
                if (middleValue == target) {
                    // Find the end index for the target by moving right from the middle index.
                    for (int i = middle + 1; i < length; i++) {
                        if (nums[i] > target) {
                            ans[1] = i - 1;
                            break;
                        }
                    }
                    // Find the start index for the target by moving left from the middle index.
                    for (int i = middle - 1; i >= 0; i--) {
                        if (nums[i] < target) {
                            ans[0] = i + 1;
                            break;
                        }
                    }
                    break;
                }
                // if middle value is greater than the target value.
                else if (middleValue > target) {
                    end = middle - 1;
                }
                // When the middle value is less than the target value.
                else {
                    start = middle + 1;
                }
            }
        }

        // Display the result.
        System.out.println("Start position: " + ans[0] + " | End position: " + ans[1]);
    }
}
