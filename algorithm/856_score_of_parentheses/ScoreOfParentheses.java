import java.io.*;
import java.util.*;


class ScoreOfParentheses
{
    public static void main(String[] args)
    {
        System.out.println("=== Score of Parentheses ===");
        Solution solution = new Solution();
        String[] input = {"()", "()()", "(()(()))"};
        for (String S:input) {
            System.out.println("S = "+S+", score = "+solution.scoreOfParentheses(S));
        }
    }
}


class Solution
{
    public int scoreOfParentheses(String S) {
        if (S.equals("()")) {
            return 1;
        } else  {
            int idx = findSplitIdx(S);
            if (idx > 0) {
                return scoreOfParentheses(S.substring(0, idx+1)) +
                    scoreOfParentheses(S.substring(idx+1));
            } else {
                return 2*scoreOfParentheses(S.substring(1, S.length()-1));
            }
        }
    }

    private int findSplitIdx(String S) {
        if (S == null || S.length() <= 2) {
            return -1;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == ')' && stack.peek() == '(') {
                stack.pop();
                if (stack.size() == 0 && i < S.length()-1) {
                    return i;
                }
            } else {
                stack.push(ch);
            }
        }
        return -1;
    }
}
