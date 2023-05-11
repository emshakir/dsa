package com.faang.me.grind75.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 30/09/2022
 */
public class $08_InsertInterval_LC_57 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        getNewIntervalInsertedArray(intervals, newInterval);
    }

    private static List<int[]> getNewIntervalInsertedArray(int[][] intervals, int[] newInterval) {
        List<int[]> resultArray = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i - 1];
            if (currentInterval[1] > newInterval[0]) {
                int min = Math.min(currentInterval[0], newInterval[0]);
                int max = Math.max(currentInterval[1], newInterval[1]);
                currentInterval[0] = min;
                currentInterval[1] = max;
            }
            resultArray.add(currentInterval);
        }
        return resultArray;
    }
}
