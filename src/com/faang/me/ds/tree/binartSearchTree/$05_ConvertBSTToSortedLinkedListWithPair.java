package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;
import com.faang.me.ds.tree.binartTrees.$17_TreeUsingInAndPostOrder;

/**
 * Created By Mohammad Shakir - 24/12/2022
 */
public class $05_ConvertBSTToSortedLinkedListWithPair {

    public static void main(String[] args) {
        int[] inOrder = {2, 5, 6, 8, 10, 7};
        int[] postOrder = {2, 6, 5, 7, 10, 8};
        BinaryTreeNode<Integer> root = $17_TreeUsingInAndPostOrder.getBinaryTree(postOrder, inOrder);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
        LinkedListNode<Integer> head = constructLinkedList(root);
        LinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return helperMethod(root).head;
    }

    private static Pair<LinkedListNode<Integer>> helperMethod(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<LinkedListNode<Integer>> pair = new Pair<>();
            return pair;
        }

        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        Pair left = helperMethod(root.left);
        Pair right = helperMethod(root.right);
        Pair pair = new Pair();

        if (left.tail != null) {
            left.tail.next = newNode;
        }

        newNode.next = right.head;

        if (left.head != null) {
            pair.head = left.head;
        } else {
            pair.head = newNode;
        }

        if (right.tail != null) {
            pair.tail = right.tail;
        } else {
            pair.tail = newNode;
        }
        return pair;
    }
}
