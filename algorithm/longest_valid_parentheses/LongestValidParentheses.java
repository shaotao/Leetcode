import java.io.*;
import java.util.*;


class LongestValidParentheses
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Valid Parentheses ===");
        Solution solution = new Solution();
        
        //String s = ")()())";
        String s = "()(()";
        
        int n = solution.longestValidParentheses(s);
        System.out.println("s = \""+s+"\"");
        System.out.println("length = "+n);
    }
}


class Solution
{
    public int find_pair(String s, int start_idx)
    {
        if(start_idx < 0 || start_idx >= s.length() ||
           s.charAt(start_idx) == ')' ) { return -1; }

        int num_left = 1;
        int num_right = 0;
        for(int i = start_idx+1; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(') { num_left++; }
            else { num_right++; }

            if(num_left == num_right) { return i; }
        }

        return -1;
    }

    public int longestValidParentheses2(String s)
    {
        int result = 0;
        int start_idx = 0;
        boolean cont = true;

        while(start_idx < s.length())
        {
            int length = 0;
            int end_idx = find_pair(s, start_idx);

            if(end_idx > 0)
            {
                length = end_idx - start_idx+1;
                if(cont) { result += length; }
                else if(length > result) { result = length; }

                cont = true;
                start_idx = end_idx + 1;
            }
            else
            {
                cont = false;
                start_idx++;
            }
        }
        
        return result;
    }

    public int longestValidParentheses(String s)
    {
        int result = 0;

        Stack<Character> stack1 = new Stack<Character>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == ')' && stack1.size() > 0 && stack1.peek() == '(')
            {
                stack1.pop();
                stack2.pop();
            }
            else
            {
                stack1.push(ch);
                stack2.push(i);
            }
        }

        // scan the stack for gaps
        int length = 0;
        int end_idx = s.length();
        while(stack2.size() > 0)
        {
            int top = stack2.pop();
            length = end_idx - top -1;

            if(length > result) { result = length; }
            end_idx = top;
        }

        // try to get the last one if any
        length = end_idx;
        if(length > result) { result = length; }

        return result;
    }
}


