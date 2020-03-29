import java.io.*;
import java.util.*;


class InterleavingString
{
    public static void main(String[] args)
    {
        System.out.println("=== Interleaving String ===");
        Solution solution = new Solution();
        
        String[] s1_list = {"aabcc", "aabcc", "aa", "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb"};
        String[] s2_list = {"dbbca", "dbbca", "ab", "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc"};
        
        String[] s3_list = {"aadbbcbcac", "aadbbbaccc", "aaba", "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"};
        
        for(int i = 0; i < s3_list.length; i++)
        {
            String s1 = s1_list[i];
            String s2 = s2_list[i];
            String s3 = s3_list[i];

            System.out.println("s1 = "+s1);
            System.out.println("s2 = "+s2);
            System.out.println("s3 = "+s3+", interleave = "+solution.isInterleave(s1, s2, s3));
        }
    }
}


class Solution
{
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if( ( (s1 == null|| s1.length()==0) && s2.equals(s3)) ||
            (s1.equals(s3) && (s2 == null || s2.length() == 0))) { 
            return true; 
        }

        if(s3.length() != (s1.length() + s2.length())) { return false; }

        boolean try1 = false;
        boolean try2 = false;
        if(s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            try1 = isInterleave(s1.substring(1), s2, s3.substring(1));
        } 
        
        if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
            try2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        return (try1 || try2);
    }
}
