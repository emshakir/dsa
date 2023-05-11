package com.faang.me.ds.arrays;

public class $14_LargestElementInArray {

	public static void main(String[] args) {

		int[] array = { 31, 25, 20, 5, 30, 8, 9 };

		int largestEle = array[0];

		for (int element : array) {
			if (element > largestEle) {
				largestEle = element;
			}
		}
		System.out.println("Output:::::::"+largestEle);
	}

}
