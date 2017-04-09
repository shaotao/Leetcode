import java.io.*;
import java.util.*;

class UniquePaths
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();

	//int m = 4;
	//int n = 9;
	    
	int m = 7;
	int n = 6;
	    
	int result = solution.uniquePaths(m, n);
	
	System.out.println("m = "+m+", n = "+n+", paths = "+result);
	
    }    
}


class Solution
{
    public Solution()
    {
    }

    public int uniquePaths(int m, int n)
    {
	int less = m;
	if(less > n)
	{
	    less = n;
	}

	return C_n_k((m+n-2), (less-1));
    }
    
    // select k out of n objects
    public int C_n_k(int n, int k)
    {
	double top = 1;
	double bottom = 1;

	int result = 0;

	if(n < 0 || k < 0 || k > n)
	{
	    return -1;
	}

	if(k == 0 || k == n)
	{
	    return 1;
	}

	for(int i = 0; i < k; i++)
	{
	    top *= (n-i);
	    bottom *= (i+1);
	}

	result = (int)(top/bottom);
	
	return result;
    }
}