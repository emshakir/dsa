package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 19/12/2022
 */
public class $16_TreeUsingInAndPreOrder {

    public static void main(String[] args) {

        int[] preOrder = {8, 3, 1, 6, 4, 7, 10, 14, 13};
        int[] inOrder = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        BinaryTreeNode<Integer> root = getTree(preOrder, inOrder);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
    }

    public static BinaryTreeNode<Integer> getTree(int[] preOrder, int[] inOrder) {
        return getTreeUsingPreInOrder(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> getTreeUsingPreInOrder(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn) {

        if (siPre > eiPre) {
            return null;
        }
        int rootElement = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootElement);
        int midIndex = -1;

        for (int i = siIn; i <= eiIn; i++) {
            if (in[i] == rootElement) {
                midIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = midIndex - 1;
        int siInRight = midIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int inOrderLeftLength = eiInLeft - siInLeft + 1;
        int eiPreLeft = siPreLeft + inOrderLeftLength - 1;
        int siPreRight = eiPreLeft + 1;

        root.left = getTreeUsingPreInOrder(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        root.right = getTreeUsingPreInOrder(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
        return root;
    }
}
