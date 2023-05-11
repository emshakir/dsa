package com.faang.me.codingninjas.hashing;

import java.util.*;

/**
 *
 * @author SHAKIR
 */
public class $01_LongestConsecutiveSequence {

    public static List<Integer> getLongestSequence(int[] a) {

        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for (int e : a) {
            map.put(e, true);

            // This is to keep track of elements index to return result of first occurence when maxLength is equal
            if (!indexMap.containsKey(e)) {
                indexMap.put(e, index);
            }
            index++;
        }

        // find max occurence length
        int maxLength = -1;
        int mainStart = -1, mainEnd = -1, mainSi = -1;
        for (int i = 0; i < a.length; i++) {

            int count = 1;
            map.put(a[i], false);
            int startEle = a[i];
            int endEle = a[i];
            int startIdx = i;

            // this loop keep track for higher elements and update end element
            for (int j = 1; map.containsKey(a[i] + j); j++) {
                map.put(a[i] + j, false);
                count++;
                endEle = a[i] + j;
            }

            //this loop keep track for lower elements and update starte element
            for (int j = 1; map.containsKey(a[i] - j); j++) {
                map.put(a[i] - j, false);
                count++;
                startEle = a[i] - j;
            }

            // get the startIndex for current element
            startIdx = indexMap.get(startEle);

            // if maxlength is more than current length start, end, max and mai start index position changes
            if (maxLength < count) {
                maxLength = count;
                mainStart = startEle;
                mainEnd = endEle;
                mainSi = startIdx;
                // if max lengt is same, then we need to return the array whose element is first according to its index
                // so we will compare it with current start index for element from indexMap to our main index which is for previous max length
            } else if (maxLength == count && startIdx < mainSi) {
                mainStart = startEle;
                mainEnd = endEle;
                mainSi = startIdx;
            }
        }

        result.add(mainStart);
        result.add(mainEnd);
        return result;
    }

    public static List<Integer> getLongestSequenceAno(int[] a) {

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = -1;
        int startElement = -1, endElement = -1, startIdx = -1;
        for (int ele : a) {
            int currLength = 1;
            int currStart = ele, currEnd = ele;
            if (!set.contains(ele - 1)) {
                while (set.contains(ele + 1)) {
                    currLength += 1;
                    currEnd = ele + 1;
                }
            }
            maxLength = Math.max(maxLength, currLength);
            startElement = currStart;
            endElement = currEnd;
            int currIdx = map.get(ele);
            if (maxLength < currLength) {
                startIdx = currIdx;
            } else if (maxLength == currLength && currIdx < startIdx) {
                startIdx = currIdx;
            }
        }

        return res;
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        Map<Integer, Boolean> visitedElements = new HashMap<>();
        Map<Integer, Integer> elementToIndexMapping = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            elementToIndexMapping.put(num, i);

            if (!visitedElements.containsKey(num)) {
                visitedElements.put(num, false);
            }
        }

        ArrayList<Integer> longestSequence = new ArrayList<>();

        int globalMaxSequenceLength = 1;
        int globalMinStartIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int currentMinStartIndex = i;

            int count = 0;
            int tempNum = num;
            //Forward
            while (visitedElements.containsKey(tempNum) && !visitedElements.get(tempNum)) {
                visitedElements.put(tempNum, true); //Mark Visited elements in the array as 
                count++;
                tempNum++;
            }

            //Backward
            tempNum = num - 1;
            while (visitedElements.containsKey(tempNum) && !visitedElements.get(tempNum)) {
                visitedElements.put(tempNum, true); //Mark Visited elements in the array as 
                count++;

                currentMinStartIndex = elementToIndexMapping.get(tempNum);
                tempNum--;
            }
            if (count > globalMaxSequenceLength) {
                globalMaxSequenceLength = count;
                globalMinStartIndex = currentMinStartIndex;
            } else if (count == globalMaxSequenceLength) {
                if (currentMinStartIndex < globalMinStartIndex) {
                    globalMinStartIndex = currentMinStartIndex;
                }
            }
        }

        int globalStartNum = arr[globalMinStartIndex];

        longestSequence.add(globalStartNum);

        if (globalMaxSequenceLength > 1) {
            longestSequence.add(globalStartNum + globalMaxSequenceLength - 1);
        }
        return longestSequence;
    }
}
