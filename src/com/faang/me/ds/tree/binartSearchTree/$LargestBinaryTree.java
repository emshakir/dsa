package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;
import com.faang.me.ds.tree.binartTrees.$17_TreeUsingInAndPostOrder;

/**
 * Created By Mohammad Shakir - 31/12/2022
 */
public class $LargestBinaryTree {

    public static void main(String[] args) {
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
        int[] postOrder = {1, 3, 2, 5, 7, 6, 4};
        BinaryTreeNode<Integer> root = $17_TreeUsingInAndPostOrder.getBinaryTree(postOrder, inOrder);
        int height = getLargestBinaryTreeHeight(root);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
        System.out.println(height);

    }

    private static int getLargestBinaryTreeHeight(BinaryTreeNode<Integer> root) {
        LargestBSTReturn res = getLargestBSTClassAnother(root);
        return res.height;
    }

    private static LargestBSTReturn getLargestBSTClass(BinaryTreeNode<Integer> root) {
        if (root == null) {
            LargestBSTReturn res = new LargestBSTReturn(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
            return res;
        }

        LargestBSTReturn left = getLargestBSTClass(root.left);
        LargestBSTReturn right = getLargestBSTClass(root.right);
        int height = 0;
        boolean isBST = root.data <= left.max && root.data > right.min && !left.isBST && !right.isBST;
        int min = Math.min(root.data, Math.min(left.min, left.min));
        int max = Math.max(root.data, Math.max(left.max, left.max));
        if (left.isBST && right.isBST) {
            height = 1 + Math.max(left.height, right.height);
        } else {
            height = Math.max(left.height, right.height);
        }
        LargestBSTReturn res = new LargestBSTReturn(max, min, isBST, height);
        return res;
    }

    private static LargestBSTReturn getLargestBSTClassBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            LargestBSTReturn result = new LargestBSTReturn();
            result.max = Integer.MIN_VALUE;
            result.min = Integer.MAX_VALUE;
            result.isBST = true;
            result.height = 0;
            return result;
        }
        LargestBSTReturn left = getLargestBSTClassBetter(root.left);
        LargestBSTReturn right = getLargestBSTClassBetter(root.right);
        if (!(right.isBST && right.min > root.data)) {
            right.isBST = false;
        }

        if (!(left.isBST && left.max < root.data)) {
            left.isBST = false;
        }
        LargestBSTReturn result = new LargestBSTReturn();
        if (!left.isBST || !right.isBST || root.data < left.max || root.data > right.min) {
            if (left.height > right.height) {
                left.isBST = false;
                return left;
            } else {
                right.isBST = false;
                return right;
            }
        }
        result.isBST = true;
        result.min = Math.min(left.min, Math.min(right.min, root.data));
        result.max = Math.max(left.max, Math.max(right.max, root.data));
        result.height = 1 + Math.max(left.height, right.height);
        return result;
    }

    private static LargestBSTReturn getLargestBSTClassAnother(BinaryTreeNode<Integer> root) {
        if (root == null) {
            LargestBSTReturn result = new LargestBSTReturn();
            result.max = Integer.MIN_VALUE;
            result.min = Integer.MAX_VALUE;
            result.isBST = true;
            result.height = 0;
            return result;
        }
        LargestBSTReturn left = getLargestBSTClassAnother(root.left);
        LargestBSTReturn right = getLargestBSTClassAnother(root.right);
        LargestBSTReturn result = new LargestBSTReturn();
        result.max = Math.max(left.max, Math.max(right.max, root.data));
        result.min = Math.min(left.min, Math.min(right.min, root.data));
        boolean isBST = left.isBST && right.isBST && left.max < root.data && right.min > root.data;
        result.isBST = isBST;
        if (isBST) {
            result.height = Math.max(left.height, right.height) + 1;
        } else {
            result.height = Math.max(left.height, right.height);
        }
        return result;
    }
}
