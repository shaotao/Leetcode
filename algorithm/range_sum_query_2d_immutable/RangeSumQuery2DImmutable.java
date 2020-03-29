import java.io.*;
import java.util.*;


class RangeSumQuery2DImmutable
{
    public static void main(String[] args)
    {
        System.out.println("=== Range Sum Query 2D - Immutable ===");

        int[][] matrix = {{3,0,1,4,2},
                          {5,6,3,2,1},
                          {1,2,0,1,5},
                          {4,1,0,1,7},
                          {1,0,3,0,5}};

        print_matrix(matrix, "input matrix");

        NumMatrix nm = new NumMatrix(matrix);
        
        System.out.println("sumRegion(2, 1, 4, 3) -> "+nm.sumRegion(2, 1, 4, 3));
        System.out.println("sumRegion(1, 1, 2, 2) -> "+nm.sumRegion(1, 1, 2, 2));
        System.out.println("sumRegion(1, 2, 2, 4) -> "+nm.sumRegion(1, 2, 2, 4));
    }

    public static void print_matrix(int[][] matrix, String title) {
        if(matrix == null) { return; }

        int num_rows = matrix.length;
        if(num_rows == 0) { return; }
        int num_cols = matrix[0].length;

        System.out.println(">>> "+title);
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("<<< "+title);
    }
}

class NumMatrix
{
    int[][] sum_matrix = null; 
    public NumMatrix(int[][] matrix)
    {
        if(matrix.length != 0 && matrix[0].length != 0) {
            sum_matrix = new int[matrix.length][matrix[0].length];
            
            int num_rows = sum_matrix.length;
            int num_cols = sum_matrix[0].length;
            
            for(int i = 0; i < num_rows; i++) {
                int row_sum = 0;
                for(int j = 0; j < num_cols; j++) {
                    row_sum += matrix[i][j];
                    
                    sum_matrix[i][j] = ((i>0)?sum_matrix[i-1][j]:0) + row_sum;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int ret = 0;
        if(sum_matrix == null) { return 0; }

        ret = sum_matrix[row2][col2] -
            ((col1>0)?sum_matrix[row2][col1-1]:0) -
            ((row1>0)?sum_matrix[row1-1][col2]:0) +
            ((row1>0 && col1>0)?sum_matrix[row1-1][col1-1]:0);
        
        return ret;
    }
}
