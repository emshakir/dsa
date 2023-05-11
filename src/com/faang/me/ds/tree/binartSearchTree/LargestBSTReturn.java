package com.faang.me.ds.tree.binartSearchTree;

/**
 * Created By Mohammad Shakir - 31/12/2022
 */
    public class LargestBSTReturn {

        int max;
        int min;
        boolean isBST;
        int height;

        public LargestBSTReturn() {
        }

        public LargestBSTReturn(int max, int min, boolean isBST, int height) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.height = height;
        }
    }
