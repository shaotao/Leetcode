import java.io.*;
import java.util.*;



class SpiralMatrix
{
    public static void main(String[] args)
    {
        System.out.println("=== Spiral Matrix ===");
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        
        ArrayList<Integer> list = solution.spiralOrder(matrix);
        
        System.out.println("list: ");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}


class Solution
{
    public ArrayList<Integer> spiralOrder(int[][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int num_rows = matrix.length;
        if(num_rows == 0) { return result;}
        int num_cols = matrix[0].length;

        int top = 0; int bottom = num_rows-1;
        int left = 0; int right = num_cols-1;
        
        // dir = 1 - right, 2 - down, 3 - left, 4 - up
        int dir = 1;
        int x  = 0;
        int y = 0;
        
        int num_blocks = num_rows * num_cols;
        
        while(result.size() < num_blocks)
        {                    
            //System.out.println("left = "+left+", right = "+right+", top = "+top+", bottom = "+bottom);
            //System.out.println("dir = "+dir+", x = "+x+", y = "+y);

            // insert the current number
            result.add(matrix[x][y]);
            
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
        
        return result;
    }
}

