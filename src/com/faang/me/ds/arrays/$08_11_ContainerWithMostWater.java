package com.faang.me.ds.arrays;

public class $08_11_ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 2, 3, 4, 5, 18, 17, 2 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return area;
	}
}
