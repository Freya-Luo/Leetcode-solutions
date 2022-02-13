package lc_51_100.LC_84_LargestRectangleInHistogram;

import java.util.Stack;

class Solution_MonoStack {
    // Time: O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for(int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int curArea = heights[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, curArea);
            }
            stack.push(i);
        }

        // deal with the rest value in the stack
        while (!stack.isEmpty() && stack.peek() != -1 ) {
            int idx = stack.pop();
            max = Math.max(max, heights[idx] * (n - stack.peek() - 1));
        }
        return max;
    }
}
