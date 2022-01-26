package lc_651_700.LC_707_DesignLinkedList;

// Using double linked list
// When find node at a specific index, we can determine whether starting from head or tail
class MyLinkedList {

    private class DNode {
        int val;
        DNode prev;
        DNode next;

        DNode(int value) {
            this.val = value;
        }
    }

    private DNode head;
    private DNode tail;
    private int size;

    public MyLinkedList() {
        head = new DNode(-1);
        tail = new DNode(-1);
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    // O(min(K, N-K))
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        DNode cur;
        if (2 * index < size) {
            cur = head;
            while (index-- >= 0) cur = cur.next;
        } else {
            cur = tail;
            index = size - index;
            while (index-- > 0) cur = cur.prev;
        }

        return cur.val;
    }

    private void _insertBefore(DNode node, DNode newNode) {
        newNode.next = node;
        newNode.prev = node.prev;

        node.prev.next = newNode;
        node.prev = newNode;

    }

    private void _insertAfter(DNode node, DNode newNode) {
        newNode.next = node.next;
        newNode.prev = node;

        node.next.prev = newNode;
        node.next = newNode;
    }

    private DNode _findNodeRightBefore(int index) {
        DNode cur;

        if (2 * index < size) {
            cur = head;
            while (index-- > 0) cur = cur.next;
        } else {
            cur = tail;
            index = size - index + 1;
            while (index-- > 0) cur = cur.prev;
        }

        return cur;
    }
    //O(1)
    public void addAtHead(int val) {
        DNode newNode = new DNode(val);

        _insertAfter(head, newNode);
        size++;
    }
    // O(1)
    public void addAtTail(int val) {
        DNode newNode = new DNode(val);

        _insertBefore(tail, newNode);
        size++;
    }
    // O(min(K, N-K))
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        DNode newNode = new DNode(val);
        DNode prev = _findNodeRightBefore(index);

        _insertAfter(prev, newNode);
        size++;
    }
    // O(min(K, N-K))
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        DNode prev = _findNodeRightBefore(index);
        DNode target = prev.next;

        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.next = null;
        target.prev = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */