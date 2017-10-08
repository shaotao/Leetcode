import java.io.*;
import java.util.*;


class MaxAreaOfLand
{
    public static void main(String[] args)
    {
        System.out.println("=== Max Area of Land ===");
        Solution solution = new Solution();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int ret = solution.maxAreaOfIsland(grid);
        System.out.println("max area = "+ret);
    }
}


class Solution
{
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        int num_rows = grid.length;
        if(num_rows == 0) { return 0; }        
        int num_cols = grid[0].length;
        if(num_cols == 0) { return 0; }

        for (int i = 0; i< num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if (grid[i][j] != 1) { continue; }
                int count = trace(grid, i, j);
                max = (count > max)?count:max;
            }
        }
        
        return max;
    }

    private int trace(int[][] grid, int x, int y) {
        int num_rows = grid.length;
        int num_cols = grid[0].length;
        
        if (x < 0 || x >= num_rows ||
            y < 0 || y >= num_cols ||
            grid[x][y] != 1) { return 0; }
        else {
            grid[x][y] = 2;
            return 1+trace(grid, x-1, y)+trace(grid, x+1, y)+trace(grid, x, y-1)+trace(grid, x,y+1);
        }
    }
}
