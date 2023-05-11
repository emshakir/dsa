package com.apna_college.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Mohammad Shakir - 16/02/2023
 */
public class $02_ValidAnagram {


  public static boolean isValidAnagram(String s1, String s2) {

    if (s1.length() != s2.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if (map.get(c) != null) {
        if (map.get(c) == 1) {
          map.remove(c);
        } else {
          map.put(c, map.get(c) - 1);
        }
      } else {
        return false;
      }
    }
    return map.isEmpty();
  }

  public static void main(String[] args) {

    String s1 = "TULIP";
    String s2 = "LUPIT";
    System.out.println(isValidAnagram(s1, s2));
  }
}
