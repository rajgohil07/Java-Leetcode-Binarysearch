/*
Search Insert Position
Link: https://leetcode.com/problems/search-insert-position/

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
package com.raj;

public class SearchInsertPosition {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int start = 0;
        int end = nums.length - 1;

        // Logic.
        if (nums[end] < target) {
            start = nums.length;
        } else {
            while (start <= end) {
                int middle = start + (end - start) / 2;
                int middleValue = nums[middle];
                if (middleValue == target) {
                    start = middle;
                    break;
                } else if (middleValue > target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }

        // Display the result.
        System.out.println("The target " + target + " can be insert at the " + start + " position.");
    }
}
