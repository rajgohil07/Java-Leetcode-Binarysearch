/*
Find Target Indices After Sorting Array
Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

Example 1:
Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

Example 2:
Input: nums = [1,2,5,2,3], target = 3
Output: [3]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 3 is 3.

Example 3:
Input: nums = [1,2,5,2,3], target = 5
Output: [4]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 5 is 4.

Constraints:
1 <= nums.length <= 100
1 <= nums[i], target <= 100
 */
package com.raj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {1, 2, 5, 2, 3};
        int target = 3;
        int[] indices = {-1, -1};
        List<Integer> ans = new ArrayList<>();

        // Logic.
        // Sort the array.
        Arrays.sort(nums);
        // Get the left most target element via the binary search.
        indices[0] = binarySearch(0, nums.length - 1, target, nums, true);
        if (indices[0] != -1) {
            indices[1] = binarySearch(indices[0] , nums.length - 1, target, nums, false);
            if (indices[1] != -1) {
                for (int i = indices[0]; i <= indices[1]; i++) {
                    ans.add(i);
                }
            } else {
                ans.add(indices[0]);
            }
        }

        // Display the result.
        System.out.println("The Target Indices After Sorting Array is: " + ans + " where the target value was " + target + ".");
    }

    // Binary search program to find the target with provided start and end indexes.
    private static int binarySearch(int start, int end, int target, int[] arr, boolean searchInLeft) {
        int ans;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];
            if (middleValue > target) {
                end = middle - 1;
            } else if (middleValue == target) {
                if (searchInLeft) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                start = middle + 1;
            }
        }
        if (searchInLeft) {
            ans = start;
        } else {
            ans = end;
        }
        if (arr[ans] != target) {
            ans = -1;
        }
        return ans;
    }
}
