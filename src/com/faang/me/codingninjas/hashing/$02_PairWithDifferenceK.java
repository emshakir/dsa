package com.faang.me.codingninjas.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHAKIR
 */
public class $02_PairWithDifferenceK {

    public static int getPairOptimal(int[] a, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : a) {

            boolean flag = false;
            int target = e + k;

            // when k is 0, just count the existing element only once.
            if (e == target) {
                flag = true;
            }
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            target = e - k;

            if (map.containsKey(target) && !flag) {
                count += map.get(target);
            }
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        return count;
    }

    private static int binarySearch(int[] a, int k, int si, int ei) {

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
//        while (si <= ei) {
//            int mid = si + (ei - si) / 2;
//            if (a[mid] == k) {
//                return mid;
//            }
//            if (a[mid] < k) {
//                si = mid + 1;
//                continue;
//            }
//            ei = mid - 1;
//        }
        return -1;
    }

    public static int getPairBetter(int[] a, int k) {

        Arrays.sort(a);

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int target = a[i] + k;
            int idxPos = binarySearch(a, target, i + 1, a.length - 1);
            if (idxPos != -1) {
                count++;
            }
            target = a[i] - k;

            int idxNeg = binarySearch(a, target, i + 1, a.length - 1);

            if (idxNeg != -1) {
                count++;
            }
        }
        return count;
    }

//    Time Complexity - O(n^2)
    public static int getPairBrute(int[] a, int k) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] - a[j] == k || a[j] - a[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4,4,4,4};
        int k = 0;
        System.out.println(getPairBrute(a, k));
        System.out.println(getPairBetter(a, k));
        System.out.println(getPairOptimal(a, k));
    }
}
