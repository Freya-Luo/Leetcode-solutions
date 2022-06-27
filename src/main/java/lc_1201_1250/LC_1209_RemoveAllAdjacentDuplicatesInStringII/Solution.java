package lc_1201_1250.LC_1209_RemoveAllAdjacentDuplicatesInStringII;

import java.util.Stack;

/**
 * Using stack, so aabbcccbae -> e.
 *  When a character does not match the previous one, push 1 to the stack.
 *  Otherwise, increment the count on the top of the stack.
 */
class Solution {
    // O(n)
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> count = new Stack<>();

        int i = 0;
        // !! Use sb not original string s
        while (i < sb.length()) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count.push(1);
            } else {
                int prev = count.pop();
                if (prev + 1 == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    count.push(prev + 1);
                }
            }
            i++;
        }
        return sb.toString();
    }
}