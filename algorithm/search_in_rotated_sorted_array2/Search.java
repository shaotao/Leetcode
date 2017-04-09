import java.io.*;
import java.util.*;


class Search
{
    public static void main(String[] args)
    {
	System.out.println("=== Search in Rotated Sorted Array ===");

	int[] array = {4,5,6,7,0,1,2};
	int target = 1;
	
	Solution solution = new Solution();

	boolean result = solution.search(array, target);
	
	System.out.println("array = "+array_to_string(array));
	System.out.println("target = "+target);
	System.out.println("found = "+result);
    }

    public static String array_to_string(int[] array)
    {
	StringBuffer buf = new StringBuffer("");

	for(int i = 0; i < array.length; i++) {
	    buf.append(array[i]+" ");
	}

	return buf.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public boolean search(int[] A, int target)
    {
	for(int i = 0; i < A.length; i++) {

	    if(A[i] == target) {
		return true;
	    }
	}
	
	return false;
    }
}

