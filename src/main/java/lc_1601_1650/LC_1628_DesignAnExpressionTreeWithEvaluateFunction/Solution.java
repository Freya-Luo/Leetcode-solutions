package lc_1601_1650.LC_1628_DesignAnExpressionTreeWithEvaluateFunction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
}

class BETNode extends Node {
    BETNode left;
    BETNode right;
    String val;

    BETNode(String v) {
        this.val = v;
    }

    public int evaluate() {
        return dfs(this);
    }
    // O(n)
    private int dfs(BETNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return Integer.parseInt(root.val);

        int left = dfs(root.left);
        int right = dfs(root.right);

        return switch (root.val) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    private final Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    // O(n)
    public Node buildTree(String[] postfix) {
        Stack<BETNode> stack = new Stack<>();

        for (String s : postfix) {
            BETNode newNode = new BETNode(s);

            boolean isOperator = operators.contains(s);
            if (!isOperator) {
                stack.push(newNode);
                continue;
            }
            newNode.right = stack.pop();
            newNode.left = stack.pop();
            stack.push(newNode);
        }
        return stack.pop();
    }
}


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */