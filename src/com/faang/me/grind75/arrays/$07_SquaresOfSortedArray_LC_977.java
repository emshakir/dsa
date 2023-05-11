package com.faang.me.grind75.arrays;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 29/09/2022
 */
public class $07_SquaresOfSortedArray_LC_977 {

    public static void main(String[] args) {

        int[] nums = {-7, -3, 2, 3, 11};
        int[] resultArray = getSortedSquaresArray(nums);
        System.out.println("Sorted Squared Array :::: " + Arrays.toString(resultArray));

    }

    /**
     *
     * TWO Pointer Approach Compare the first element with last element,
     *  if less then move the squared end pointer number of the end of new array
     *  else add the squared start pointer of the end of the new array
     * do this until the end pointer is greater than start.
     *
     * @param nums
     * @return
     */
    public static int[] getSortedSquaresArray(int[] nums) {
        int iterator = nums.length - 1;
        int start = 0;
        int end = iterator;
        int[] resultArray = new int[nums.length];
        while (start <= end) {
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                resultArray[iterator--] = nums[end] * nums[end];
                end--;
            } else {
                resultArray[iterator--] = nums[start] * nums[start];
                start++;
            }
        }
        return resultArray;
    }
}
