package com.faang.me.apnacollege.trie;


import java.util.Arrays;
import java.util.List;

/**
 * Created By Mohammad Shakir - 05/03/2023
 */
public class $01_WordsCount {


  /*
   * Time complexity - O(2^h) [EXPONENTIAL] [WORST CASE]
   *
   * 2 - 26 characters array
   * h - height of word
   *
   * This will Iterate through Every nodes children array of constant size for every words length.
   *
   * */
  public static int getWordsCount(Trie.Node root) {
    if (root == null) {
      return -1;
    }

    int count = 0;
    if (root.eow) {
      count++;
    }

    for (int i = 0; i < root.children.length; i++) {
      if (root.children[i] != null) {
        count += getWordsCount(root.children[i]);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    List<String> words = Arrays.asList("the", "there", "these", "then", "those", "their", "ant", "and", "animal");
    Trie trie = new Trie();
      Trie.Node root = trie.getRoot(words);
    int wordsCount = getWordsCount(root);
    System.out.println(wordsCount);
  }
}
