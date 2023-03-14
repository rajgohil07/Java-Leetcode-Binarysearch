/*
Find Smallest Letter Greater Than Target
Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

Example 3:
Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

Constraints:
2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */
package com.raj;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        // Initialization.
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'a';
        char ans = letters[0];

        // Logic.
        if (target < letters[letters.length - 1]) {
            ans = getSmallerLatterWhichGreaterThanTarget(letters, target);
        }

        // Display the answer.
        System.out.println("The smallest letter which is greater than the target '" + target + "' is: '" + ans + "'");
    }

    private static char getSmallerLatterWhichGreaterThanTarget(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            // Initialization.
            int middle = start + (end - start) / 2;
            char currentVal = letters[middle];

            // if target and middle values are same.
            if (currentVal == target) {
                return letters[middle + 1];
            }

            // if middle value is greater than the target value.
            else if (currentVal > target) {
                end = middle - 1;
            }

            // When the middle value is less than the target value.
            else {
                start = middle + 1;
            }
        }

        // Return the start values means small values which is greater than the target value.
        return letters[start];
    }
}
