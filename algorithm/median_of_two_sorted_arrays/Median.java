import java.io.*;
import java.util.*;

class Median
{
    public static void main(String[] args)
    {
	System.out.println("=== Median of two sorted arrays ===");
	
	Solution solution = new Solution();
        
        int[] A = {2,3,4,5,6,8,9,11};
        int[] B = {1,7,10};

        double median = solution.findMedianSortedArrays(A, B);
        
        print_array("Array A: ", A);
        print_array("Array B: ", B);

        System.out.println("median = "+median);
    }
    
    public static void print_array(String title, int array[])
    {
        System.out.print(title);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if(i < array.length-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}


class Solution
{
    public Solution()
    {
    }

    public double findMedianSortedArrays(int A[], int B[])
    {
	int[] array = new int[A.length + B.length];
	
	int idx_a = 0;
	int idx_b = 0;

        int size = 0;
	while(idx_a < A.length && idx_b < B.length)
        {
            if(A[idx_a] <= B[idx_b])
            {
                // insert A item to array, increase idx_a
                array[size] = A[idx_a];
                size++;
                idx_a++;
            }
            else
            {
                // insert B item to array, increase idx_b
                array[size] = B[idx_b];
                size++;
                idx_b++;
            }
        }
        
        if(idx_a < A.length)
        {
            for(int i = idx_a; i < A.length; i++)
            {
                array[size] = A[i];
                size++;
            }
        }
        else if(idx_b < B.length)
        {
            for(int i = idx_b; i < B.length; i++)
            {
                array[size] = B[i];
                size++;
            }
        }
        
        if(array.length <= 0)
        {
            System.out.println("array is empty. no valid median!");
            return -1;
        }
        else
        {
            if(array.length%2 == 0)
            {
                return (array[array.length/2] + array[array.length/2-1])/2.0;
            }
            else
            {
                return array[array.length/2];
            }
        }

    }
}
