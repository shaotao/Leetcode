import java.io.*;
import java.util.*;


class Divide
{
    public static void main(String args[])
    {
	Solution solution = new Solution();

	int a = 5;
	int b = 2;

	//int a = 2147483647;
	//int b = 1;
	  
	//long a = -2147483648;
	//long b = -2147483648;

	//long a = -2147483648;
	//long b = 1;

	long s = System.nanoTime();
	long result = solution.divide(a, b);
	long e = System.nanoTime();
	System.out.println("1. a = "+a+", b = "+b+", a/b = "+result+", time = "+(e-s));
	
	s = System.nanoTime();
	long result2 = solution.divide2(a, b);
	e = System.nanoTime();
	System.out.println("2. a = "+a+", b = "+b+", a/b = "+result2+", time = "+(e-s));
    }
}

class Solution
{
    public long divide(long dividend, long divisor)
    {
	int sign = 1;

	if( (dividend > 0 && divisor < 0) ||
	    (dividend < 0 && divisor > 0))
	{
	    sign = -1;
	}

	long a = Math.abs(dividend);
	long b = Math.abs(divisor);

	if(a < b)
	{
	    return 0;
	}


	long tmp = b;

	long count = 0;

	while(a>=tmp)
	{
	    count += 1;
	    tmp += tmp;
	}

	if(tmp > a)
	{
	    tmp = tmp >>1;
	    count -= 1;
	}

	long tmp_a = a;
	long result = 0;
	long i = count;
	long two = 2;
	while(tmp_a >= b)
	{
	    //System.out.println("tmp_a = "+tmp_a+", tmp = "+tmp);

	    if(tmp_a >= tmp)
	    {
		if(i > 0)
		{
		    result += two<<(i-1);
		}
		else
		{
		    result += 1;
		}

		tmp_a -= tmp;
	    }

	    tmp = tmp>>1;
	    i -= 1;	    
	}

	result *= sign;

	return result;	
    }

    public long divide2(long dividend, long divisor)
    {
	int sign = 1;

	if( (dividend > 0 && divisor < 0) ||
	    (dividend < 0 && divisor > 0))
	{
	    sign = -1;
	}
	
	long a = Math.abs(dividend);
	long b = Math.abs(divisor);
	long two = 2;

	if(a < b)
	{
	    return 0;
	}

	long result = 0;
	
	while(a >= b)
	{
	    long tmp = b;
	    long i = 0;

	    while(a >= tmp)
	    {
		tmp = tmp <<1;
		i += 1;
	    }

	    if(tmp > a)
	    {
		tmp = tmp>>1;
		i -= 1;
	    }

	    a -= tmp;

	    //System.out.println("a = "+a+", tmp = "+tmp+", i = "+i);

	    if(i >= 1)
	    {
		result += (two << (i-1));
	    }
	    else
	    {
		result += 1;
	    }
	}

	result *= sign;

	return result;
    }
}

