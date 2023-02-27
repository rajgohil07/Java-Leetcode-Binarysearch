package com.raj;

import java.util.Scanner;

public class BinarySearchProgram extends HelperClass {
    public static void main(String[] args) {

        // Used the scanner to input the data from the user.
        Scanner input = new Scanner(System.in);

        // Take the input from the user with provided validation.
        int[] arr = takeInputAndReturnArray(1, 11);

        // Sort the user provided array.
        bubbleSorting(arr);

        // Take the target input from the user.
        System.out.print("Enter the value to search inside the array: ");
        int target = input.nextInt();

        // Taking the variables for the binary search.
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2; // it's similar to the (start+end)/2

        // Default index value of the target element.
        int index = -1;

        // Loop till the start index is less than or equal to the end index.
        while (start <= end) {

            // If middle and target value is the same.
            if (target == arr[middle]) {
                index = arr[middle];
                break;
            }

            // if target value is greater than the middle pointer value.
            else if (target > arr[middle]) {
                start = middle + 1;
                middle = start + (end - start) / 2;
            }

            // if target value is less then the middle pointer value
            else if (target < arr[middle]) {
                end = middle - 1;
                middle = start + (end - start) / 2;
            }
        }

        // if target value is found then the index value should be greater than the -1.
        if (index > -1) {
            System.out.println(target + " value exist at the " + index + " index in the provided array.");
        }

        // if target value is not founded then index value should be -1.
        else {
            System.out.println("Sorry, " + target + " value does not exist in the provided array.");
        }
    }
}
