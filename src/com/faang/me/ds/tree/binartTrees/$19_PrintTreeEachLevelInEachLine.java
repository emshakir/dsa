package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 21/12/2022
 */
public class $19_PrintTreeEachLevelInEachLine {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        printTree(root);
    }

    public static void printTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        System.out.println(root.data);
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = q.poll();
            if (currentNode == null) {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println();
                q.add(null);
            } else {
                if (currentNode.left != null) {
                    System.out.print(currentNode.left.data + " ");
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    System.out.print(currentNode.right.data + " ");
                    q.add(currentNode.right);
                }
            }
        }
    }
}
