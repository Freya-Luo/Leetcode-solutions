package lc_751_800.LC_772_BasicCalculatorIII;

import java.util.Stack;

class Solution {

    private boolean comparePrecedence(char prev, char cur) {
        // a new sub calculation expression, do nothing
        if (prev == '(') return false;
        if ((cur == '*' || cur == '/') && (prev == '+' || prev == '-')) return false;
        return true;
    }

    private int doMath(int n2, char op, int n1) {
        switch (op) {
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1 * n2;
            case '/': return n1 / n2;
            default: return Integer.MIN_VALUE;
        }
    }

    // O(n)
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            // case 1: if c is a digit, move forward as far as possible to form a number
            if (Character.isDigit(c)) {
                int end = i;
                while ((end + 1) < s.length() && Character.isDigit(s.charAt(end + 1))) {
                    end += 1;
                }
                int num = Integer.parseInt(s.substring(i, end + 1));
                nums.push(num);
                i = end;
            } // case 2: if c is an operator, check the previous op and decide their precedence
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && comparePrecedence(ops.peek(), c)) {
                    nums.push(doMath(nums.pop(), ops.pop(), nums.pop()));
                }
                ops.push(c);
                // System.out.print(ops.peek() + " "+ "\n");
            } // case 3: if c is '(', just push to the ops stack
            else if (c == '(') {
                ops.push(c);
            } // case 4: if c is ')', do math until we get '('
            // here, no need to compare precedence, as in the case 2, calculation is done along the way
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(doMath(nums.pop(), ops.pop(), nums.pop()));
                }
                ops.pop(); // pop '(' out of stack
            }
            i++;
        }
        // consume the left operators
        while (!ops.isEmpty()) {
            nums.push(doMath(nums.pop(), ops.pop(), nums.pop()));
        }
        return nums.pop();
    }
}