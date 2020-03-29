import java.io.*;
import java.util.*;


class SortColors
{
    public static void main(String[] args){

	System.out.println("=== Sort Colors ===");

	Solution solution = new Solution();

	int[] A = {2,1,1,0,2,0,0,1,1,1,2};
	
	System.out.println("input = "+array_to_string(A));

	solution.sortColors(A);

	System.out.println("result = "+array_to_string(A));
    }

    public static String array_to_string(int[] A) {
	StringBuffer str = new StringBuffer("");
	
	for(int i = 0; i < A.length; i++) {
	    str.append(A[i]+" ");
	}

	return str.toString();
    }
     
}


class Solution
{
    public Solution(){
    }

    public void sortColors(int[] A) {
	for(int i = 0; i < A.length; i++)
	{
	    for(int j = i+1; j < A.length; j++)
	    {
		if(A[i] > A[j])
		{
		    // swap i and j
		    int tmp = A[i];
		    A[i] = A[j];
		    A[j] = tmp;
		}
	    }
	}
    }
}