/*
Longest Subsequence With Limited Sum
Link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/

You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.

Example 2:
Input: nums = [2,3,4,5], queries = [1]
Output: [0]
Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.

Constraints:
n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 106
 */
package com.raj;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};

        // Logic: Sort the array.
        Arrays.sort(nums);

        // Prefix the sum i.e. 1, 3, 5 becomes the 1, 4, 9.
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        System.out.println("Prefix sum array: " + Arrays.toString(nums));

        // Perform the binary search to find the floor. i.e. 23. becomes the 23 and 23 does not exist then it will look for the 22 and so on.
        for (int i = 0; i < queries.length; i++) {
            queries[i] = getFloorValueOfBinarySearch(nums, queries[i]);
        }

        // Display the result.
        System.out.println("Longest subsequence with limit sum: " + Arrays.toString(queries));
    }

    private static int getFloorValueOfBinarySearch(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                index = middle;
                break;
            } else if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        if (index == -1) {
            if (end != -1) {
                index = end + 1;
            } else {
                index = 0;
            }
        } else {
            index++;
        }
        return index;
    }
}
