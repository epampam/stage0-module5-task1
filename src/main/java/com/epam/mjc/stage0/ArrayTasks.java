package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};

    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }


    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] numbers, int target) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] strings) {
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = temp;
        }
        return strings;
    }


    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int countPositiveNumbers = 0;
        for (int value : arr) {
            if (value > 0) {
                countPositiveNumbers += 1;
            }
        }
        int[] positiveNumbersArray = new int[countPositiveNumbers];
        int index = 0;
        for (int number : arr) {
            if (number > 0) {
                positiveNumbersArray[index] = number;
                index += 1;
            }
        }
        return positiveNumbersArray;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
            for (int innerIndex = 1; innerIndex < arr.length; innerIndex++) {
                if (arr[innerIndex - 1].length > arr[innerIndex].length) {
                    int[] temp = arr[innerIndex - 1];
                    arr[innerIndex - 1] = arr[innerIndex];
                    arr[innerIndex] = temp;
                }
            }
        }
        for (int[] subArr : arr) {
            sortSubArray(subArr);
        }
        System.out.print("[");
        for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
            System.out.print("[");
            for (int innerIndex = 0; innerIndex < arr[outerIndex].length; innerIndex++) {
                if (innerIndex < arr[outerIndex].length - 1) {
                    System.out.print(arr[outerIndex][innerIndex] + ",");
                } else {
                    System.out.print(arr[outerIndex][innerIndex]);
                }
            }
            if (outerIndex < arr.length - 1) {
                System.out.print("], ");
            } else {
                System.out.print("]");
            }
        }
        System.out.print("]");

        return arr;
    }

    private static void sortSubArray(int[] subArr) {
        for (int outerIndex = 0; outerIndex < subArr.length; outerIndex++) {
            for (int innerIndex = 1; innerIndex < subArr.length; innerIndex++) {
                if (subArr[innerIndex - 1] > subArr[innerIndex]) {
                    int temp = subArr[innerIndex - 1];
                    subArr[innerIndex - 1] = subArr[innerIndex];
                    subArr[innerIndex] = temp;
                }
            }
        }
    }
}

