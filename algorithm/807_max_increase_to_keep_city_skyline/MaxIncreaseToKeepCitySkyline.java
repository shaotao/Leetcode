import java.io.*;
import java.util.*;


class MaxIncreaseToKeepCitySkyline
{
    public static void main(String[] args)
    {
        System.out.println("=== Max Increase to Keep City Skyline ===");
        Solution solution = new Solution();
        int[][] grid = {{3,0,8,4},
                        {2,4,5,7},
                        {9,2,6,3},
                        {0,3,1,0}};
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("max increase = "+solution.maxIncreaseKeepingSkyline(grid));
    }
}


class Solution
{
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ret = 0;
        int n = grid.length;
        int[] max_by_row = new int[n];
        int[] max_by_col = new int[n];
        int old_sum = 0;
        for(int i = 0; i < n; i++) {
            int max_row = grid[i][0];
            for (int j = 0; j < n; j++) {
                max_row = (max_row > grid[i][j])?max_row:grid[i][j];
                old_sum += grid[i][j];
            }
            max_by_row[i] = max_row;
        }

        for(int j = 0; j < n; j++) {
            int max_col = grid[0][j];
            for (int i = 0; i < n; i++) {
                max_col = (max_col > grid[i][j])?max_col:grid[i][j];
            }
            max_by_col[j] = max_col;
        }

        //System.out.println("max_by_row = "+Arrays.toString(max_by_row));
        //System.out.println("max_by_col = "+Arrays.toString(max_by_col));
        
        // scan for the max sky line grid
        int new_sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_sum += (max_by_row[i]<max_by_col[j])?max_by_row[i]:max_by_col[j];
            }
        }
        
        return new_sum - old_sum;
    }
}
