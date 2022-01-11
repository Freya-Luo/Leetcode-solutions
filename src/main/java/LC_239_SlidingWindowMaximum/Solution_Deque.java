package LC_239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_Deque {
    /**
     * Time: O(N) - each ele is processed exactly twice
     * Space: O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < nums.length ; i++) {
            // Keep the sliding window size
            if (deque.size() != 0 && deque.peek() < i - k + 1)
                deque.poll();

            // Remove all elements smaller than the current num
            while(deque.size() != 0  && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()]; // The first one <=> max in the current window
            }
        }
        return res;

    }
}