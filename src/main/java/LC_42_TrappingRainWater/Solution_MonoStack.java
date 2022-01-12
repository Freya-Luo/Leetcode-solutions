package LC_42_TrappingRainWater;

import java.util.Stack;

class Solution_MonoStack {
    // Time: O(n)
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIdx = stack.pop();

                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[bottomIdx];

                res += w * h;
            }
            stack.push(i);
        }
        return res;
    }
}