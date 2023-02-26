package com.raj;

import java.util.Scanner;

public class BinarySearchProgram extends HelperClass {
    public static void main(String[] args) {

        // Take the input from the user with provided validation.
        int[] arr = takeInputAndReturnArray(1, 11);

        // Sort the user provided array.
        bubbleSorting(arr);
    }
}
