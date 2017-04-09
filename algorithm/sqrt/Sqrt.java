import java.io.*;
import java.util.*;


class Sqrt
{
    public static void main(String[] args)
    {
	System.out.println("=== Sqrt(x) ===");
	Solution solution = new Solution();

	//int num = 65536;
	//int num = 2147395599;
	//int num = 0;
	int num = 2147395599;
	int result = solution.sqrt(num);

	System.out.println("sqrt("+num+") = "+result);
    }
}

class Solution
{
    public int sqrt(int x)
    {
	int a = 0;
	int b = 1024*64;
	
	int curr = (a+b)/2;
	//System.out.println("65535**2 = "+curr*curr);
	int result = curr*curr;
	while(result != x && a <= b)
	{
	    //System.out.println("a = "+a+", b = "+b+", curr = "+curr+", curr**2 = "+curr*curr);
	    if(result >= 0 && result < x)
	    {
		if(curr == a) { a++; }
		else { a = curr; }
	    }
	    else
	    {
		if(curr == b) { b--; }
		else { b = curr; }
	    }

	    curr = (a+b)/2;
	    result = curr*curr;
	}

	return curr;
    }
}
