import java.io.*;
import java.util.*;


class ToeplitzMatrix
{
    public static void main(String[] args)
    {
        System.out.println("=== Toeplitz Matrix ===");
        Solution solution = new Solution();
        int[][][] matrixes = {{{1,2,3,4}, {5,1,2,3}, {9,5,1,2}},
                              {{1,2}, {2,2}},
                              {{36,59,71,15,26,82,87},{56,36,59,71,15,26,82},{15,0,36,59,71,15,26}}
        };

        for (int[][] matrix : matrixes) {
            System.out.println("matrix = "+Arrays.deepToString(matrix));
            System.out.println("is Toeplitz Matrix: "+solution.isToeplitzMatrix(matrix));
        }
    }
}


class Solution
{
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null) { return false; }
        int num_rows = matrix.length;
        if(matrix[0] == null) { return false; }
        int num_cols = matrix[0].length;

        // scan to down right, from first row
        for(int i = 0; i < num_cols; i++) {
            int val = matrix[0][i];
            int x = 0;
            int y = i;
            while(x < num_rows && y < num_cols) {
                if(matrix[x][y] == val) {
                    x++; y++;
                } else {
                    return false;
                }
            }
        }
        
        // travel first column down, scan down right
        for(int i = 0; i < num_rows; i++) {
            int val = matrix[i][0];
            int x = i;
            int y = 0;
            while(x < num_rows && y < num_cols) {
                if(matrix[x][y] == val) {
                    x++; y++;
                } else {
                    return false;
                }
            }
        }
        
        return true;        
    }
}
