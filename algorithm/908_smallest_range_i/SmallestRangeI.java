import java.io.*;
import java.util.*;


class SmallestRangeI
{
    public static void main(String[] args)
    {
        System.out.println("=== Smallest Range I ===");
        Solution solution = new Solution();
        int[][] array_A = {{1}, {0,10}, {1,3,6}};
        int[] array_K = {0, 2, 3};
        for (int i = 0; i < array_K.length; i++) {
            System.out.println("A = "+Arrays.toString(array_A[i]));
            System.out.println("A = "+array_K[i]);
            System.out.println("smallest range = "+solution.smallestRangeI(array_A[i], array_K[i]));
        }
    }
}


class Solution
{
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];

        for (int i : A) {
            min = (min > i)?i:min;
            max = (max < i)?i:max;
        }

        return ((max-min)>2*K)?(max-min-2*K):0;
    }
}
