/*
Two Sum II - Input Array Is Sorted
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */
package com.raj;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        // initialization.
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new int[2];

        //Logic.
        for (int i = 0; i < numbers.length; i++) {
            int indexToFind = target - numbers[i];
            int index = binarySearch(numbers, indexToFind);
            if (index != -1) {
                ans[0] = i + 1;
                ans[1] = index + 1;
                break;
            }
        }

        // Display the result.
        System.out.println("Index: " + "[" + (ans[0] - 1) + ", " + (ans[1] - 1) + "].");
        System.out.println("Calculation: " + "'" + numbers[ans[0] - 1] + "'" + " + " + "'" + numbers[ans[1] - 1] + "'" + " = " + "'" + target + "'");
    }

    // Binary search.
    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;

            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
