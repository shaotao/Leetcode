import java.io.*;
import java.util.*;


class SetMatrixZeroes
{
    public static void main(String[] args) {
	
	System.out.println("=== Set Matrix Zeroes ===");
	
	int[][] matrix = {{0,0,0,5}, {4,3,1,4}, {0,1,1,4}, {1,2,1,3}, {0,0,1,1}};
	
	Solution solution = new Solution();
	
	print_matrix(matrix);

	solution.setZeroes(matrix);

	System.out.println("after set zeroes: ");
	print_matrix(matrix);
    }

    public static void print_matrix(int[][] matrix) {

	int num_rows = matrix.length;
	int num_cols = matrix[0].length;

	for(int i = 0; i < num_rows; i++)
	{
	    for(int j = 0; j < num_cols; j++)
	    {
		System.out.print(matrix[i][j]+" ");
	    }
	    System.out.println();
	}
    }
}


class Solution
{
    public Solution() {
    }

    public void setZeroes(int[][] matrix) {
	
	// scan the matrix and set the rows/cols to zero
	
	int num_rows = matrix.length;
	int num_cols = matrix[0].length;

	ArrayList<Integer> row_list = new ArrayList<Integer>();
	ArrayList<Integer> col_list = new ArrayList<Integer>();

	for(int i = 0; i < num_rows; i++)
	{
	    for(int j = 0; j < num_cols; j++)
	    {
		if(matrix[i][j] == 0)
		{
		    // this item is zero, set the row/col to zero
		    row_list.add(i);
		    col_list.add(j);
		}
	    }
	}
	

	// remove duplicates in the row_list and col_list
	// scan backwards
	ArrayList<Integer> remove_list = new ArrayList<Integer>();
	for(int i = row_list.size()-1; i >= 0; i--)
	{
	    for(int j = i-1; j >= 0; j--)
	    {
		if(row_list.get(i) == row_list.get(j))
		{		    
		    remove_list.add(i);
		    break;
		}
	    }
	}

	// >>> debug here
	// System.out.println("row_list before remove: ");
	// for(int i = 0; i < row_list.size(); i++)
	// {
	//     System.out.print(row_list.get(i)+" ");
	// }
	// System.out.println();
	
	// // remove_list
	// System.out.println("remove list: ");
	// for(int i = 0; i < remove_list.size(); i++)
	// {
	//     System.out.print(remove_list.get(i)+" ");
	// }
	// System.out.println();

	// <<< debug here


	for(int i = 0; i < remove_list.size(); i++)
	{
	    row_list.remove(remove_list.get(i).intValue());
	}

	remove_list.clear();


	// >>> debug here
	// System.out.println("row_list: ");
	// for(int i = 0; i < row_list.size(); i++)
	// {
	//     System.out.print(row_list.get(i)+" ");
	// }
	// System.out.println();
	// << debug here 


	for(int i = col_list.size()-1; i >= 0; i--)
	{
	    for(int j = i-1; j >= 0; j--)
	    {
		if(col_list.get(i) == col_list.get(j))
		{
		    remove_list.add(i);
		    break;
		}
	    }
	}

	for(int i = 0; i < remove_list.size(); i++)
	{
	    col_list.remove(remove_list.get(i).intValue());
	}

	remove_list.clear();

	// >>> debug row_list and col_list
	// System.out.println("col_list: ");
	// for(int i = 0; i < col_list.size(); i++)
	// {
	//     System.out.print(col_list.get(i)+" ");
	// }
	// System.out.println();
	// <<< debug here

	// set to zeroes per row
	for(int i = 0; i < row_list.size(); i++)
	{
	    for(int j = 0; j < num_cols; j++)
	    {
		matrix[row_list.get(i)][j] = 0;
	    }
	}

	// set to zeroes per col
	for(int i = 0; i < col_list.size(); i++)
	{
	    for(int j = 0; j < num_rows; j++)
	    {
		matrix[j][col_list.get(i)] = 0;
	    }
	}
    }
}