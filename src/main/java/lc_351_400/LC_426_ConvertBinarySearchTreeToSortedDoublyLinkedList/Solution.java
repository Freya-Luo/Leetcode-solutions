package lc_351_400.LC_426_ConvertBinarySearchTreeToSortedDoublyLinkedList;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;   // pre
        right = _right;  // succ
    }
};

class Solution {

    private Node head = null, prev = null;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private void traverse(Node root) {
        if (root == null) return;

        traverse(root.left);

        if (prev != null) {
            prev.right = root;
            root.left = prev;
        } else if (head == null){
            head = root;
        }
        prev = root;

        traverse(root.right);
    }

    public Node treeToDoublyList(Node root) {
        // For each node, find the max node less than its val & min node greater than its value
        traverse(root);

        head.left = prev;
        prev.right = head;
        return head;
    }
}