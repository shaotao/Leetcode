import java.io.*;
import java.util.*;


class ReverseWordsInAStringIII
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Words in a String III ===");
	Solution solution = new Solution();
        String s = "Let's take LeetCode contest";
        String ret = solution.reverseWords(s);
        System.out.println("s = "+s);
        System.out.println("reverse = "+ret);
    }
}


class Solution
{
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) { return s; }

        ArrayList<String> list = new ArrayList<String>();
        String[] strs = s.split(" ");
        for(String str : strs) {
            StringBuffer buf = new StringBuffer(str);
            list.add(buf.reverse().toString());
        }

        return String.join(" ", list);
    }
}
