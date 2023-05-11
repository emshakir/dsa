package com.faang.me.apnacollege.trie;

import java.util.Arrays;
import java.util.List;

/**
 * Created By Mohammad Shakir - 05/03/2023
 */
public class $02_PatternMatching {

  private static Node root = new Node('\0');

  public static void main(String[] args) {
    List<String> words = Arrays.asList("abc", "def", "ghi", "cba");
    boolean isMatched = patternMatching(words, "de");
    System.out.println(isMatched);
  }

  public static void insert(String word) {
    for (int i = 0; i < word.length(); i++) {
      insertHelper(root, word.substring(i), 0);
    }
  }

  private static void insertHelper(Node curr, String word, int idx) {

    if (idx == word.length()) {
      curr.isEndOfWord = true;
      return;
    }
    int charIdx = word.charAt(idx) - 'a';
    Node node = curr.children[charIdx];
    if (node == null) {
      node = new Node(word.charAt(idx));
      curr.children[charIdx] = node;
      curr.childCount++;
    }
    insertHelper(node, word, idx + 1);
  }

  public static boolean search(String word) {
    return searchHelper(root, word, 0);
  }

  private static boolean searchHelper(Node curr, String word, int idx) {

    if (idx == word.length()) {
      return true;
    }

    int charIdx = word.charAt(idx) - 'a';
    Node node = curr.children[charIdx];

    if (node == null) {
      return false;
    }
    return searchHelper(node, word, idx + 1);

  }


  /* Make use of suffix tries i.e., add every substring of word in trie
   * including the original word
   */
  public static boolean patternMatching(List<String> words, String pattern) {

    for (String word : words) {
      insert(word);
    }
    return search(pattern);
  }
}
