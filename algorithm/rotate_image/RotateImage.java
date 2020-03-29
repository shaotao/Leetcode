import java.io.*;
import java.util.*;


class RotateImage
{
    public static void main(String[] args)
    {
	System.out.println("=== Rotate Image ===");

	Solution solution = new Solution();

	int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
	//int[][] matrix = {{1,2}, {3, 4}};
	
	System.out.println("before rotate: ");
	print_matrix(matrix);

	//solution.rotate(matrix);
	solution.rotate_inplace(matrix);

	System.out.println("after rotate: ");
	print_matrix(matrix);
    }

    public static void print_matrix(int[][] matrix)
    {
	if(matrix.length == 0)
	{
	    return;
	}

	System.out.println(">>> print matrix >>>");
	for(int i = 0; i < matrix.length; i++)
	{
	    for(int j = 0; j < matrix[0].length; j++)
	    {
		System.out.print(matrix[i][j]+" ");
	    }
	    System.out.println();
	}

	System.out.println("<<< print matrix <<<");
    }
}


class Solution
{
    public Solution()
    {
    }

    public void rotate(int[][] matrix)
    {
	if(matrix.length == 0 || matrix[0].length == 0)
	{
	    return;
	}

	int num_rows = matrix.length;
	int num_cols = matrix[0].length;
	
	int[][] temp = new int[num_rows][num_cols];

	System.out.println("num_rows = "+num_rows+", num_cols = "+num_cols);

	for(int i = 0; i < num_rows; i++)
	{
	    for(int j = 0; j < num_cols; j++)
	    {
		System.out.println("i = "+i+", j = "+j);
		temp[j][num_rows - i-1] = matrix[i][j];
	    }
	}

	for(int i = 0; i < num_rows; i++)
	{
	    for(int j = 0; j < num_cols; j++)
	    {
		matrix[i][j] = temp[i][j];
	    }
	}
    }
    
    public void rotate_inplace(int[][] matrix)
    {
	if(matrix.length == 0 || matrix[0].length == 0)
	{
	    return;
	}

	int num_rows = matrix.length;
	int num_cols = matrix[0].length;

	for(int i = 0; i <= (num_rows-1)/2; i++)
	{
	    for(int j = 0; j < num_cols/2; j++)
	    {
		// only choose the point in the first quarter
		// to apply the transition 4 times
		int temp = matrix[i][j];
		matrix[i][j] = matrix[num_rows-j-1][i];
		matrix[num_rows-j-1][i] = matrix[num_rows-i-1][num_rows-j-1];
		matrix[num_rows-i-1][num_rows-j-1] = matrix[j][num_rows-i-1];
		matrix[j][num_rows-i-1] = temp;
	    }
	}
    }
}
