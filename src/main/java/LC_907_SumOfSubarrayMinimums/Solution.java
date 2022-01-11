package LC_907_SumOfSubarrayMinimums;

import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int n = arr.length, modulo = 1000000007;
        // <index, cntOfNumLarger>
        Stack<int[]> largerAtLeft = new Stack<>(), largerAtRight = new Stack<>();
        int[] largerAtRightCnt = new int[n], largerAtLeftCnt = new int[n];

        for(int i = 0; i < arr.length; i++) {
            int leftCnt = 1;
            while(!largerAtLeft.isEmpty() && arr[i] < largerAtLeft.peek()[0]) {
                int[] nextLeft = largerAtLeft.pop();
                leftCnt += nextLeft[1];  // Using stack, need to keep track of the no.of prev left nums poped out
            }
            largerAtLeft.push(new int[]{arr[i], leftCnt});
            largerAtLeftCnt[i] = leftCnt;

            // int j = n - 1 - i;
            // int rightCnt = 1;
            // while(!largerAtRight.isEmpty() && arr[j] <= largerAtRight.peek()[0]) {
            //     int[] nextRight = largerAtRight.pop();
            //     rightCnt += nextRight[1];
            // }
            // largerAtRight.push(new int[]{arr[j], rightCnt});
            // largerAtRightCnt[j] = rightCnt;
        }

        for(int i = n - 1; i >= 0; i--) {
            int rightCnt = 1;
            while(!largerAtRight.isEmpty() && arr[i] <= largerAtRight.peek()[0]) {
                int[] nextRight = largerAtRight.pop();
                rightCnt += nextRight[1];
            }
            largerAtRight.push(new int[]{arr[i], rightCnt});
            largerAtRightCnt[i] = rightCnt;
        }

        for(int k = 0; k < n; k++) {
            res += (long)arr[k] * largerAtLeftCnt[k] * largerAtRightCnt[k];
        }

        return (int)(res % modulo);
    }
}
