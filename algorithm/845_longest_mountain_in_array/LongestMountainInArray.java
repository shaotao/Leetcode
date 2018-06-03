import java.io.*;
import java.util.*;


class LongestMountainInArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Mountain in Array ===");
        Solution solution = new Solution();
        int[][] input = {{2,1,4,7,3,2,5},
                         {2,2,2},
                         {0,2,2},
                         {3,3,1,0,1,0,1,0,2,1}};
        for (int[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("longest mountain = "+solution.longestMountain(A));
        }
    }
}


class Solution
{
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int up = 0;
        int down = 0;
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (down > 0) {
                    max = (max > up+down)?max:(up+down);
                    up = 1;
                    down = 0;
                } else {
                    up++;
                }
            } else if (A[i] == A[i-1]) {
                if (down > 0) {
                    max = (max > up+down)?max:(up+down);
                }
                up = 0;
                down = 0;
            } else {
                if (up > 0) {
                    down++;
                } else {
                    up = 0;
                    down = 0;
                }
            }

            System.out.println("i = "+i+", up = "+up+", down ="+down);
        }

        if (down > 0) {
            max = (max > up+down)?max:(up+down);
        }
        
        return (max>0)?(max+1):max;
    }
}
