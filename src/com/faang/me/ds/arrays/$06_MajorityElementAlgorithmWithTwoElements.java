package com.faang.me.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class $06_MajorityElementAlgorithmWithTwoElements {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		System.out.println(majorityElement(nums).toString());
		System.out.println(name(nums).toString());
	}

	public static List<Integer> name(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0)
			return result;
		int firstMajor = Integer.MAX_VALUE, firstSum = 0, secondMajor = Integer.MIN_VALUE, secondSum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == firstMajor)
				firstSum++;
			else if (nums[i] == secondMajor)
				secondSum++;
			else if (firstSum == 0) {
				firstMajor = nums[i];
				firstSum = 1;
			} else if (secondSum == 0) {
				secondMajor = nums[i];
				secondSum = 1;
			} else {
				firstSum--;
				secondSum--;
			}
		}
		firstSum = 0;
		secondSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == firstMajor) {
				firstSum++;
			} else if (nums[i] == secondMajor) {
				secondSum++;
			}

		}
		if (firstSum > nums.length / 3) {
			result.add(firstMajor);
		}

		if (secondSum > nums.length / 3) {
			result.add(secondMajor);
		}

		return result;
	}

	public static List<Integer> majorityElement(int[] nums) {

		int majEle_1 = 0;
		int majEle_2 = 0;
		int count1 = 0;
		int count2 = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			if (num == majEle_1) {
				count1++;
			} else if (num == majEle_2) {
				count2++;
			} else if (count1 == 0) {
				majEle_1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				majEle_2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		int outputCnt1 = 0;
		int outputCnt2 = 0;
		for (int num : nums) {
			if (num == majEle_1) {
				outputCnt1++;
			} else if (num == majEle_2) {
				outputCnt2++;
			}
		}
		if (outputCnt1 > nums.length / 3) {
			list.add(majEle_1);
		}
		if (outputCnt2 > nums.length / 3) {
			list.add(majEle_2);
		}

		return list;
	}
}
