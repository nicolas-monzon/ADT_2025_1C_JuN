package org.example.util;

import org.example.model.BinaryTree;

public class BinaryTreeUtil {

    private BinaryTreeUtil() {

    }

    public static int totalNodes(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        return 1 + totalNodes(binaryTree.getLeft()) + totalNodes(binaryTree.getRight());
    }

    public static int totalLeaves(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        if(binaryTree.getLeft() == null) {
            if(binaryTree.getRight() == null) {
                return 1;
            }
            return totalLeaves(binaryTree.getRight());
        }
        if(binaryTree.getRight() == null) {
            return totalLeaves(binaryTree.getLeft());
        }
        return totalLeaves(binaryTree.getLeft()) + totalLeaves(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isComplete(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }
        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    public static boolean isFull(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }
        return isFull(binaryTree.getLeft()) &&
                isFull(binaryTree.getRight()) &&
                height(binaryTree.getLeft()) == height(binaryTree.getRight());
    }

    public static boolean isSBT(BinaryTree binaryTree) {
        return isSBT(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSBT(BinaryTree binaryTree, int n, int m) {
        if(binaryTree == null) {
            return true;
        }

        if(!isInRange(binaryTree.getRoot(), n, m)) {
            return false;
        }

        return isSBT(binaryTree.getLeft(), n, Math.min(m, binaryTree.getRoot())) &&
                isSBT(binaryTree.getRight(), Math.max(n, binaryTree.getRoot()), m);
    }

    private static boolean isInRange(int v, int from, int to) {
        return v > from && v < to;
    }

    public static boolean isBalanced(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(!isBalanced(binaryTree.getLeft())) {
            return false;
        }
        if(!isBalanced(binaryTree.getRight())) {
            return false;
        }
        int diff = height(binaryTree.getLeft()) - height(binaryTree.getRight());
        return diff >= -1 && diff <= 1;
    }

}
