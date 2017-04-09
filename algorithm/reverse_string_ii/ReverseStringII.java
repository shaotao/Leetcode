import java.io.*;
import java.util.*;


class ReverseStringII
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse String II ===");
	Solution solution = new Solution();
        String s = "abcdefg";
        int k = 2;
        String ret = solution.reverseStr(s, k);
        System.out.println(String.format("s=%s, k=%d, reverse=%s", s, k, ret));
    }
}


class Solution
{
    public String reverseStr(String s, int k) {
        StringBuffer buf = new StringBuffer();
        int idx = 0;
        String sub = window(s, idx, k);
        int count = 0;
        while(sub != null) {
            count++;
            idx += sub.length();

            if(count%2 != 0) {
                buf.append(new StringBuffer(sub).reverse());
            } else {
                buf.append(sub);
            }
            
            sub = window(s, idx, k);
        }

        return buf.toString();
    }

    public String window(String s, int startIdx, int k) {
        int length = s.length() - startIdx;
        if(length <= 0) { return null; }

        return s.substring(startIdx, startIdx+((length<k)?length:k));
    }
}
