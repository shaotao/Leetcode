import java.io.*;
import java.util.*;


class IsMatch
{
    public static void main(String[] args)
    {
	System.out.println("=== welcome to IsMatch! ===");

	Solution solution = new Solution();

	String s = "aaaaaaaaaaaaab";
	String p = "a*a*a*a*a*a*a*a*a*a*c";


	boolean match = solution.isMatch(s, p);
	System.out.println("s = "+s);
	System.out.println("p = "+p);
	System.out.println("match = "+match);
    }
}


class Solution
{
    public Solution()
    {
    }

    public String trim_p(String p)
    {
	// combine a*a*a* to a*
	StringBuffer buf_p = new StringBuffer("");

	for(int i = 0; i < p.length(); i++)
	{
	    char ch = p.charAt(i);
	    
	    int buf_size = buf_p.length();
	    if(ch == '*' && buf_size >= 3 && 
	       buf_p.charAt(buf_size-1) == buf_p.charAt(buf_size-3) &&
	       buf_p.charAt(buf_size-2) == '*')
	    {
		buf_p.deleteCharAt(buf_size-1);
	    }
	    else
	    {
		buf_p.append(ch);
	    }
	}
	
	return buf_p.toString();
    }

    boolean isMatch(String s, String p)
    {
	String p2 = trim_p(p);
	
	return isMatch_recur(s, p2);
    }

    boolean isMatch_recur(String s, String p)
    {
	String next_s = "";
	String next_p = "";

	if(s.length() > 1)
	{
	    next_s = s.substring(1);
	}
	
	if(p.length() > 1)
	{
	    next_p = p.substring(1);
	}

	if(p.length() == 0)
	{
	    if(s.length() == 0)
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	
	// ok, p length is not 0, we still have pattern to match
	if(p.charAt(0) == '.')
	{
	    // need to check if p[1] is *
	    if(p.length() > 1 && p.charAt(1) == '*')
	    {
		// must check for 0 or n occurrance
		next_p = "";
		if(p.length() > 2)
		{
		    next_p = p.substring(2);
		}

		boolean ret = isMatch(s, next_p);
		if(ret == true)
		{
		    return true;
		}

		int i = 0;
		for(i = 0; i < s.length(); i++)
		{
		    ret = isMatch(s.substring(i), next_p);
		    if(ret == true)
		    {
			return true;
		    }
		}

		// if s is all matched ""
		if(i == s.length())
		{
		    ret = isMatch("", next_p);
		    if(ret == true)
		    {
			return true;
		    }
		}

		return false;
	    }
	    else
	    {
		// any character
		if(s.length() == 0)
		{
		    return false;
		}
		
		return isMatch(next_s, next_p);
	    }
	}
	else
	{
	    // p[0] is normal character
	    // need to check if p[1] is *
	    if(p.length() > 1 && p.charAt(1) == '*')
	    {
		// must check for 0 or n occurrance
		next_p = "";
		if(p.length() > 2)
		{
		    next_p = p.substring(2);
		}

		// if s is ""
		boolean ret = isMatch(s, next_p);
		if(ret == true)
		{
		    return true;
		}

		int i = 0;
		for(i = 0; i < s.length(); i++)
		{
		    ret = isMatch(s.substring(i), next_p);
		    if(ret == true)
		    {
			return true;
		    }

		    if(s.charAt(i) != p.charAt(0))
		    {
			break;
		    }
		}

		// if s is all matched ""
		if(i == s.length())
		{
		    ret = isMatch("", next_p);
		    if(ret == true)
		    {
			return true;
		    }
		}

		return false;
	    }
	    else
	    {
		
		// need an exact match of a chacter
		if(s.length() == 0)
		{
		    return false;
		}
		
		if(s.charAt(0) != p.charAt(0))
		{
		    return false;
		}
		
		return isMatch(next_s, next_p);
	    }
	}
	
	// we should not get here
	//return false;
    }

}

