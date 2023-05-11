package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 19/12/2022
 */
public class $17_TreeUsingInAndPostOrder {

    public static void main(String[] args) {
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode<Integer> root = getBinaryTree(postOrder, inOrder);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
    }

    public static BinaryTreeNode<Integer> getBinaryTree(int[] post, int[] in) {
        return getTreeUsingPostOrderAndInOrder(post, in, 0, post.length - 1, 0, in.length - 1);
    }

    public static BinaryTreeNode<Integer> getTreeUsingPostOrderAndInOrder(int[] post, int[] in, int siPost, int eiPost, int siIn, int eiIn) {

        if (siPost > eiPost) {
            return null;
        }

        int rootElement = post[eiPost];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootElement);

        int middleIndex = -1;
        for (int i = siIn; i <= eiIn; i++) {
            if (in[i] == rootElement) {
                middleIndex = i;
                break;
            }
        }

        int siInLeft = siIn;
        int eiInLeft = middleIndex - 1;
        int siInRight = middleIndex + 1;
        int eiInRight = eiIn;

//        int eiPostLeft = siPost + middleIndex - siIn - 1;
        int siPostLeft = siPost;
        int lenghtOfTree = eiInLeft - siInLeft + 1;
        int eiPostLeft = siPostLeft + lenghtOfTree - 1;
        int siPostRight = eiPostLeft + 1;
        int eiPostRight = eiPost - 1;

        root.left = getTreeUsingPostOrderAndInOrder(post, in, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
        root.right = getTreeUsingPostOrderAndInOrder(post, in, siPostRight, eiPostRight, siInRight, eiInRight);
        return root;
    }
}
