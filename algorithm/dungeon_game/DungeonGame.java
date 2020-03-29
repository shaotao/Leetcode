import java.io.*;
import java.util.*;


class DungeonGame
{
    public static void main(String[] args)
    {
        System.out.println("=== Dungeon Game ===");
        Solution solution = new Solution();
        int[][]dungeon = {{-2, -3, 3}, 
                          {-5, -10, 1}, 
                          {10, 30, -5}};
        int hp = solution.calculateMinimumHP(dungeon);

        print_matrix(dungeon);
        System.out.println("hp = "+hp);
    }
    
    public static void print_matrix(int[][] matrix)
    {
        if(matrix == null) { System.out.println("empty matrix!");}
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
    public int calculateMinimumHP(int[][] dungeon)
    {
        if(dungeon == null) { return 1; }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] matrix = new int[m][n];

        for(int sum = m+n-2; sum >= 0; sum--)
        {
            int i = Math.min(sum, m-1);
            int j = sum-i;

            while(i>= 0 && j <= n-1) {
                int r = 0;
                if(i == m-1 && j == n-1) { r = 1; }
                else if(i == m-1 && j < n-1) { r = matrix[i][j+1]; }
                else if(i < m-1 && j == n-1) { r = matrix[i+1][j]; }
                else {r = Math.min(matrix[i+1][j], matrix[i][j+1]);}
                matrix[i][j] = Math.max(1, r - dungeon[i][j]);
                i--;
                j = sum-i;
            }
        }

        return matrix[0][0];
    }
}
