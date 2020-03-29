import java.io.*;
import java.util.*;

class Counter
{
    int val = 0;

    public Counter(int val)
    {
        this.val = val;
    }
}

class DecodeWays
{
    public static void main(String[] args)
    {
        //String s = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";

	String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";

        Solution solution = new Solution();

        int result = solution.numDecodings(s);

        System.out.println("result = "+result);

        int result2 = solution.numDecodings2(s);

        System.out.println("result2 = "+result);

        int result3 = solution.numDecodings3(s);

        System.out.println("result3 = "+result);
    }
}

class Solution
{
    public int numDecodings(String s)
    {
	int count_p2 = -1;
	int count_p1 = -1;

	int size = s.length();

        // filter s, if '0' is in return 0
        if(filter(s) == false)
        {
            return 0;
        }

	count_p1 = 1;
	for(int idx_char = 1; idx_char < size; idx_char++)
	{
	    boolean chain_p2 = check_chain(s, idx_char-2, idx_char-1);
	    boolean chain_p1 = check_chain(s, idx_char-1, idx_char);
	    boolean bind_a1 = check_bind(s, idx_char, idx_char+1);
	    
	    char curr_char = s.charAt(idx_char);

	    int count = 0;

	    if(bind_a1 == true)
	    {
		count = count_p1;
	    }
	    else if(chain_p1 == true && chain_p2 == true && curr_char != '0')
	    {
		count = count_p2 + count_p1;
	    }
	    else if(chain_p1 == true && chain_p2 == false && curr_char != '0')
	    {
		count = 2*count_p1;
	    }
	    else
	    {
		count = count_p1;
	    }

	    count_p2 = count_p1;
	    count_p1 = count;
	}

	return count_p1;
    }

    public boolean check_bind(String s, int i, int j)
    {
	if(s == null || s.length() == 0)
	{
	    return false;
	}

	if(i < 0 || j < 0 || i >= s.length() || j >= s.length() ||
	   (j-1) != 1)
	{
	    return false;
	}

	if( (s.charAt(i) == '1' || s.charAt(i) == '2') &&
	    s.charAt(j) == '0')
	{
	    return true;
	}

	return false;
    }

    public boolean check_chain(String s, int i, int j)
    {
	if(s == null || s.length() == 0)
	{
	    return false;
	}

	if(i < 0 || j < 0 || (j-1) != i || i >= s.length() || j >= s.length())
	{
	    return false;
	}

	// ok, check if s[i] and s[j] is within 1[0-9] or 2[0-6]
	int num_i = Integer.parseInt(s.substring(i, i+1));
	int num_j = Integer.parseInt(s.substring(j, j+1));

	if(num_i == 1 && num_j >= 0 && num_j <= 9)
	{
	    return true;
	}
	else if(num_i == 2 && num_j >= 0 && num_j <= 6)
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }

    // check if s has unmatched '0', '0' should only appear
    // as "10" or "20" A - 1, Z - 26
    public boolean filter(String s)
    {
        char prev_char = '\0';

	if(s == null || s.length() == 0)
	{
	    return false;
	}

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);

            if(curr == '0' && prev_char != '1' && prev_char != '2')
            {
                return false;
            }

            prev_char = curr;
        }

        return true;
    }


    public int numDecodings2(String s)
    {
	ArrayList<Integer> count_list = new ArrayList<Integer>();

	int size = s.length();

        // filter s, if '0' is in return 0
        if(filter(s) == false)
        {
            return 0;
        }

	count_list.add(1);
	for(int idx_char = 1; idx_char < size; idx_char++)
	{
	    boolean chain_p2 = check_chain(s, idx_char-2, idx_char-1);
	    boolean chain_p1 = check_chain(s, idx_char-1, idx_char);

	    int count = 0;

	    //System.out.println("p2 = "+chain_p2+", p1 = "+chain_p1);

	    if(chain_p1 == true && chain_p2 == true)
	    {
		count = count_list.get(idx_char-2) + count_list.get(idx_char-1);
	    }
	    else if(chain_p1 == true && chain_p2 == false)
	    {
		count = 2*count_list.get(idx_char-1);
	    }
	    else
	    {
		count = count_list.get(idx_char-1);
	    }

	    count_list.add(count);
	}

	return count_list.get(size-1);
    }


    public int numDecodings3(String s)
    {
        int result = 0;

        Counter counter = new Counter(1);

        // filter s, if '0' is in return 0
        if(filter(s) == false)
        {
            return 0;
        }

        split(s, counter);

        result = counter.val;

        return result;
    }

    public void split(String s, Counter counter)
    {
        if(s == null || s.length() <= 1)
        {
            return;
        }

        // check the first two characters of s
        // s has at least 2 chars, check if we can split
        String head_str = s.substring(0, 2);
        int number = Integer.parseInt(head_str);
        if(number == 10 || number == 20)
        {
            if(s.length() > 2)
            {
                split(s.substring(2, s.length()), counter);
            }
        }
        else if( (number >= 11 && number <= 19) ||
                 (number >= 21 && number <= 26))
        {
	    // if it is 110, 210, 120, 220, don't split
	    if(s.length() >= 3 && s.charAt(2) == '0')
	    {
		split(s.substring(1, s.length()), counter);
	    }
	    else
	    {
		counter.val += 1;
		
		if(s.length() > 2)
		{
		    split(s.substring(1, s.length()), counter);
		    split(s.substring(2, s.length()), counter);
		}
	    }
        }
        else
        {
            split(s.substring(1, s.length()), counter);
        }
    }
}
