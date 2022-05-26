package lc_601_650.LC_636_ExclusiveTimeofFunctions;

import java.util.List;
import java.util.Stack;

class Solution {
    // O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        // when getting a start, push into stack; when getting the end, pop one out
        for(String log: logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int timestamp = Integer.parseInt(parts[2]);
            String status = parts[1];

            if (status.equals("start")) {
                stack.push(new int[]{id, timestamp});
            } else if (status.equals("end")) {
                int[] topLog = stack.pop();
                int duration = timestamp - topLog[1] + 1;

                res[topLog[0]] += duration;
                if (!stack.isEmpty()) { // only the closet outer func execution time will be affected
                    res[stack.peek()[0]] -= duration;
                }
            }
        }

        return res;
    }
}
