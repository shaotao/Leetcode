import java.io.*;
import java.util.*;


class JumpGame
{
    public static void main(String[] args)
    {
	System.out.println("=== Jump Game ===");
	
	int[] A = {2,3,1,1,4};
	int[] B = {3,2,1,0,4};
	
	Solution solution = new Solution();

	System.out.println("A can jump = "+solution.canJump(A));
	System.out.println("B can jump = "+solution.canJump(B));
    }
}


class Solution
{
    public boolean canJump(int[] A)
    {
	int idx = 0;
	
	while(idx < A.length)
	{
	    if(idx < A.length-1 && A[idx] == 0)
	    {
		return false;
	    }
	    else if(idx + A[idx] >= A.length-1)
	    {
		return true;
	    }
	    else
	    {
		idx += A[idx];
	    }
	}
	
	return true;
    }
}
