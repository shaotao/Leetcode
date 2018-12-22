import java.io.*;
import java.util.*;


class ImageSmoother
{
    public static void main(String[] args)
    {
	System.out.println("=== Image Smoother ===");
	Solution solution = new Solution();
        int[][] M = {{1,1,1},
                     {1,0,1},
                     {1,1,1}};
        int[][] ret = solution.imageSmoother(M);
        System.out.println("M = "+Arrays.deepToString(M));
        System.out.println("M = "+Arrays.deepToString(ret));
    }
}


class Solution
{
    public int[][] imageSmoother(int[][] M) {
        int[][] ret = new int[M.length][M[0].length];

        int num_rows = M.length;
        int num_cols = M[0].length;

        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                ret[i][j] = getAvg(M, i, j);
            }
        }

        return ret;
    }

    public int getAvg(int[][] M, int i, int j) {
        int count = 0;
        int sum = 0;
        int numRows = M.length;
        int numCols = M[0].length;
        for(int x = i-1; x <=i+1; x++) {
            if(x < 0 || x >= numRows) { continue; }
            for(int y = j-1; y <= j+1; y++) {
                if(y < 0 || y >= numCols) { continue; }
                count++;
                sum += M[x][y];
            }
        }
        return sum/count;
    }
}
