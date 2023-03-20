/*
Search in Rotated Sorted Array
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */
package com.raj;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        int midIndex = 0;

        // Logic.
        if (end <= 1) {
            if (nums[1] == target) {
                ans = 1;
            } else if (nums[0] == target) {
                ans = 0;
            }
        } else {
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if (middle == 0) {
                    middle++;
                    end++;
                }
                int middleValue = nums[middle];
                if (middleValue > nums[middle + 1] && middleValue > nums[middle - 1]) {
                    midIndex = middle;
                    break;
                } else if (middleValue > nums[middle + 1]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            System.out.println("Array can be split with the index = " + midIndex);

            /*
             Binary search in the ascending order.
             Explanation: split the array into two from the midIndex so we can get the two ascending array.
             */
            ans = binarySearchAscendingOrder(nums, 0, midIndex, target);
            System.out.println("\nFirst array ascending order: " + "[" + 0 + "," + midIndex + "]");
            System.out.println("Second array ascending order: " + "[" + (midIndex + 1) + "," + (nums.length - 1) + "]");
            if (ans == -1) {
                ans = binarySearchAscendingOrder(nums, midIndex + 1, nums.length - 1, target);
            }
        }

        // Display the result.
        if (ans == -1) {
            System.out.println("\nTarget " + target + " does not exist in the given array.");
        } else {
            System.out.println("\nTarget " + target + " is exist in the array at the " + ans + " index.");
        }
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
}
