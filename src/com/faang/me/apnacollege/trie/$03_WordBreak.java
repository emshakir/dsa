package com.faang.me.apnacollege.trie;

/**
 * Created By Mohammad Shakir - 10/03/2023
 */
public class $03_WordBreak {

  private static Trie t;


  public static boolean wordBreak(String key) {
    if (key.length() == 0) {
      return true;
    }


    for (int i = 1; i <= key.length(); i++) {
      String first = key.substring(0, i);
      String second = key.substring(i);
      boolean isPresentInTree = t.search(key.substring(0, i));
      boolean isPresetInWords = wordBreak(key.substring(i));
      if (isPresentInTree && isPresetInWords) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
    String key = "ilikesung";
    t = new Trie();
    for (String word : words) {
      t.insert(word);
    }
    System.out.println(wordBreak(key));
  }
}
