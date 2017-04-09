import java.io.*;
import java.util.*;


class BasicCalculator2
{
    public static void main(String[] args)
    {
        System.out.println("=== Basic Calculator II ===");
        Solution solution = new Solution();
        String[] inputs = {"3+2*2",
                           " 3/2 ",
                           "3+5 / 2",
                           "0-2147483648"};
        for(String s: inputs) {
            System.out.println("\""+s+"\" = "+solution.calculate(s));
        }
    }
}


class Solution
{
    // we need to use iterative approach
    // using start_idx and end_idx and recursive: "Stack Overflow"
    // using substring and recursiion: "Memory Limit Exceeded" error!
    public int calculate(String s) {
        if(s == null || s.length() == 0) { return 0; }

        return (int) calculate2(s, 0, s.length()-1);
    }
    
    public long calculate2(String s, int start_idx, int end_idx)
    {
        if(s == null || s.length() == 0 ||
           start_idx < 0 || start_idx >= s.length() ||
           end_idx < 0 || end_idx >= s.length() ||
           start_idx > end_idx) { return 0; }

        int idx_multiply_divide = -1;
        char ch = '\0';

        for(int i = end_idx; i >= start_idx; i--) {
            // scan for /, * , +, -
            ch = s.charAt(i);
            if (ch == '+') {
                return calculate2(s, start_idx, i-1) + calculate2(s, i+1, end_idx);
            } else if (ch == '-') {
                return calculate2(s, start_idx, i-1) - calculate2(s, i+1, end_idx);
            } else if(ch == '/' || ch == '*') {
                if(idx_multiply_divide == -1) {
                    idx_multiply_divide = i;
                }
            }
        }
        
        if(idx_multiply_divide >= 0) {
            ch = s.charAt(idx_multiply_divide);
            if(ch == '*') {
                return calculate2(s, start_idx, idx_multiply_divide-1) * calculate2(s, idx_multiply_divide+1, end_idx);
            } else {
                    return calculate2(s, start_idx, idx_multiply_divide-1) / calculate2(s, idx_multiply_divide+1, end_idx);
            }
            } else {
                return Long.parseLong(s.substring(start_idx, end_idx+1).trim());
        }
    }
}
