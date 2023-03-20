/*
Maximum Count of Positive Integer and Negative Integer
Link: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.

Example 1:
Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

Example 2:
Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

Example 3:
Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
 */
package com.raj;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
//        int[] nums = {-2, -1, -1, 1, 2};
//        int[] nums = {-21, -13, -11};
//        int[] nums = {2, 11, 111};
        int[] nums = {-2, 0, 0, 0, 11, 111};
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        int positive = 0;
        int negative = 0;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];

            if (middleValue == 0) {
                index = middle;
                break;
            } else if (middleValue > 0) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // if zero element does not found.
        if (index == -1) {
            // All values are positive.
            if (end == -1) {
                positive = nums.length;
            }
            // All values are negative.
            else if (start == nums.length) {
                negative = nums.length;
            }
            // Else find positive and negative both values but not zero.
            else {
                positive = nums.length - start;
                negative = start;
            }
        }
        // if zero element is found so index value should not be zero.
        else {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] > 0) {
                    positive = nums.length - i;
                    break;
                }
            }
            for (int i = index; i >= 0; i--) {
                if (nums[i] < 0) {
                    negative = nums.length - 1;
                    break;
                }
            }
        }

        // Display the result.
        System.out.println(index + " index");
        System.out.println(start + " start");
        System.out.println(end + " end");
        if (negative <= positive) {
            System.out.print("\nMaximum number between positive and negative number is: " + positive);
        } else {
            System.out.print("\nMaximum number between positive and negative number is: " + negative);
        }
    }
}
