/*
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. 
 * You are also given a rule represented by two strings, ruleKey and ruleValue.
 * Return the number of items that match the given rule.
 * 
 * Example 1:

		Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
		Output: 1
		
	Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
	
 *		Example 2:

		Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
		Output: 2
		
	Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] 
					and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */

package com.faang.me.ds.strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountMatchingItems {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("phone");
		list1.add("blue");
		list1.add("pixel");

		List<String> list2 = new ArrayList<String>();
		list2.add("computer");
		list2.add("silver");
		list2.add("lenovo");

		List<String> list3 = new ArrayList<String>();
		list3.add("phone");
		list3.add("gold");
		list3.add("iphone");

		List<List<String>> items = new ArrayList<List<String>>();
		items.add(list1);
		items.add(list2);
		items.add(list3);

		String ruleKey = "color";
		String ruleValue = "silver";

		int output1 = countMatches_1(items, ruleKey, ruleValue);
		int output2 = countMatches_2(items, ruleKey, ruleValue);
		int output3 = countMatches_3(items, ruleKey, ruleValue);
		System.out.println(output1);
		System.out.println(output2);
		System.out.println(output3);
	}

	public static int countMatches_1(List<List<String>> items, String ruleKey, String ruleValue) {

		int count = 0;
		for (List<String> list : items) {

			if (ruleKey.equalsIgnoreCase("type")) {
				if (list.get(0).equalsIgnoreCase(ruleValue)) {
					count++;
				}
			} else if (ruleKey.equalsIgnoreCase("color")) {
				if (list.get(1).equalsIgnoreCase(ruleValue)) {
					count++;
				}
			} else if (ruleKey.equalsIgnoreCase("name")) {
				if (list.get(2).equalsIgnoreCase(ruleValue)) {
					count++;
				}
			}
		}
		return count;
	}

	public static int countMatches_2(List<List<String>> items, String ruleKey, String ruleValue) {

		int count = 0;
		for (List<String> list : items) {

			if (ruleKey.equalsIgnoreCase("type") && list.get(0).equalsIgnoreCase(ruleValue)) {
				count++;
			} else if (ruleKey.equalsIgnoreCase("color") && list.get(1).equalsIgnoreCase(ruleValue)) {
				count++;
			} else if (ruleKey.equalsIgnoreCase("name") && list.get(2).equalsIgnoreCase(ruleValue)) {
				count++;
			}
		}
		return count;
	}

	public static int countMatches_3(List<List<String>> items, String ruleKey, String ruleValue) {
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("type",0);
		map.put("color",1);
		map.put("name",2);
		
		int count = 0;
		for (List<String> list : items) {
			if(list.get(map.get(ruleKey)).equals(ruleValue)){
				count++;
			}
		}
		return count;
	}
	
	public static int countMatches_4(List<List<String>> items, String ruleKey, String ruleValue) {
		
		int result = 0;
		int idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
		
		for (List<String> list : items) {
			if(list.get(idx).equals(ruleValue)) {
				result++;
			}
		}
		return result;
	}
}
