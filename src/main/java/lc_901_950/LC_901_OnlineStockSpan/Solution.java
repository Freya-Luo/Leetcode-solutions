package lc_901_950.LC_901_OnlineStockSpan;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // O(n)
    private Deque<int[]> monostack;

    public Solution() {
        monostack = new ArrayDeque<>();
    }

    public int next(int price) {
        int smaller = 0;
        // before inserting next price, check the top of the stack
        while (!monostack.isEmpty() && monostack.peek()[0] <= price) {
            smaller += monostack.peek()[1];
            monostack.pop();
        }

        monostack.addFirst(new int[]{price, 1 + smaller});
        return 1 + smaller;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */