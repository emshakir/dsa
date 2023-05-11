package com.faang.me.ds.tree;

import com.faang.me.ds.tree.binartSearchTree.BinaryTreeLinkedListPair;
import com.faang.me.ds.tree.binartSearchTree.LinkedListNode;
import com.faang.me.ds.tree.binartTrees.$17_TreeUsingInAndPostOrder;


/**
 * Created By Mohammad Shakir - 24/12/2022
 */
public class $05_ConvertBSTToSortedLinkedList {

    public static void main(String[] args) {
        int[] inOrder = {2, 5, 6, 8, 7, 10};
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
        return helperMethod(root).getHead();
    }

    private static BinaryTreeLinkedListPair<LinkedListNode<Integer>, LinkedListNode<Integer>> helperMethod(BinaryTreeNode<Integer> root) {
        if (root == null) {
            BinaryTreeLinkedListPair bstll = new BinaryTreeLinkedListPair(null, null);
            return bstll;
        }

        BinaryTreeLinkedListPair<LinkedListNode<Integer>, LinkedListNode<Integer>> left = helperMethod(root.left);
        BinaryTreeLinkedListPair<LinkedListNode<Integer>, LinkedListNode<Integer>> right = helperMethod(root.right);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        if (left.getTail() != null) {
            left.getTail().next = newNode;
        } else {
            left.setHead(newNode);
        }

        if (right.getHead() != null) {
            newNode.next = right.getHead();
        } else {
            right.setTail(newNode);
        }

        BinaryTreeLinkedListPair bstll = new BinaryTreeLinkedListPair(left.getHead(), right.getTail());
        return bstll;
    }
}
