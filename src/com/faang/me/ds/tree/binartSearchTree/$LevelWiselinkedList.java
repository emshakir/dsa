package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 31/12/2022
 */
public class $LevelWiselinkedList {

    public static void main(String[] args) {

    }

    public static List<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }
        List<LinkedListNode<Integer>> res = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> curr = q.poll();
            if (curr == null) {
                res.add(head);
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                head = tail = null;
            } else {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(curr.data);
                if (head == null && tail == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}
