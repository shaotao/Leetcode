import java.io.*;
import java.util.*;


class LongestAbsoluteFilePath
{
    public static void main(String[] args)
    {
	System.out.println("=== Longest Absolute File Path ===");
	Solution solution = new Solution();

        String[] inputs = {"a.txt",
                           "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",
                           "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"};

        for(String s:inputs) {
            System.out.println("s = "+s);
            System.out.println("max length = "+solution.lengthLongestPath(s));
        }
    }
}


class Solution
{
    public int lengthLongestPath(String input) {
        int ret = 0;
        String prev_dir = null;
        
        if(input == null || input.length() == 0) { return 0; }
        
        Stack<Integer> stack = new Stack<Integer>();
        String[] items_n = input.split("\n");
        for(String item_n:items_n) {
            String[] items_t = item_n.split("\t");
            int num_tabs = items_t.length - 1;
            String item = items_t[items_t.length-1];
            
            // check if this is a dir or file
            if(item.contains(".")) {
                while(stack.size() > num_tabs) {
                    stack.pop();
                }
                int top = (stack.size() == 0)?0:stack.peek();
                int curr = top + item.length();
                ret = (curr > ret)?curr:ret;
            } else {
                while(stack.size() > num_tabs) {
                    stack.pop();
                }
                int top = (stack.size() == 0)?0:stack.peek();
                stack.push(top + item.length()+1);
            }
        }
        
        return ret;
    }
}
