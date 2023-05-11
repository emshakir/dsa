package com.apna_college.recursion;

/**
 * Created By Mohammad Shakir - 10/01/2023
 */
public class $02_RemoveDuplicatesFromString {


    public static void removeDuplicates(String input, boolean[] dataArray, int idx, StringBuilder sb) {
        if (idx == input.length() - 1) {
            System.out.println(sb);
            return;
        }
        char ch = input.charAt(idx);
        if (dataArray[ch - 'a']) {
            removeDuplicates(input, dataArray, idx + 1, sb);
        } else {
            dataArray[ch - 'a'] = true;
            removeDuplicates(input, dataArray, idx + 1, sb.append(ch));
        }
    }

    public static void main(String[] args) {
        removeDuplicates("Mohammad Shakir", new boolean[26], 0, new StringBuilder(""));
    }
}
