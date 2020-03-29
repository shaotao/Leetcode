import java.io.*;
import java.util.*;


class TrapWater
{
    public static void main(String[] args)
    {
	System.out.println("=== TrapWater ===");
	
	Solution solution = new Solution();

	int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};

        int result = solution.trap(input);

	System.out.println("Water trapped = "+result);
    }
}


class Solution
{
    public Solution()
    {
    }

    public int trap(int[] A)
    {
	// scan for the volumne
	
	int total = 0;

	int size = A.length;

	for(int i = 0; i < size; i++)
	{
	    int cur = A[i];

	    // now we scan the left and right
	    // to get the amount of water trapped
	    // in this slot

	    // get the maximum value higher that cur
	    // on the left and right sides,
	    // the amount of water trapped is 
	    // min(left - cur, right - cur)
	    // while left > cur, right > cur;
	    
	    int left = -1;
	    int right = -1;

	    // scan left
	    for(int j = 0; j < i; j++)
	    {
		if(A[j] > cur && A[j] > left)
		{
		    left = A[j];
		}
	    }

	    // scan right
	    for(int j = i+1; j < size; j++)
	    {
		if(A[j] > cur && A[j] > right)
		{
		    right = A[j];
		}
	    }

	    if(left < 0 || right < 0)
	    {
		// no water to trap
		continue;
	    }

	    // if both left and right are set
	    // some water is trapped
	    total += Math.min(left - cur, right - cur);
	}

	return total;
    }
}
