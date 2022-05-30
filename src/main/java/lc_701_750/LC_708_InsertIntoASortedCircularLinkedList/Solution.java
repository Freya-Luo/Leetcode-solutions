package lc_701_750.LC_708_InsertIntoASortedCircularLinkedList;

class Node {
    public int val;
    public Node next;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node cur = head;
        Node next = cur.next;
        // O(N)
        while (next != head) {
            if (cur.val <= next.val) {
                // 3 (4) 6
                if (cur.val <= insertVal && insertVal <= next.val) {
                    break;
                }
                // 3 6 (7), move forward
            } else {
                // 5 (8) 1 || 5 (0) 1
                if (insertVal >= cur.val || insertVal <= next.val) {
                    break;
                }
            }
            cur = next;
            next = next.next;
        }
        Node newNode = new Node(insertVal, next);
        cur.next = newNode;
        return head;
    }
}