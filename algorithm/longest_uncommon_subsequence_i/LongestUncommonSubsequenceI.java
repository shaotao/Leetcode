import java.io.*;
import java.util.*;


class LongestUncommonSubsequenceI
{
    public static void main(String[] args)
    {
	System.out.println("=== Longest Uncommon Subsequence I ===");
	Solution solution = new Solution();
        String a = "aba";
        String b = "cdc";
        System.out.println("a = "+a+", b = "+b+", longest uncommon subsequence = "+solution.findLUSlength(a, b));
    }
}


class Solution
{
    public int findLUSlength(String a, String b) {

        if(a == null && b != null) { return b.length(); }
        else if (a != null && b == null) { return a.length(); }
        
        if(a.length() < b.length()) {
            return b.length();
        } else if(a.length() > b.length()) {
            return a.length();
        } else {
            if(a.equals(b)) { return -1; }
            else { return a.length(); }
        }
    }
}
