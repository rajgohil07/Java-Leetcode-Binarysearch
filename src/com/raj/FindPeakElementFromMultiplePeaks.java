/*
Find Peak Element
Link: https://leetcode.com/problems/find-peak-element/description/

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

Constraints:
1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */
package com.raj;

public class FindPeakElementFromMultiplePeaks {
    public static void main(String[] args) {
        // Initialization.
        int[] arr = {3, 5, 3, 2, 0};
        int ans = 0;
        int start = 0;
        int end = arr.length - 1;

        // Logic.
        if (end == 0) {
            ans = 0;
        } else if (end == 1) {
            if (arr[end] > arr[end - 1]) {
                ans = 1;
            } else {
                ans = 0;
            }
        } else {
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
                    ans = middle;
                    break;
                } else if (middleValue > arr[middle - 1]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }

        // Display the result.
        return ans;
    }
}
