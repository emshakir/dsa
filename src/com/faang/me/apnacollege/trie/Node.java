package com.faang.me.apnacollege.trie;

/**
 * Created By Mohammad Shakir - 05/03/2023
 */
public class Node {


  public Node[] children;
  public char content;
  public boolean isEndOfWord;
  public int childCount;
  public int frequency;

  public Node(char content) {
    children = new Node[26];
    this.content = content;
    this.isEndOfWord = false;
    this.childCount = 0;
    this.frequency = 1;
  }
}
