import java.io.*;
import java.util.*;


class Pow
{
    public static void main(String[] args)
    {
	System.out.println("=== Pow ===");
	double x = 0.00001;
	int n = 2147483647;
	
	Solution solution = new Solution();

	double result = solution.pow(x, n);

	System.out.println("pow("+x+", "+n+") = "+result);
    }
}

class Solution
{
    public Solution()
    {
    }

    public double pow(double x, int n)
    {
	double result = 1;
	int num_rounds = n;
	if(num_rounds < 0)
	{
	    num_rounds *= -1;
	}

	// get the bit map of the num_rounds
	ArrayList<Integer> list = new ArrayList<Integer>();

	int num = num_rounds;

	int i = 0;
	while(num > 0)
	{
	    if(num % 2 == 1)
	    {
		list.add(i);
	    }
	    
	    num /= 2;
	    i++;
	}

	//System.out.println("list = "+list);

	for(int idx = 0; idx < list.size(); idx++)
	{
	    double tmp = x;
	    for(int j = 0; j < list.get(idx); j++)
	    {
		tmp *= tmp;
	    }
	    
	    result *= tmp;
	}

	if(num_rounds != n) { return 1.0/result; }
	return result;
    }
}
