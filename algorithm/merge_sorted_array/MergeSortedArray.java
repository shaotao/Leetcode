import java.io.*;
import java.io.*;


class MergeSortedArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Merge Sorted Array ===");
	
	Solution solution = new Solution();
	int[] A = new int[10];
	A[0] = 1; A[1] = 3; A[2] = 5; A[3] = 7; A[4] = 9;
	int[] B = {2, 4, 6, 8, 10};
	
	int m = 5;
	int n = 5;
	solution.merge(A, m, B, n);
	
	System.out.print("array: ");
	for(int i = 0; i < (m+n); i++)
	{
	    System.out.print(A[i]+" ");
	}
	System.out.println();
    }
}


class Solution
{
    public void merge(int A[], int m, int B[], int n)
    {
	// the start idx of array A
	int start_idx = 0;
	
	// size of A, will increase as more elements are added
	int size = m;

	for(int idx_b = 0; idx_b < n; idx_b++)
	{
	    int element = B[idx_b];
	    int idx = 0;
	    for(idx = start_idx; idx < size; idx++)
	    {
		// find the insert idx
		if(element < A[idx])
		{
		    break;
		}
	    }
	    
	    // shift all elements from [idx, size-1] to the right by 1
	    // update the size
	    size += 1;

	    for(int i = size-1; i > idx; i--)
	    {
		A[i] = A[i-1];
	    }
	    // ok, insert element to idx
	    A[idx] = element;
	    
	    // update start_idx;
	    start_idx = idx;	    
	}
    }
}
