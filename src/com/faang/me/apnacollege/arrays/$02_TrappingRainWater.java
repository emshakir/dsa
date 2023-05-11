package com.faang.me.apnacollege.arrays;

/**
 *
 * Created by Mohammad Shakir - 09/04/2023
 */
public class $02_TrappingRainWater {

    public static int getTrappingRainWater(int[] a) {

        int trappedWater = 0;
        int n = a.length;
        // find left maximum and right maximum and store in Auxilary array for every index position
        int[] left = new int[n];
        left[0] = a[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], a[i]);
        }
        int[] right = new int[n];
        right[n - 1] = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a[i]);
        }
        for (int i = 0; i < n; i++) {

            //find Minimum of both left and right for every ith position which will be your trapped water
            int min = Math.min(left[i], right[i]);

            // Subtract minimum from pole height which will give you the trapped water for every itth position
            int currTrapped = min - a[i];

            // Add all poles trappeed water which will result in whole trapped water for array. 
            trappedWater += currTrapped;
        }
        return trappedWater;
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0;
        int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (height[left] < height[right]) {
                // If the current elevation is greater than the previous maximum, water cannot occupy that point at all.
                // However, we do know that everything from maxLeft to the current index, has been optimally filled, as we've
                // been adding water to the brim of the last maxLeft.
                if (height[left] > maxLeft) {
                    // So, we say we've found a new maximum, and look to see how much water we can fill from this point on.
                    maxLeft = height[left];
                    // If we've yet to find a maximum, we know that we can fill the current point with water up to the previous
                    // maximum, as any more will overflow it. We also subtract the current height, as that is the elevation the
                    // ground will be at.
                } else {
                    totalWater += maxLeft - height[left];
                }
                // Increment left, we'll now look at the next point.
                left++;
                // If the height at the left is NOT greater than height at the right, we cannot fill from left to right without over-
                // flowing; however, we do know that we could potentially fill from right to left, if there is nothing in between.
            } else {
                // Similarly to above, we see that we've found a height greater than the max, and cannot fill it whatsoever, but
                // everything before is optimally filled
                if (height[right] > maxRight) {
                    // We can say we've found a new maximum and move on.  
                    maxRight = height[right];
                    // If we haven't found a greater elevation, we can fill the current elevation with maxRight - height[right]
                    // water.
                } else {
                    totalWater += maxRight - height[right];
                }
                // Decrement left, we'll look at the next point.
                right--;
            }
        }
        // Return the sum we've been adding to.
        return totalWater;
    }

    public static int trapped(int[] a) {

        int trappedWater = 0;
        int left = 0;
        int right = a.length - 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        // Iterate array using two pointers left and right
        while (left < right) {
            // if left element's height is less than right element traverse from left and increment left
            //else right and decrement right
            if (a[left] < a[right]) {
                // if current height is greater than maxLeft reassign current to max else calculate the trapped water 
                if (maxLeft < a[left]) {
                    maxLeft = a[left];
                } else {
                    // by subtracting max - current
                    trappedWater += maxLeft - a[left];
                }
                left++;
            } else {
                if (maxRight < a[right]) {
                    maxRight = a[right];
                } else {
                    trappedWater += maxRight - a[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trrapped Water :: " + trap(a));
        System.out.println("Trrapped Water :: " + trapped(a));
    }
}
