import java.io.*;
import java.util.*;


class RemoveElement
{
    public static void main(String[] args)
    {
	System.out.println("=== RemoveElement ===");
	
	Solution solution = new Solution();

	int[] A = {1,2,3,4,5,6,7,8,9,0};
	int elem = 6;
	
	print_array(A, A.length);
	System.out.println("remove element: "+elem);

	int size = solution.removeElement(A, elem);

	print_array(A, size);
    }

    public static void print_array(int[] A, int size)
    {
	for(int i = 0; i < size; i++)
	{
	    System.out.print(A[i]+", ");
	}
	System.out.println();	
    }
}


class Solution
{
    public int removeElement(int[] A, int elem)
    {
	int count = 0;

	for(int i = 0; i < A.length; i++)
	{
	    if(A[i] != elem)
	    {
		count++;
	    }
	}

	int i = 0;
	int j = A.length - 1;

	while(i < j)
	{
	    while(i < A.length-1)
	    {
		if(A[i] == elem)
		{
		    break;
		}
		else
		{
		    i++;
		}
	    }

	    while(j > 0)
	    {
		if(A[j] != elem)
		{
		    break;
		}
		else
		{
		    j--;
		}
	    }

	    // compare A[i] and A[j]
	    if(i >= j)
	    {
		break;
	    }

	    // if we get here,
	    if(A[i] == elem && A[j] != elem)
	    {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	    }

	    i++;
	    j--;
	}
	

	return count;
    }
}
