import java.io.*;
import java.util.*;


class RemoveDuplicates2
{
    public static void main(String[] args)
    {
	System.out.println("=== Remove Duplicates From Sorted Array ===");

	Solution solution = new Solution();
	
	int[] array = {1,1,1,1,2,2,3,4,5,5,5,6,7,7,8,9};
	
	print_array(array, array.length);

	int size = solution.removeDuplicates(array);
	
	System.out.println("after removing duplicates:");
	print_array(array, size);
    }

    public static void print_array(int[] array, int size)
    {
	if(size > array.length)
	{
	    System.out.println("size = "+size+" > array.length = "+array.length);
	    System.out.println("resizing to array.length");

	    size = array.length;
	}
	
	for(int i = 0; i < size; i++)
	{
	    if(i < array.length-1)
	    {
		System.out.print(array[i]+", ");
	    }
	    else
	    {
		System.out.println(array[i]);
	    }
	}
    }
}

class Solution
{
    public Solution()
    {
	
    }

    public int removeDuplicates(int[] A)
    {
	int num = 0;
	int prev = 0;

	int count = 0;
	for(int i = 0; i < A.length; i++)
	{
	    if(num == 0 || A[i] != prev || (A[i] == prev && count < 2))
	    {
		A[num] = A[i];

		if(num == 0 || A[i] == prev)
		{
		    count += 1;
		}

		if(A[i] != prev)
		{
		    count = 1;
		}
		
		num += 1;
		prev = A[i];

	    }
	}
	
	return num;
    }
}
