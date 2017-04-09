import java.io.*;
import java.util.*;


class WildCard
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();

	//String s = "aa";
	//String p = "*";

	String s = "aaaabaabaabbbabaabaabbbbaabaaabaaabbabbbaaabbbbbbabababbaabbabbbbaababaaabbbababbbaabbbaabbaaabbbaabbbbbaaaabaaabaabbabbbaabababbaabbbabababbaabaaababbbbbabaababbbabbabaaaaaababbbbaabbbbaaababbbbaabbbbb";
	String p = "**a*b*b**b*b****bb******b***babaab*ba*a*aaa***baa****b***bbbb*bbaa*a***a*a*****a*b*a*a**ba***aa*a**a*";

	//String s = "ho";
	//String p = "ho**";

	boolean ret = solution.isMatch(s, p);
	System.out.println("s = "+s+", p = "+p+", match = "+ret);
    }
    
}

class Solution
{
    public boolean isMatch(String s, String p)
    {
	if(isMyMatch(s, p) == 0)
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }

    // 0 - match
    // -1 - failed
    // -2 - fail the entire loop
    public int isMyMatch(String s, String p)
    {

        //System.out.println("s = "+s+", p = "+p);
        
    	// simplifying **..** to * to avoid deep recursion
    	StringBuffer short_p = new StringBuffer("");

	// check str seq
	if(check_str_seq(s, p) < 0)
	{
	    return -2;
	}

	if(p.length() <= 0)
	{
	    if(s.length() <= 0)
	    {
		return 0;
	    }
	    else
	    {
		return -1;
	    }
	}

	short_p.append(p.charAt(0));
    	char prev_char = p.charAt(0);
    	
    	for(int idx_char = 1; idx_char < p.length(); idx_char++)
    	{
    	    if(prev_char == '*' && prev_char == p.charAt(idx_char))
    	    {
    	    	continue;
    	    }
    	    
    	    short_p.append(p.charAt(idx_char));
    	    prev_char = p.charAt(idx_char);
    	}
    	
    	return isMyMatch2(s, short_p.toString());
    }
	
    // recursive isMatch() method, using short_p
    public int isMyMatch2(String s, String p)
    {
	if(p.length() == 0)
	{
	    if(s.length() == 0)
	    {
		return 0;
	    }
	    else
	    {
		return -1;
	    }
	}

	if(s.length() == 0)
	{
	    String next_p = "";
	    
	    if(p.length() > 1)
	    {
		next_p = p.substring(1, p.length());
	    }

	    if(p.charAt(0) == '*')
	    {
		return isMyMatch(s, next_p);
	    }
	    else
	    {
		return -1;
	    }
	}

	if(p.charAt(0) == '*')
	{
	    String next_p = "";
	    
	    if(p.length() > 1)
	    {
		next_p = p.substring(1, p.length());
	    }

	    for(int matched_len = 0; matched_len <= s.length(); matched_len++)
	    {
		String next_s = "";

		if(matched_len < s.length())
		{
		    next_s = s.substring(matched_len, s.length());
		}

		int ret = isMyMatch(next_s, next_p);
		if(ret == 0)
		{
		    return 0;
		}
		else if(ret == -2)
		{
		    return -2;
		}
	    }

	    return -1;
	}
	else if(p.charAt(0) == '?')
	{
	    String next_s = "";
	    String next_p = "";

	    if(s.length() > 1)
	    {
		next_s = s.substring(1, s.length());
	    }

	    if(p.length() > 1)
	    {
		next_p = p.substring(1, p.length());
	    }

	    return isMyMatch(next_s, next_p);
	}
	else
	{
	    // find the head string from s
	    // idx_s is the index of the next "?" or "*"
	    int idx_s = -1;
	    int tmp_idx1 = s.indexOf("?");
	    int tmp_idx2 = s.indexOf("*");

	    if( (idx_s < 0 && tmp_idx1 >= 0) ||
		(idx_s >= 0 && tmp_idx1 >= 0 && idx_s > tmp_idx1))
	    {
		idx_s = tmp_idx1;
	    }
	    
	    if( (idx_s < 0 && tmp_idx2 >= 0) ||
		(idx_s >= 0 && tmp_idx2 >= 0 && idx_s > tmp_idx2))
	    {
		idx_s = tmp_idx2;
	    }

	    if(idx_s < 0)
	    {
		idx_s = s.length()-1;
	    }
	    else
	    {
		idx_s -= 1;
	    }
	    
	    // find the head string from p
	    int idx_p = -1;
	    tmp_idx1 = p.indexOf("?");
	    tmp_idx2 = p.indexOf("*");
	    if( (idx_p < 0 && tmp_idx1 >= 0) ||
		(idx_p >= 0 && tmp_idx1 >= 0 && idx_p > tmp_idx1))
	    {
		idx_p = tmp_idx1;
	    }
	    
	    if( (idx_p < 0 && tmp_idx2 >= 0) ||
		(idx_p >= 0 && tmp_idx2 >= 0 && idx_p > tmp_idx2))
	    {
		idx_p = tmp_idx2;
	    }

	    if(idx_p < 0)
	    {
		idx_p = p.length()-1;
	    }
	    else
	    {
		idx_p -= 1;
	    }

	    // compare head string of s and p
	    if(idx_s < idx_p)
	    {
		// different length, unmatched string!
		return -1;
	    }

	    // ok, idx_s and idx_p are equal, now compare the string
	    if(s.substring(0, idx_p+1).equals(p.substring(0, idx_p+1)) == false)
	    {
		// the string contents don't match
		return -1;
	    }

	    // ok, the string contents match, try to check the next part
	    String next_s = "";
	    String next_p = "";

	    if(idx_p < s.length()-1)
	    {
		next_s = s.substring(idx_p+1, s.length());
	    }

	    if(idx_p < p.length() - 1)
	    {
		next_p = p.substring(idx_p+1, p.length());
	    }

	    return isMyMatch(next_s, next_p);
	}
    }

