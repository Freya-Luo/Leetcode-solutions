package lc_701_750.LC_735_AsteroidCollision;

import java.util.Stack;

class Solution {
    private int state = 1;

    // O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int v : asteroids) {
            // 1 represents it is either positive or negative enough to be pushed into stack
            // 2 means it is exploded by others, do not push to the stack
            state = 1;
            // use negative asteroid to explode the ones in the stack until it is not fast enough
            while (!stack.isEmpty() && v < 0 && stack.peek() > 0) {
                int rV = -v;
                if (stack.peek() < rV) { // [2, -5], pop 2
                    stack.pop();
                } else if (stack.peek() == rV) { // [5, -5], pop 5
                    stack.pop();
                    state = 2;
                    break; // and also explode -5
                } else { // [2, -1]
                    state = 2;
                    break; // explode -1
                }
            }
            if (state == 1) {
                stack.push(v);
            }
        }

        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}