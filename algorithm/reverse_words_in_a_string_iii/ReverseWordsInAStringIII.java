import java.io.*;
import java.util.*;


class ReverseWordsInAStringIII
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Words in a String III ===");
	Solution solution = new Solution();

        String s = "Let's take LeetCode contest";

        System.out.println("s = \""+s+"\", reverse = \""+solution.reverseWords(s)+"\"");
    }
}


class Solution
{
    public String reverseWords(String s) {
        if(s == null) { return null; }
        StringBuffer total = new StringBuffer();
        StringBuffer buf = new StringBuffer();
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                if(buf.length() > 0) {
                    total.append(buf.reverse());
                    buf = new StringBuffer();
                }
                total.append(ch);
            } else {
                buf.append(ch);
            }
        }
        
        if(buf.length() > 0) {
            total.append(buf.reverse());
        }

        return total.toString();
    }
}
