import java.io.*;
import java.util.*;


class IslandPerimeter
{
    public static void main(String[] args)
    {
	System.out.println("=== Island Perimeter ===");
	Solution solution = new Solution();
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        int ret = solution.islandPerimeter(grid);
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("island perimeter = "+ret);
    }
}


class Solution
{
    public int islandPerimeter(int[][] grid) {
        int ret = 0;

        if(grid == null || grid.length == 0) { return 0; }
        if(grid[0].length == 0) { return 0; }

        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) { continue; }
                if(i == 0 || grid[i-1][j] == 0) { ret++; }
                if(i == rows-1 || grid[i+1][j] == 0) { ret++; }
                if(j == 0 || grid[i][j-1] == 0) { ret++; }
                if(j == cols-1 || grid[i][j+1] == 0) { ret++; }
            }
        }
        
        return ret;
    }
}
