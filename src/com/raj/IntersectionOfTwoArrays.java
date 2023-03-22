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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        // Initialization.
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        ArrayList<Integer> ans = new ArrayList<>();

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

        // Remove the duplicates from the array.
        Set<Integer> set = new LinkedHashSet<>(ans);

        // Clear the ans array list.
        ans.clear();

        // Add the set list to the ans array list.
        ans.addAll(set);

        int[] finalAnswer = new int[ans.size()];

        for (int i = 0; i < finalAnswer.length; i++) {
            finalAnswer[i] = ans.get(i);
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
}
