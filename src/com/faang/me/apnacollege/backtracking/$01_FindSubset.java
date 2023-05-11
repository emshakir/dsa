package com.faang.me.apnacollege.backtracking;

class $01_FindSubset {

    public static void getSubset(String s, StringBuilder sb, int i) {
        if (s.length() == i) {
            System.out.println(sb.toString());
            return;
        }
        char ch = s.charAt(i);
        getSubset(s, sb.append(ch), i + 1);
        sb.deleteCharAt(sb.length() - 1);
        getSubset(s, sb, i + 1);
    }

    public static void main(String[] args) {
        final String INPUT_DATA = "abc";
        StringBuilder sb = new StringBuilder();
        getSubset(INPUT_DATA, sb, 0);
    }
}
