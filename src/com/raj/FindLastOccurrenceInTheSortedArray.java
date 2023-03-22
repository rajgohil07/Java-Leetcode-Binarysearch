package com.raj;

public class FindLastOccurrenceInTheSortedArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {1, 3, 3, 3, 3, 3, 4, 5, 8, 9, 10, 11};
        int target = 3;
        int start = 0;
        int end = nums.length - 1;

        // Binary search logic.
        while (start != end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                if (start == middle) {
                    break;
                } else {
                    start = middle;
                }
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (nums[start] != target) {
            start = -1;
        }

        // Display the result.
        if (start == -1) {
            System.out.println("Sorry target element " + target + " does not exists in the given array.");
        } else {
            System.out.println("The last occurrence of " + target + " is founded the the " + start + " index.");
        }
    }
}
