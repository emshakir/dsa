package com.faang.me.apnacollege.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 12/03/2023
 */
public class $05_FindAllWords {

  private static Node root = new Node('\0');

  public static void main(String[] args) {
    String[] words = {"the", "a", "there", "answer", "any", "by", "bye", "their", "abc"};

    for (String word : words) {
      Node curr = root;
      for (int i = 0; i < word.length(); i++) {
        int charPos = word.charAt(i) - 'a';
        Node node = curr.children[charPos];
        if (node == null) {
          node = new Node(word.charAt(i));
          curr.children[charPos] = node;
        }
        curr = node;
      }
      curr.isEndOfWord = true;
    }

    List<String> res = findWords(root);
    System.out.println(res);
  }


  public static List<String> findWords(Node inputNode) {
    List<String> list = new ArrayList<>();
    Character[] charArr = new Character[26];
    getWords(inputNode, list, charArr, 0);
    return list;
  }


  /* Creating a character array and adding the characters is key point for this problem*/
  private static void getWords(Node curr, List<String> list, Character[] charArray, int idx) {

    // if EOW append all the characters of charArray add to list
    StringBuilder sb = new StringBuilder();
    if (curr.isEndOfWord) {
      for (int i = 0; i < idx; i++) {
        sb.append(charArray[i]);
      }
      list.add(sb.toString());
    }

    for (int i = 0; i < 26; i++) {
      Node node = curr.children[i];
      if (node != null) {
        // add the characters to character array as once we get EOW we can add the all
        charArray[idx] = (char) (i + 'a');
        getWords(node, list, charArray, idx + 1);
      }
    }
  }
}
