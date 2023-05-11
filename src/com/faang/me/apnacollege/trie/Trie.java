package com.faang.me.apnacollege.trie;

import java.util.List;

/**
 * Created By Mohammad Shakir - 02/03/2023
 */
public class Trie {

  private Node root = new Node();

  public Node getRoot
    (List<String> words) {
    for (String word : words) {
      insert(word);
    }
    return root;
  }

  public void insert(String word) {
    Node curr = root;

    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
        curr.childCount++;
      }
      curr = curr.children[idx];
    }
    curr.eow = true;
  }

  // Add word in Trie recursive
  public void _insert(String word) {
    insertHelper(root, word, 0);
  }


  private void insertHelper(Node currentNode, String word, int idx) {
    if (idx == word.length()) {
      currentNode.eow = true;
      return;
    }
    int charIdx = word.charAt(idx) - 'a';
    Node node = currentNode.children[charIdx];
    if (node == null) {
      node = new Node();
      currentNode.children[charIdx] = node;
      currentNode.childCount++;
    }
    insertHelper(node, word, idx + 1);
  }


  // Search word in Trie Recursive
  public boolean _search(String word) {
    return searchHelper(root, word, 0);
  }

  private boolean searchHelper(Node currentNode, String word, int idx) {
    if (idx == word.length()) {
      return currentNode.eow;
    }

    int charIdx = word.charAt(idx) - 'a';
    Node node = currentNode.children[charIdx];
    if (node == null) {
      return false;
    }
    return searchHelper(node, word, idx + 1);
  }


  // Delete word in Trie recursive
  public boolean _delete(String word) {
    return deleteHelper(root, word, 0);
  }

  private boolean deleteHelper(Node currentNode, String word, int idx) {
    if (idx == word.length()) {
      if (!currentNode.eow) {
        return false;
      }
      currentNode.eow = false;
      return currentNode.childCount == 0;
    }
    int charIdx = word.charAt(idx) - 'a';
    Node node = currentNode.children[charIdx];
    if (node == null) {
      return false;
    }
    boolean hasNoNextNode = deleteHelper(node, word, idx + 1);
    if (hasNoNextNode && !node.eow) {
      currentNode.children[charIdx] = null;
      currentNode.childCount--;
      return currentNode.childCount == 0;
    }
    return false;
  }

  public boolean search(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.children[idx] == null) {
        return false;
      }
      curr = curr.children[idx];
    }
    return curr.eow;
  }

  /*
   * If we want to remove a word from Trie there are few conditions,
   *
   * 1. There could be other prefixes for word(for the - there).
   * 2. There could be more prefixes for word(for their, if exists there, just need to remove <ir>).
   * 3. Need to remove whole word if no prefixes exist.
   *
   */

  public boolean remove(String word) {
    return remove(root, word, 0);
  }

  private boolean remove(Node curr, String word, int idx) {

    if (idx == word.length()) {
      // no word present or already it is deleted
      if (!curr.eow) {
        return false;
      }
      curr.eow = false;
      return curr.childCount == 0;
    }

    Node node = curr.children[word.charAt(idx) - 'a'];
    if (node == null) {
      return false;
    }

    boolean hasNoNextNode = remove(node, word, idx + 1);
    if (hasNoNextNode && !node.eow) {
      curr.children[word.charAt(idx) - 'a'] = null;
      curr.childCount--;
      return curr.childCount == 0;
    }
    return false;
  }

  class Node {
    Node[] children = new Node[26];
    boolean eow = false;
    int childCount = 0;

    private Node() {
      for (int i = 0; i < children.length; i++) {
        children[i] = null;
      }
    }
  }
}

