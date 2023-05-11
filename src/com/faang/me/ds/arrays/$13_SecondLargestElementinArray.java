package com.faang.me.ds.arrays;

public class $13_SecondLargestElementinArray {

	public static void main(String[] args) {

		int[] array = { 31, 33, 20, 5, 32, 8, 9 };
		approachTwoArrayTraversal(array);
		 approachSingleIteration(array);
		 otherApproachUsingOneTraversal(array);

	}

	static void approachTwoArrayTraversal(int[] array) {

		int largest = Integer.MIN_VALUE;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			largest = Math.max(largest, array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != largest) {
				result = Math.max(result, array[i]);
			}
		}
		System.out.println("OUTPUT Approach 2===============>" + result);
	}

	static void approachSingleIteration(int[] array) {
		int largestElement = 0;
		int result = -1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[largestElement]) {
				result = largestElement;
				largestElement = i;
			} else if (array[i] != array[largestElement]) {
				if (result == -1 || array[i] > array[result]) {
					result = i;
				}
			}
		}
		System.out.println("OUTPUT ===============>" + array[result]);
	}

	static void otherApproachUsingOneTraversal(int[] array) {

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (array[i] > first) {
				second = first;
				first = array[i];
			} else if(array[i] > second && array[i] != first) {
				second =array[i];
			}
		}
		System.out.println("OUTPUT Approach 2===============>" + second);
	}
}
