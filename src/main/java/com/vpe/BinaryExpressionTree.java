package com.vpe;

/*
    This problem was asked by Microsoft.

    Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

    Given the root to such a tree, write a function to evaluate it.

    For example, given the following tree:

        *
       / \
      +    +
     / \  / \
    3  2  4  5

    You should return 45, as it is (3 + 2) * (4 + 5).
*/

/*
    Solution:

    evaluate(node):
        if node is a number:
            return number

        left  = evaluate(node.left)
        right = evaluate(node.right)

        return left operator right
*/

public class BinaryExpressionTree {
    private Node root;

    private class Node {
        private String value;
        private Node leftNode;
        private Node rightNode;

        public Node(String value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public void root(String value, Node leftNode, Node rightNode) {
        root = new Node(value, leftNode, rightNode);
    }

    public Node create(String value, Node leftNode, Node rightNode) {
        return new Node(value, leftNode, rightNode);
    }

    public int calc() {
        return calc(root);
    }

    public int calc(Node node) {
        if (node.leftNode == null && node.rightNode == null) {
            return Integer.parseInt(node.value);
        }

        return switch (node.value) {
            case "+" -> calc(node.leftNode) + calc(node.rightNode);
            case "-" -> calc(node.leftNode) - calc(node.rightNode);
            case "*" -> calc(node.leftNode) * calc(node.rightNode);
            case "/" -> calc(node.leftNode) / calc(node.rightNode);
            default -> throw new IllegalArgumentException("Invalid operator: " + node.value);
        };
    }
}
