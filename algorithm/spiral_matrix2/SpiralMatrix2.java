import java.io.*;
import java.util.*;



class SpiralMatrix2
{
    public static void main(String[] args)
    {
        System.out.println("=== Spiral Matrix II ===");
        Solution solution = new Solution();

        int n = 20;

        int[][] matrix = solution.generateMatrix(n);
        
        System.out.println("matrix: ");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}


class Solution
{
    public int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        if(n == 0) { return matrix; }

        int top = 0; int bottom = n-1;
        int left = 0; int right = n-1;
        
        // dir = 1 - right, 2 - down, 3 - left, 4 - up
        int dir = 1;
        int x  = 0;
        int y = 0;
        
        int num_blocks = n*n;
        
        for(int i = 1; i <= num_blocks; i++) 
        {                    
            //System.out.println("left = "+left+", right = "+right+", top = "+top+", bottom = "+bottom);
            //System.out.println("dir = "+dir+", x = "+x+", y = "+y);

            // insert the current number
            matrix[x][y] = i;
            
            // make a move
            if(dir == 1)
            {
                // 1. right
                // try to move right, or else move down
                if(y+1 <= right)
                {
                    y++;
                }
                else
                {
                    top++;
                    dir = 2;
                    x++;
                }
            }
            else if(dir == 2)
            {
                // 2. down
                if(x+1 <= bottom)
                {
                    x++;
                }
                else
                {
                    right--;
                    dir = 3;
                    y--;
                }
            }
            else if(dir == 3)
            {
                // 3. left
                if(y-1 >= left)
                {
                    y--;
                }
                else
                {
                    bottom--;
                    dir = 4;
                    x--;
                }
            }
            else
            {
                // 4. up
                if(x-1 >= top)
                {
                    x--;
                }
                else
                {
                    left++;
                    dir = 1;
                    y++;
                }
            }
        }
        
        return matrix;
    }
}

