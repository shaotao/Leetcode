import java.io.*;
import java.util.*;


class SurfaceAreaOf3DShapes
{
    public static void main(String[] args)
    {
        System.out.println("=== Surface Area of 3D Shapes ===");
        Solution solution = new Solution();
        int[][][] input = {{{2}},
                           {{1,2}, {3,4}},
                           {{1,0}, {0,2}},
                           {{1,1,1}, {1,0,1}, {1,1,1}},
                           {{2,2,2}, {2,1,2}, {2,2,2}}};
        for (int[][] grid : input) {
            System.out.println("grid = "+Arrays.deepToString(grid));
            System.out.println("3D area = "+solution.surfaceArea(grid));
        }
    }
}


class Solution
{
    public int surfaceArea(int[][] grid) {
        int ret = 0;

        // scan the grid
        for (int i = 0; i < grid.length; i++) {
            int filled = 0;
            for (int j = 0; j < grid.length; j++) {
                int prev = (j==0)?0:grid[i][j-1];
                int next = (j==grid.length-1)?0:grid[i][j+1];
                ret += ((grid[i][j] > prev)?(grid[i][j]-prev):0) +
                    ((grid[i][j] > next)?(grid[i][j]-next):0);
                     
                prev = (j==0)?0:grid[j-1][i];
                next = (j==grid.length-1)?0:grid[j+1][i];
                ret += ((grid[j][i] > prev)?(grid[j][i]-prev):0) +
                    ((grid[j][i] > next)?(grid[j][i]-next):0);
                     
                filled += (grid[i][j]>0)?1:0;
            }
            ret += filled*2;
        }
        
        return ret;
    }
}
