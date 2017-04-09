import java.io.*;
import java.util.*;


class DiagonalTraverse
{
    public static void main(String[] args)
    {
	System.out.println("=== Diagnoal Traverse ===");
	Solution solution = new Solution();

        int[][] matrix = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int[] ret = solution.findDiagonalOrder(matrix);
        System.out.println("matrix = "+Arrays.deepToString(matrix));
        System.out.println("diagonal traverse = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null) { return null; }
        else if(matrix.length == 0) { return new int[0]; }
        else if(matrix[0].length == 0) { return matrix[0]; }
        
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        int[] ret = new int[num_rows*num_cols];

        ret[0] = matrix[0][0];
        int dir = 0;
        int i = 0; int j = 0;
        int count = 0;
        while(i != (num_rows-1) || j !=(num_cols-1)) {
            if(dir == 0) {
                // dir = 0; dir-1(up-right, i--, j++)
                if(i == 0 && j < (num_cols-1)) {
                    j++; dir = 1;
                } else if (i < (num_rows-1) && j == (num_cols-1)) {
                    i++; dir = 1;
                } else {
                    i--; j++;
                }
            } else {
                // dir = 1; dir-2(down-left, i++, j--)
                if(i < (num_rows-1) && j == 0) {
                    i++; dir = 0;
                } else if (i == (num_rows-1) && j < (num_cols-1)) {
                    j++; dir = 0;
                } else {
                    i++; j--;
                }
            }

            count++;
            ret[count] = matrix[i][j];
        }

        return ret;
    }
}
