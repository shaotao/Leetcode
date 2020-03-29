import java.io.*;
import java.util.*;


class SearchInsert
{
    public static void main(String[] args)
    {
	System.out.println("=== Search Insert Position ===");
	Solution solution = new Solution();

	int[] A = {1, 2, 3, 5};
	int target = 6;

	int result = solution.searchInsert(A, target);
	
	System.out.println("A = "+array_to_string(A));
	System.out.println("target = "+target);

	System.out.println("result = "+result);
    }

    public static String array_to_string(int[] A)
    {
	StringBuffer result = new StringBuffer("");
	
	for(int i = 0; i < A.length; i++)
	{
	    result.append(A[i]+" ");
	}

	return result.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public int searchInsert(int[] A, int target) 
    {
        for(int i = 0; i < A.length; i++)
        {
            if(target <= A[i])
            {
                return i;
            }
        }
        
        return A.length;
        
    }
    
}
