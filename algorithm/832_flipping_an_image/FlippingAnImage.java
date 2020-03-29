import java.io.*;
import java.util.*;


class FlippingAnImage
{
    public static void main(String[] args)
    {
        System.out.println("=== Flipping an Image ===");
        Solution solution = new Solution();
        int[][][] input = {{{1,1,0},{1,0,1},{0,0,0}},
                           {{1,1,0,0}, {1,0,0,1},{0,1,1,1},{1,0,1,0}}};
        for (int[][] A : input) {
            System.out.println("A = "+Arrays.deepToString(A));
            System.out.println("flip = "+Arrays.deepToString(solution.flipAndInvertImage(A)));
        }
    }
}


class Solution
{
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] row: A) {
            for (int i = 0; i < row.length; i++) {
                row[i] ^= 1;
            }
            for (int i = 0; i < row.length/2; i++) {
                int tmp = row[i];
                row[i] = row[row.length-1-i];
                row[row.length-1-i] = tmp;
            }
        }

        return A;
    }
}
