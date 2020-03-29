import java.io.*;
import java.util.*;


class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Common Prefix ===");
    
        String[] strs = {"123", "1", "12"};
        Solution solution = new Solution();
        
        String ret = solution.longestCommonPrefix(strs);
        
        System.out.println("longest common prefix = \""+ret+"\"");
    }
}


class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        int size = 0;
        StringBuffer buf = new StringBuffer();
        
        for(int i = 0; i < strs.length; i++)
        {
            if(i == 0 || strs[i].length() < size)
            {
                size = strs[i].length();
            }
        }

        for(int idx = 0; idx < size; idx++)
        {
            boolean common = true;

            char ch = strs[0].charAt(idx);
            for(int i = 1; i < strs.length; i++)
            {
                if(ch != strs[i].charAt(idx))
                {
                    common = false;
                    break;
                }
            }

            if(common == true)
            {
                buf.append(ch);
            }
            else
            {
                break;
            }
        }

        return buf.toString();
    }
}