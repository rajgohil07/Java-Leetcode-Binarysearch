/*
Find position of an element in a sorted array of infinite numbers
Link: https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 */
package com.raj;

public class FindPositionOfAnElementInASortedArrayOfInfiniteNumbers {
    public static void main(String[] args) {
        // Initialization.
        int[] nums = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33,
                36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69,
                72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105,
                108, 111, 114, 117, 120, 123, 126, 129, 132, 135, 138, 141,
                144, 147, 150, 153, 156, 159, 162, 165, 168, 171, 174, 177,
                180, 183, 186, 189, 192, 195, 198, 201, 204, 207, 210, 213, 216,
                219, 222, 225, 228, 231, 234, 237, 240, 243, 246, 249, 252,
                255, 258, 261, 264, 267, 270, 273, 276, 279, 282, 285, 288,
                291, 294, 297, 300, 339, 342, 345, 348, 351, 354, 357, 360,
                363, 366, 369, 372, 375, 378, 381, 384, 387, 390, 393, 396,
                399, 402, 405, 408, 411, 414, 417, 420, 423, 426, 429, 432, 435, 438, 441, 444,
                447, 450, 453, 456, 459, 462, 465, 468, 471, 474, 477, 480,
                483, 486, 489, 492, 495, 498, 501, 504, 507, 510, 513, 516,
                519, 522, 525, 528, 531, 534, 537, 540, 543, 546, 549, 552,
                555, 558, 561, 564, 567, 570, 573, 576, 579, 582, 585, 588,
                591, 594, 597, 600};

        int start = 0;
        int end = 1;
        int target = 351;
        int ans = -1;

        // Get element in a chunk array.
        while (target > nums[end]) {
            int temp = end + 1;
            end = end + ((end - start + 1) * 2);
            start = temp;
        }

        // Binary search program.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                ans = middle;
                break;
            } else if (middleValue > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println("Index of the target element " + target + " is " + ans);
    }
}