    public int check_str_seq(String s, String p)
    {
	int idx_s = 0;
	int len_s = s.length();

	int p_head = -1;
	int p_tail = -1;

	// make sure p has no more normal characters than s
	int count_p_char = 0;
	for(int idx_p = 0; idx_p < p.length(); idx_p++)
	{
	    if(p.charAt(idx_p) != '*' && p.charAt(idx_p) != '?')
	    {
		count_p_char += 1;
	    }
	}

	if(count_p_char > len_s)
	{
	    //System.out.println("too short!");
	    return -2;
	}

	for(int idx_p = 0; idx_p < p.length(); idx_p++)
	{
	    String s_str = "";
	    if(idx_s < len_s)
	    {
		s_str = s.substring(idx_s, len_s);
	    }
	    
	    char p_char = p.charAt(idx_p);

	    if(p.charAt(idx_p) == '*')
	    {
		if(p_head == -1)
		{
		    continue;
		}
		else
		{
		    if(s_str.indexOf(p.substring(p_head, p_tail+1)) < 0)
		    {
			return -2;
		    }
		    
		    p_head = -1;
		    p_tail = -1;
		    idx_s += (p_tail - p_head+1);
		}
	    }
	    else if(p.charAt(idx_p) == '?')
	    {
		if(idx_s >= len_s)
		{
		    return -2;
		}

		if(p_head == -1)
		{
		    idx_s += 1;
		}
		else
		{
		    if(s_str.indexOf(p.substring(p_head, p_tail+1)) < 0)
		    {
			return -2;
		    }

		    p_head = -1;
		    p_tail = -1;
		    idx_s += (p_tail -p_head+1) + 1;
		}
	    }
	    else
	    {
		if(idx_s >= len_s)
		{
		    return -2;
		}

		if(p_head < 0)
		{
		    p_head = idx_p;
		}

		p_tail = idx_p;
		
	    }
	}

	// try to check the last match, last part of p[p_head, p_tail] must match
	// the last part of s
	if(p_head >= 0)
	{
	    int last_idx_s = s.lastIndexOf(p.substring(p_head, p_tail+1));
	    
	    if(last_idx_s < 0 || 
	       last_idx_s + p_tail - p_head + 1 < len_s)
	       {
		   return -2;
	       }
	}
	
	return 0;
    }

}
