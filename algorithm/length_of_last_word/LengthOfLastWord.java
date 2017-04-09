import java.io.*;
import java.util.*;


class LengthOfLastWord
{
    public static void main(String[] args)
    {
	System.out.println("=== Length of Last Word ===");
	
	Solution solution = new Solution();

	String s = "Hello World";
	System.out.println("s = "+s+", last world length = "+solution.lengthOfLastWord(s));
    }
}


class Solution
{
    public Solution()
    {	
    }

    public int lengthOfLastWord(String s)
    {
	int length = 0;
	int start_idx = s.length() -1;
	while(start_idx >= 0 && s.charAt(start_idx) == ' ') 
	{ 
	    start_idx--; 
	}

	for(int i = start_idx; i >= 0; i--)
	{
	    if(s.charAt(i) != ' ') { length++; }
	    else { return length; }
	}
	
	return length;
    }
}
