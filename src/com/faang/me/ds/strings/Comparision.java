package com.faang.me.ds.strings;

import java.util.ArrayList;

public class Comparision {

	public static void main(String[] args) {
		ArrayList<Integer> arunList = new ArrayList<Integer>();

		ArrayList<Integer> vikasList = new ArrayList<Integer>();

		arunList.add(1);
		arunList.add(2);
		arunList.add(3);

		vikasList.add(4);
		vikasList.add(2);
		vikasList.add(1);

		comparision(arunList, vikasList);
	}

	static void comparision(ArrayList<Integer> arun, ArrayList<Integer> vikas) {

		int arunPoints = 0;
		int vikasPoints = 0;

		for (int i = 0; i < arun.size(); i++) {

			if (arun.get(i) > vikas.get(i)) {
				arunPoints++;
			} else if (arun.get(i) < vikas.get(i)) {
				vikasPoints++;
			}
		}

		System.out.println(vikasPoints);
		System.out.println(arunPoints);

	}
}
