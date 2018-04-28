import java.io.*;
import java.util.*;


class GlobalAndLocalInversions
{
    public static void main(String[] args)
    {
        System.out.println("=== Global and Local Inversions ===");
        Solution solution = new Solution();
        int[][] array = {{1,0,2}, {1,2,0}};    
        for (int[] A : array) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("ideal permutation = "+solution.isIdealPermutation(A));
        }
    }
}


class Solution
{
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] - i > 1 || A[i] - i < -1) {
                return false;
            }
        }
        return true;
    }
}
