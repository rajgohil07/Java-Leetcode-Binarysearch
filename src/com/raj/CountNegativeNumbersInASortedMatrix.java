/*
Count Negative Numbers in a Sorted Matrix
Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 */
package com.raj;

public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        // Initialization.
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int count = 0;

        // Logic.
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] < 0) {
                count += (grid.length - i) * grid[0].length;
                break;
            }
            if (grid[i][grid[0].length - 1] > -1) {
                continue;
            }
            count += binarySearchDescendingOrder(grid[i]);
        }

        // Display the result.
        System.out.println("Number of negative counts in the grids are: " + count);
    }

    private static int binarySearchDescendingOrder(int[] grid) {
        int start = 0;
        int end = grid.length - 1;
        int index = -1;
        int counter = 0;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = grid[middle];
            if (middleValue == -1) {
                index = middle;
                break;
            } else if (middleValue > -1) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (index == -1) {
            index = start;
        }
        for (int i = index; i >= 0; i--) {
            if (grid[i] > -1) {
                counter = grid.length - (i + 1);
                break;
            }
        }
        return counter;
    }
}
