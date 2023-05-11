package com.faang.me.apnacollege.trie;

/**
 * Created By Mohammad Shakir - 11/03/2023
 */
public class $04_PrefixWord {

  private static Node root = new Node('\0');

  public static void main(String[] args) {

    String[] str = {"zebra", "dog", "duck", "dove"};

    for (String word : str) {
      add(word);
    }
    printPrefix(str);
  }


  public static void printPrefix(String[] words) {
    for (String word : words) {
      search(word);
    }
  }

  public static void add(String word) {
    insertHelper(root, 0, word);
  }


  private static void insertHelper(Node curr, int idx, String word) {

    if (word.length() == idx) {
      curr.isEndOfWord = true;
      return;
    }

    int charPos = word.charAt(idx) - 'a';
    Node node = curr.children[charPos];
    if (node == null) {
      node = new Node(word.charAt(idx));
      curr.children[charPos] = node;
      curr.childCount++;
    } else {
      node.frequency++;
    }
    insertHelper(node, idx + 1, word);
  }

  private static boolean search(String word) {
    return searchHelper(root, 0, word);
  }

  private static boolean searchHelper(Node curr, int idx, String word) {
    if (word.length() == idx) {
      return curr.isEndOfWord;
    }

    int charPos = word.charAt(idx) - 'a';
    Node node = curr.children[charPos];
    if (node == null) {
      return false;
    }

    if (node.frequency == 1) {
      System.out.println(word.substring(0, idx + 1));
      return true;
    }
    return searchHelper(node, idx + 1, word);
  }
}
