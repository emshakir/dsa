/*

		You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

		It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.


			Example 1
			=============================
					Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
					Output: "Sao Paulo" 
					Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".


			Example 2:
			==============================
					Input: paths = [["B","C"],["D","B"],["C","A"]]
					Output: "A"
					Explanation: All possible trips are: 
					"D" -> "B" -> "C" -> "A". 
					"B" -> "C" -> "A". 
					"C" -> "A". 
					"A". 
					Clearly the destination city is "A".
			
			
			Example 3:
			==============================
					Input: paths = [["A","Z"]]
					Output: "Z"
 
 */

package com.faang.me.ds.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class $11_DestinationCity {

	public static void main(String[] args) {
		String[] sArr = { "London", "New York", "New York", "Lima", "Lima", "Sao Paulo","Sao Paulo","Paris"};
//		String[] sArr = {"B","C","D","B","C","A"};
		List<List<String>> paths = new ArrayList<List<String>>();
		int i = 0;
		while (i < sArr.length) {
			List<String> list = new ArrayList<String>();
			for (int j = 1; j <= 2; j++) {
				list.add(sArr[i++]);
			}
			paths.add(list);
		}
		System.out.println(destCityMethod2(paths));
	}

	/*
	 * we traverse the input for two times first time, we add all the cities on the
	 * right side to a set second time, we check if the city occurs on the left
	 * side, if so, remove it from the set result will be the city left in the set
	 */
	static String destCity(List<List<String>> paths) {
		Set<String> set = new HashSet<>();
		for (List<String> l : paths) {
			set.add(l.get(1));
		}

		for (List<String> l : paths) {
			set.remove(l.get(0));
		}

		return set.iterator().next();
	}
	
	/*
	 * Traverse through each inner list elements and add their first index to set
	 * and return the second index of list that does not contains in the set as output
	 * 
	 * */

	static String destCityMethod2(List<List<String>> paths) {
		Set<String> set = new LinkedHashSet<String>();
		for (List<String> l : paths) {
			set.add(l.get(0));
		}

		String result = "";
		for (List<String> l : paths) {
			if (!set.contains(l.get(1))) {
				result = l.get(1);
				break;
			}
		}
		return result;
	}

}
