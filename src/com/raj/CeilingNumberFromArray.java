package com.raj;

public class CeilingNumberFromArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = new int[]{2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (target == middleValue) {
                ans = target;
                break;
            } else if (start == end) {
                ans = nums[start + 1];
                break;
            } else if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println("Target value = " + ans);
    }
}
