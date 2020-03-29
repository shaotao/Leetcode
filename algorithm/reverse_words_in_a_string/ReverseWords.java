import java.io.*;
import java.util.*;


class ReverseWords
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Words in a String ===");
	Solution solution = new Solution();
	String s = "        the   sky         is   blue    ";
	String ret = solution.reverseWords(s);
	System.out.println("s = |"+s+"|");
	System.out.println("ret = |"+ret+"|");
    }
}

class Solution
{
    public String reverseWords(String s)
    {
        if(s == null) { return null; }
        
        StringBuffer ret = new StringBuffer("");
        StringBuffer word = new StringBuffer("");
	for(int i = 0; i < s.length(); i++) 
	{
            char ch = s.charAt(i);
            
            if(ch != ' ')
            {
                word.append(ch);
            }
            else
            {
                if(word.length() > 0)
                {
                    if(ret.length() > 0)
                    {
                        ret.insert(0, ' ');
                    }
                    ret.insert(0, word);
                    word.delete(0, word.length());
                }
            }            
	}
        
        if(word.length() > 0)
        {
            if(ret.length() > 0)
            {
                ret.insert(0, ' ');
            }
            ret.insert(0, word);
            word.delete(0, word.length());
        }
        
        return ret.toString();
    }
}
