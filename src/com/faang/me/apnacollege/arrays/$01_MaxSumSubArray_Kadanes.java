package com.faang.me.apnacollege.arrays;

/**
 *
 * @author SHAKIR
 */
public class $01_MaxSumSubArray_Kadanes {

    // TIME COMPLEXITY - O(n^3) 
    // SPACE COMPLEXITY - O(1)
    //we neec to optmize, we can use prefix sum concept
    public static int getMaxbrute(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += a[k];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // TIME COMPLEXITY - O(n^2)
    // SPACE COMPLEXITY - O(n)
    public static int getMaxPrefix(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[a.length];

        // Store all the prefix sum elements in auxilary array
        prefix[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int currSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // TIME COMPLEXITY - O(n)
    // SPACE COMPLEXITY - O(1)
    // We will use Kadane's alogrithm which is O(N)
    // Start adding elements to current sum, if it is in negative make it zero
    // Extract maximum sum From current and maximum sum
    public static int getMaxSumSubArray(int[] arr) {

        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maximumSum = Math.max(currentSum, maximumSum);
        }
        return maximumSum;
    }

    public static void main(String[] args) {

        int[] a = {1, -2, 6, -1, 3};
        System.out.println("Maximum Sum Sub Array ::: "+ getMaxSumSubArray(a)); 
        System.out.println("Maximum Sum Sub Array ::: "+ getMaxPrefix(a)); 
        System.out.println("Maximum Sum Sub Array ::: "+ getMaxbrute(a)); 
   }
}
