import java.io.*;
import java.util.*;


class ReverseString
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse String ===");
	Solution solution = new Solution();
	String s = "hello";
        System.out.println("s = "+s+", reverse(s) = "+solution.reverseString(s));
    }
}


class Solution
{
    public String reverseString(String s) {
        if(s == null) { return null; }
        StringBuffer buf = new StringBuffer(s);
        buf = buf.reverse();

        return buf.toString();
    }
}
