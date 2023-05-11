package com.faang.arrays;

import java.util.HashMap;
import java.util.Map;

public class $15_MajorityElementAlgorithm {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 1, 1, 1, 2, 1 };
		majorityElement(nums);

	}

	public static int majorityElement(int[] nums) {
		int majEle = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == majEle) {
				count++;
			} else if (count == 0) {
				majEle = nums[i];
				count = 1;
			} else {
				count--;
			}
		}

		int resultCount = 0;
		for (int element : nums) {
			if (element == majEle) {
				resultCount++;
			}
		}
		if (resultCount > nums.length / 2) {
			return majEle;
		}
		return 0;
	}

	public static int majorityElementUsingHashMap(int[] nums) {
		int output = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int ele : nums) {
			if (!map.containsKey(ele)) {
				map.put(ele, 1);
			} else {
				map.put(ele, map.get(ele) + 1);
			}
			if (map.get(ele) > nums.length / 2) {
				output = ele;
				break;
			}

		}

		return output;
	}
}
