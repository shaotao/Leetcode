import java.io.*;
import java.util.*;


class SortArrayByParity
{
    public static void main(String[] args)
    {
        System.out.println("=== Sort Array by Parity ===");
        Solution solution = new Solution();

        int[] A = {3,1,2,4};
        System.out.println("A = "+Arrays.toString(A));
        int[] ret = solution.sortArrayByParity(A);
        System.out.println("ret = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length-1;

        while (i < j) {
            while (i < A.length-1 && A[i]%2 == 0) {
                i++;
            }

            while (j > 0 && A[j]%2 == 1) {
                j--;
            }

            if (i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }

        return A;
    }
}
