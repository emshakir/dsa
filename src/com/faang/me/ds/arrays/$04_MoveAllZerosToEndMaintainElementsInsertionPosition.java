package com.faang.me.ds.arrays;

public class $04_MoveAllZerosToEndMaintainElementsInsertionPosition {

	public static void main(String[] args) {
		int[] arr = { 0, 8, 5, 0, 10, 0, 20 };
//		naiveApproach(arr);
//		efficientApproach(arr);
		efficientApproachWithoutSwap(arr);
	}

	static void efficientApproachWithoutSwap(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while (count < arr.length) {
			arr[count++] = 0;
		}
		for (int a : arr) {
			System.out.println(a);
		}
	}

	static void efficientApproach(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}

		for (int a : arr) {
			System.out.println(a);
		}
	}

	static void naiveApproach(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						break;
					}
				}
			}
		}
	}
}
