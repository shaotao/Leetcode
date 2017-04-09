import java.io.*;
import java.util.*;


class UniquePaths2
{
    public static void main(String[] args)
    {
	System.out.println("=== Unique Paths II ===");
	Solution solution = new Solution();
	
	int[][] grid = { {0, 0, 0},
			 {0, 1, 0},
			 {0, 0, 0} };
	
	int count = solution.uniquePathsWithObstacles(grid);

	System.out.println("grid: ");
	for(int i = 0; i < grid.length; i++)
	{
	    for(int j = 0; j < grid[0].length; j++)
	    {
		System.out.print(grid[i][j]+" ");
	    }
	    System.out.println();
	}
	
	System.out.println("num of unique paths = "+count);
    }
}


class Solution
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
	// get the num_rows and num_cols
	int num_rows = obstacleGrid.length;
	int num_cols = obstacleGrid[0].length;

	if(num_rows == 0 || num_cols == 0) { return 0; }

	// create a cost grid
	int[][] count_map = new int[num_rows][num_cols];

	// initialize the count_map, first row and first col to be 1
	// first row
	count_map[0][0] = obstacleGrid[0][0] == 1? 0:1;
	for(int j = 1; j < num_cols; j++)
	{
	    count_map[0][j] = (obstacleGrid[0][j] == 1)? 0:count_map[0][j-1]; 
	}

	// first column
	for(int i = 1; i < num_rows; i++) 
	{
	    count_map[i][0] = (obstacleGrid[i][0] == 1)? 0:count_map[i-1][0]; 
	}
	
	// start to scan the count_map
	for(int i = 1; i < num_rows; i++)
	{
	    for(int j = 1; j < num_cols; j++)
	    {
		if(obstacleGrid[i][j] == 1)
		{
		    count_map[i][j] = 0;
		}
		else
		{
		    int count_left = count_map[i][j-1];
		    int count_up = count_map[i-1][j];
		    count_map[i][j] = count_left + count_up;
		}
	    }
	}

	// return the result
	return count_map[num_rows-1][num_cols-1];
    }
}
