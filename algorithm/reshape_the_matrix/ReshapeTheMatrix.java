import java.io.*;
import java.util.*;


class ReshapeTheMatrix
{
    public static void main(String[] args)
    {
	System.out.println("=== Reshape The Matrix ===");
	Solution solution = new Solution();

        int[][] nums = {{1,2},{3,4}};

        //int r = 1; int c = 4;
        int r = 4; int c = 1;
        int[][] ret = solution.matrixReshape(nums, r, c);

        System.out.println("ret = "+Arrays.deepToString(ret));
    }
}


class Solution
{
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length==0 || nums[0].length==0) {
            return nums;
        }

        int rows = nums.length;
        int cols = nums[0].length;

        if(rows*cols != r*c) { return nums; }

        int[][] ret = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int idx = i*c + j;
                ret[i][j] = nums[idx/cols][idx%cols];
            }
        }

        return ret;
    }
}
