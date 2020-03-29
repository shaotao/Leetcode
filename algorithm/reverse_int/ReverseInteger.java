import java.io.*;
import java.util.*;


class ReverseInteger
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Integer ===");
	int num = 1234;

	Solution solution = new Solution();

	int result = solution.reverse(num);

	System.out.println("num = "+num);
	System.out.println("result = "+result);
    }
}


class Solution
{
    public int reverse(int x)
    {
        int sign = 0;
	
        int result = 0;
        if(x < 0)
        {
            sign = -1;
            x *= -1;
        }
        else
        {
            sign = 1;
        }
        
        StringBuffer buf = new StringBuffer(x+"");
        
        String str = buf.reverse().toString();
        
        result = sign*Integer.parseInt(str);
        
        return result;
	
    }
}
