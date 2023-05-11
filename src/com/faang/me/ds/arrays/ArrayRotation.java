package com.faang.me.ds.arrays;

import java.util.ArrayList;

public class ArrayRotation {

	public static void main(String[] args) {

//		int[] arr = { 14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35};
		int[] arr = { 14, 5, 35 };
//		noOfRotates(2, arr);

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer i : arr) {
			list.add(i);
		}
		System.out.println(rotateArray_2(list, 3));
	}

	static void noOfRotates(int rotations, int[] arr) {
		for (int i = 1; i <= rotations; i++) {
			rotations(arr);
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	static void rotations(int[] arr) {

		int arrLength = arr.length;

		int temp = arr[0];
		for (int i = 0; i < arrLength - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arrLength - 1] = temp;
	}

	public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			System.out.println((i + B) % A.size());
			System.out.println(A.get((i + B) % A.size()));
			ret.add(A.get((i + B) % A.size()));
		}
		return ret;
	}

	public static ArrayList<Integer> rotateArray_2(ArrayList<Integer> A, int B) {

		ArrayList<Integer> ret = new ArrayList<Integer>();
		int temp = A.get((B - 1) % A.size());
		for (int i = 0; i < A.size() - 1; i++) {
			ret.add(A.get((i + B) % A.size()));
		}
		ret.add(temp);
		return ret;
	}
}
