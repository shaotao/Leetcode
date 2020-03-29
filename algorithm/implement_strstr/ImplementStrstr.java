import java.io.*;
import java.util.*;


class ImplementStrstr
{
    public static void main(String[] args)
    {
        System.out.println("=== Implement strStr ===");
        
        Solution solution = new Solution();
        
        String haystack = "a";
        String needle = "";
        
        System.out.println("haystack = "+haystack);
        System.out.println("needle = "+needle);
        
        System.out.println("found = "+solution.strStr(haystack, needle));
    }
}


class Solution
{
    public String strStr(String haystack, String needle)
    {
        if(haystack == null || needle == null) { return null; }

        if(haystack.length() < needle.length() ) { return null; }

        for(int i = 0; i <= haystack.length() - needle.length(); i++)
        {
            boolean found = true;
            for(int j = 0; j < needle.length(); j++)
            {
                if(haystack.charAt(i+j) != needle.charAt(j))
                {
                    found = false;
                    break;
                }
            }
            
            if(found == true) { return haystack.substring(i); }
        }
        
        return null;
    }
}