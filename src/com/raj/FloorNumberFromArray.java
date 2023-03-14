package com.raj;

public class FloorNumberFromArray {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = new int[]{2, 3, 5, 9, 14, 16, 18};
        int target = 8;
        int start = 0;
        int end = nums.length - 1;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (target == middleValue) {
                end = middle;
                break;
            } else if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println("Target value = " + nums[end]);
    }
}
