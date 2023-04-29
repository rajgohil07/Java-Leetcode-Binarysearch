/*
Sqrt(x)
Link: https://leetcode.com/problems/sqrtx/

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

Constraints:
0 <= x <= 231 - 1
 */
package com.raj;

public class Sqrt {
    public static void main(String[] args) {
        // Initialization.
        int x = 4;
        int start = 0;
        int end = x;

        // Logic.
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (middle == x / middle) {
                end = middle;
                break;
            } else if (middle > x / middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Display the result.
        System.out.println("The nearest integer value of square root: " + x + " is " + end+".");
    }
}
