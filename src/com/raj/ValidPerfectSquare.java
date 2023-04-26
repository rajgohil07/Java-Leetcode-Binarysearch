/*
Valid Perfect Square
Link: https://leetcode.com/problems/valid-perfect-square/

Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

Example 1:
Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:
Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

Constraints:
1 <= num <= 231 - 1
 */
package com.raj;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        // Initialization.
        int num = 16;
        int start = 0;
        int end = 46340;
        int value = -1;
        boolean ans = false;

        // Logic.
        while (start <= end) {
            int middleValue = start + (end - start) / 2;
            if (middleValue*middleValue == num) {
                ans = true;
                value = middleValue;
                break;
            } else if (middleValue*middleValue > num) {
                end = middleValue - 1;
            } else {
                start = middleValue + 1;
            }
        }

        // Display the result.
        if (!ans) {
            System.out.println("Sorry, the provided target number " + num + " is not a valid square number.");
        } else {
            System.out.println("The provided target number " + num + " is a valid square number of value: " + value + ".");
        }
    }
}
