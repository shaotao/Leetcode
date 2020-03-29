import java.io.*;
import java.util.*;


class ProjectionAreaOf3DShapes
{
    public static void main(String[] args)
    {
        System.out.println("=== Projection Area of 3D Shapes ===");
        Solution solution = new Solution();

        int[][] grid = new int[][]{{1,0}, {0,2}};
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("projection area = "+solution.projectionArea(grid));

        grid = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("projection area = "+solution.projectionArea(grid));

        grid = new int[][]{{2,2,2}, {2,1,2}, {2,2,2}};
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("projection area = "+solution.projectionArea(grid));
    }
}


class Solution
{
    public int projectionArea(int[][] grid) {
        int ret = 0;
        int n = grid.length;        
        for (int i = 0; i < n; i++) {
            int max_a = 0;
            int max_b = 0;
            int count_c = 0;
            for (int j = 0; j < n; j++) {
                max_a = (max_a>=grid[i][j])?max_a:grid[i][j];
                max_b = (max_b>=grid[j][i])?max_b:grid[j][i];
                count_c += (grid[i][j]>0)?1:0;
            }
            ret += (max_a + max_b + count_c);
            
        }

        return ret;
    }
}
