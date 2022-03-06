package lc_51_100.LC_71_SimplifyPath;

import java.util.Stack;

class Solution {
    /**
     * Time: O(n)
     * Space: O(k) k: parts.length
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part : parts) {

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}