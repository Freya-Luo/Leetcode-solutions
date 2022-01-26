package lc_101_150.LC_147_InsertionSortList;

class Solution {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // O(N^2)
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-5001);
        ListNode cur = head;

        while (cur != null) {
            ListNode prev = dummy;
            // Find the right position for the current node to insert
            while(prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;

            cur = next;
        }
        return dummy.next;
    }
}