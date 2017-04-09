import java.io.*;
import java.util.*;


class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
	System.out.println("=== Longest Palindromic Substring ===");
	Solution solution = new Solution();
	String s = "1234432112344321";
	String result = solution.longestPalindrome(s);
	
	System.out.println("s = "+s);
	System.out.println("longest palindrome substring = "+result);
    }
}


class Solution
{
    public String longestPalindrome(String s)
    {
	// scan each between the first char and last char
	int foot = 1; // right = 1, left = 0
	int start_left = 0;
	int start_right = 0;

	int max_left = 0;
	int max_right = 0;
	int max_length = 0;
	
	while(start_left < s.length() && start_right < s.length())
	{
	    int left = start_left;
	    int right = start_right;
	    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
	    {
		int length = right - left + 1;
		if(length > max_length)
		{
		    max_length = length;
		    max_left = left;
		    max_right = right;
		}
		
		left--;
		right++;
	    }
	    
	    if(foot == 1)
	    {
		start_right++;
		foot = 0;
	    }
	    else
	    {
		start_left++;
		foot = 1;
	    }
	}
	
	return s.substring(max_left, max_right+1);
    }
}
