/*
The K Weakest Rows in a Matrix
Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:
Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:
Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].

Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */
package com.raj;

import java.util.Arrays;

public class TheKWeakestRowsInMatrix {
    public static void main(String[] args) {
        // initialization.
        int[][] mat = {
                {1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int k = 4;
        int[] temp = new int[mat.length];
        int[] temp1 = new int[mat.length];
        int[] ans = new int[k];

        // Logic.
        for (int i = 0; i < mat.length; i++) {
            int count = find1sInTheArray(mat[i]);
            temp[i] = count;
            temp1[i] = count;
        }

        // Display the number of 1s in the array.
        System.out.println("Number of 1s in the array: " + Arrays.toString(temp));

        // Make a copy of an array.
        temp1 = Arrays.copyOf(temp, temp.length);

        // Sort the array.
        Arrays.sort(temp);

        for (int i = 0; i < k; i++) {
            for (int j = 0; i < temp1.length; j++) {
                if (temp[i] == temp1[j]) {
                    ans[i] = j;
                    temp1[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        // Display the answer.
        System.out.println("The weakest row in the matrix by the given k " + k + " is: " + Arrays.toString(ans));
    }

    private static int find1sInTheArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleValue = nums[middle];
            if (middleValue == 0) {
                index = middle;
                break;
            }
            if (middleValue > 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (index == -1) {
            index = nums.length;
        } else {
            if (nums[0] != 1) {
                index = -1;
            } else {
                for (int i = index - 1; i >= 0; i--) {
                    if (nums[i] == 1) {
                        index = i + 1;
                        break;
                    }
                }
            }
            if (index == -1) {
                index++;
            }
        }
        return index;
    }

}
