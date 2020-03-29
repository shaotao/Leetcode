import java.io.*;
import java.util.*;


class MinimumPathSum
{
    public static void main(String[] args)
    {
        System.out.println("=== Minimum Path Sum");
        Solution solution = new Solution();
            
        //int[][] grid = { {1, 1, 1},
        //                 {2, 2, 1},
        //                 {3, 3, 1} };

        int[][] grid = {{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
                        {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
                        {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
                        {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
                        {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
                        {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
                        {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
                        {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
                        {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
                        {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
                        {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
                        {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};

        int min_path_sum = solution.minPathSum(grid);

        System.out.println("grid: ");
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("min_path_sum = "+min_path_sum);
    }
}


class Solution
{
    public int minPathSum(int[][] grid)
    {
        // use another array to store the min cost at each location
        // to (0, 0), since we can only go down or right, the neighbors
        // to check include only the one above it or the one to the left.
        
        // use another grid to store the min cost at each position.
        
        // the cost in row 1 and col 1 can be determined by the direction
        // next, we scan the interior positions
        
        int num_rows = grid.length;
        int num_cols = grid[0].length;

        if(num_rows <= 0 || num_cols <= 0) { return 0; }

        int[][] cost_map = new int[num_rows][num_cols];
        
        // initialize the first row and first column
        for(int j = 0; j < num_cols; j++)
        {
            cost_map[0][j] = grid[0][j] + ((j-1) < 0 ? 0:cost_map[0][j-1]);
        }
        
        for(int i = 0; i < num_rows; i++)
        {
            cost_map[i][0] = grid[i][0] + ( (i-1) < 0 ? 0:cost_map[i-1][0]);
        }
        
        for(int i = 1; i < num_rows; i++)
        {
            for(int j = 1; j < num_cols; j++)
            {
                int left_cost = grid[i][j] + cost_map[i][j-1];
                int up_cost = grid[i][j] + cost_map[i-1][j];
                cost_map[i][j] = left_cost <= up_cost ? left_cost : up_cost;
            }
        }

        // >> debug here
        //System.out.println("cost_map:");
        //for(int i = 0; i < num_rows; i++)
        //{
        //    for(int j = 0; j < num_cols; j++)
        //    {
        //        System.out.print(cost_map[i][j]+" ");
        //    }
        //    System.out.println();
        //}
        // << debug here
        
        return cost_map[num_rows-1][num_cols-1];
    }

    // use recursion to find the minimum cost path
    public int minPathSum2(int[][] grid)
    {
        int result = 0;

        if(grid.length <= 0 || grid[0].length <= 0) { return 0; }

        result = find_min_sum(grid, grid.length-1, grid[0].length-1);

        return result;
    }
    
    public int find_min_sum(int[][] grid, int i, int j)
    {
        if(i <= 0 && j <= 0) { return grid[0][0]; }
        
        if(i > 0 && j == 0)
        {
            // we can only go up
            return grid[i][j] + find_min_sum(grid, i-1, j);
        }
        else if(j > 0 && i == 0)
        {
            // we can only go left
            return grid[i][j] + find_min_sum(grid, i, j-1);
        }
        else
        {
            // we can go either left or up
            int cost_left = grid[i][j] + find_min_sum(grid, i, j-1);
            int cost_up = grid[i][j] + find_min_sum(grid, i-1, j);
            
            return cost_left <= cost_up ? cost_left : cost_up;
        }
    }
}
