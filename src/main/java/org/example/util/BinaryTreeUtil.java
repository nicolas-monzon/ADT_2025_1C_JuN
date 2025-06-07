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


}
