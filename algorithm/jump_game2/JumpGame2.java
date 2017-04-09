import java.io.*;
import java.util.*;


class JumpGame2
{
    public static void main(String[] args)
    {
	System.out.println("=== Jump Game II ===");
	
	int[] A = {2,3,1,1,4};
	int[] B = {3,2,1,0,4};
	
	Solution solution = new Solution();

	System.out.println("A jump = "+solution.jump(A));
	System.out.println("B jump = "+solution.jump(B));
    }
}


class Solution
{
    public int jump(int[] A)
    {
	int num_jump = 0;
	int idx = 0;
	
	while(idx < A.length)
	{
	    if(idx < A.length-1 && A[idx] == 0)
	    {
		return -1;
	    }
	    else if(idx + A[idx] >= A.length-1)
	    {
		if(idx < A.length-1) { num_jump += 1; }
		return num_jump;
	    }
	    else
	    {
		int target_jump = 0;
		int max_reach = 0;

		for(int i = 1; i <= A[idx]; i++)
		{
		    int reach = i + A[idx+i];
		    if(reach > max_reach)
		    {
			max_reach = reach;
			target_jump = i;
		    }
		}

		idx += target_jump;
		
		num_jump += 1;
	    }
	}
	
	return num_jump;
    }
}
