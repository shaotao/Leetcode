import java.io.*;
import java.util.*;


class ScrambleString
{
    public static void main(String[] args)
    {
        System.out.println("=== Scramble String ===");
        
        Solution solution = new Solution();
        
        //String s1 = "great";
        //String s2 = "rgtae";

        //String s1 = "abcd";
        //String s2 = "bdac";
        
        String s1 = "hobobyrqd";
        String s2 = "hbyorqdbo";
 
        boolean ret = solution.isScramble(s1, s2);
        
        System.out.println("s1 = |"+s1+"|, s2 = |"+s2+"|, isScramble = "+ret);
    }
}


class Solution
{
    public boolean same_chars(String s1, String s2)
    {
        //System.out.println("s1 = |"+s1+"|, s2 = |"+s2+"|");

        if(s1.length() != s2.length()) { return false; }

        if(s1.length() == 0) { return true; }

        int[] list = new int[s2.length()];
        for(int i = 0; i < list.length; i++)
        {
            list[i] = i;
        }
        
        // make sure each char in s1 is in buf
        for(int i = 0; i < s1.length(); i++)
        {
            boolean found = false;
            
            for(int j = 0; j < list.length; j++)
            {
                if(list[j] == -1) { continue; }
                else if(s2.charAt(list[j]) == s1.charAt(i))
                {
                    found = true;
                    list[j] = -1;
                    break;
                }
            }

            if(found == false) 
            {
                return false; 
            }
        }
        
        return true;
    }

    public boolean isScramble(String s1, String s2)
    {
        if(s1.length() != s2.length()) { return false; }        
        if(s1.length() == 1 && s1.equals(s2)) { return true; }
        
        if(same_chars(s1, s2) == false) { return false; }
        
        int length = s1.length();

        // search from left or right of s2 and split it
        // direction: 0 - left, 1 - right
        int dir = 0;
        int idx = -1;

        // search for split from left to right on s1
        boolean ret = true;
        for(int i = 0; i < length-1; i++)
        {
            String s1_sub_left = s1.substring(0, i+1);
            String s2_sub_left = s2.substring(0, i+1);

            String s2_sub_right = s2.substring(length-1-i, length);

            if(same_chars(s1_sub_left, s2_sub_left))
            {
                if(isScramble(s1_sub_left, s2_sub_left) &&
                   isScramble(s1.substring(i+1, length), s2.substring(i+1, length)))
                {
                    return true;
                }
            }

            if(same_chars(s1_sub_left, s2_sub_right))
            {
                if(isScramble(s1_sub_left, s2_sub_right) &&
                   isScramble(s1.substring(i+1, length), s2.substring(0, length -i -1)))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
