package lc_401_450.LC_432_AllOoneDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * All methods are O(1) time complexity.
 * String -> count -> Node
 * head(0) -> Node(1) -> Node(2) -> Node(3) -> tail(MAX)
 */
class AllOne {
    private class Node {
        int count;
        Node prev, next;
        Set<String> strs = new HashSet<>();
        Node(int cnt) {
            this.count = cnt;
        }
    }

    private Node head, tail;
    private Map<String, Integer> key2Cnt;
    private Map<Integer, Node> cnt2Node;

    public AllOne() {
        head = new Node(0);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;

        key2Cnt = new HashMap<>();
        cnt2Node = new HashMap<>();
    }

    private void adjustList(String key, int cnt) {
        int curCnt = key2Cnt.get(key);
        Node curNode = cnt2Node.get(curCnt);
        int newCnt = curCnt + cnt;

        // insert the key to the new node
        if (!cnt2Node.containsKey(newCnt)) {
            Node newNode = new Node(newCnt);
            if (cnt == 1) {
                insertNodeAfter(newNode, curNode); // insert after curNode
            } else {
                insertNodeAfter(newNode, curNode.prev); // insert before curNode
            }
            cnt2Node.put(newCnt, newNode);
        }
        cnt2Node.get(newCnt).strs.add(key);

        // remove the key from the current node
        // must insert before moving from the current node => otherwise, Null Pointer Exception
        deleteKey(curCnt, key);

        // change keyMap
        key2Cnt.put(key, newCnt);
    }

    public void inc(String key) {
        // case 1: if key already exists, move this string around in the double linked list
        if (key2Cnt.containsKey(key)) {
            adjustList(key, 1);
            return;
        }
        // case 2: if key not exist
        // -- 2.a: if Node(count == 1) does not exist, create it, insert into list and nodeMap
        if (head.next.count != 1) {
            Node node = new Node(1);
            insertNodeAfter(node, head);
            cnt2Node.put(1, node);
        }
        // add key to the node, and record key
        head.next.strs.add(key);
        key2Cnt.put(key, 1);
    }

    public void dec(String key) {
        // case 1: if key not exists, just ignore
        if (!key2Cnt.containsKey(key)) return;
        // case 2: if key's count > 1, move it around
        int cnt = key2Cnt.get(key);
        if (cnt > 1) {
            adjustList(key, -1);
            return;
        }
        // case 3: if key's count is 1, directly delete it from keyMap
        key2Cnt.remove(key);
        // also, delete it from node
        deleteKey(1, key);
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return (String) tail.prev.strs.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return (String) head.next.strs.iterator().next();
    }

    private void insertNodeAfter(Node n, Node t) { // curNode, targetNode
        n.prev = t;
        n.next = t.next;
        t.next.prev = n;
        t.next = n;
    }

    private void deleteNode(Node t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
        t.next = t.prev = null;
    }

    private void deleteKey(int cnt, String key) {
        cnt2Node.get(cnt).strs.remove(key);
        // if this node has empty strs set, delete it from list and nodeMap
        if (cnt2Node.get(cnt).strs.size() == 0) {
            deleteNode(cnt2Node.get(cnt));
            cnt2Node.remove(cnt);
        }
    }

}