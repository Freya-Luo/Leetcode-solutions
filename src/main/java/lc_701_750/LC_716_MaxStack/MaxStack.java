package lc_701_750.LC_716_MaxStack;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Double Linked List as "stack", and use TreeMap to map values to a list of nodes.
 * Stack: (1st inserted) -> (2nd inserted) -> (3rd inserted) -> ... -> (newly inserted) -> head
 */
class MaxStack {
    private class Node {
        Node prev;
        Node next;
        int val;

        Node(int value) {
            this.val = value;
        }
    }

    private final Node head;
    private final TreeMap<Integer, LinkedList<Node>> map;

    public MaxStack() {
        head = new Node(0);
        head.next = head.prev = head;
        map = new TreeMap<>();
    }

    // O(logN), N: number of operations performed
    public void push(int x) {
        Node n = new Node(x);
        // add to the double linked list
        n.next = head;
        n.prev = head.prev;
        head.prev.next = n;
        head.prev = n;
        // add to the tree map
        if (!map.containsKey(x)) {
            map.put(x, new LinkedList<>());
        }
        map.get(x).add(n);

    }

    // O(logN)
    public int pop() {
        Node t = head.prev;
        int top = t.val;
        // remove node from the double linked list
        t.prev.next = t.next;
        t.next.prev = t.prev;
        // remove node from the tree map
        map.get(top).removeLast();
        if (map.get(top).isEmpty()) {
            map.remove(top);
        }
        return top;
    }

    // O(1)
    public int top() {
        return head.prev.val;
    }

    // O(1)
    public int peekMax() {
        return map.lastKey();
    }

    // O(logN)
    public int popMax() {
        Node t = map.get(map.lastKey()).removeLast();
        int max = t.val;
        t.prev.next = t.next;
        t.next.prev = t.prev;
        if (map.get(max).isEmpty()) {
            map.remove(max);
        }
        return max;
    }
}