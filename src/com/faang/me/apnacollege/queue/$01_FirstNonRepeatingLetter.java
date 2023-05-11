package com.apna_college.queue;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 24/01/2023
 */
public class $01_FirstNonRepeatingLetter {


    public static void main(String[] args) {
        System.out.println(getFirstNonRepeating("java"));
        printNonRepeating("aabbxcx");
    }


    // single character
    public static char getFirstNonRepeating(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return '@';
    }

    // for stream of characters

    public static void printNonRepeating(String s) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                System.out.print("-1" + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
}
