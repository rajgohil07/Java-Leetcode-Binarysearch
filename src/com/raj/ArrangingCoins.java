/*
Arranging Coins
Link: https://leetcode.com/problems/arranging-coins/

You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 */
package com.raj;

public class ArrangingCoins {
    public static void main(String[] args) {
        // Initialization.
        int n = 1804289383;
        int start = 0;
        int end = n;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            long middleValue = (long) middle * (middle + 1) / 2;
            if (middleValue > n) {
                end = middle - 1;
            } else if (middleValue == n) {
                end = middle;
                break;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println(end + " perfect rows can be created with the " + n + " coins.");
    }
}
