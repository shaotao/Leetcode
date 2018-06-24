import java.io.*;
import java.util.*;


class ArithmeticSlices
{
    public static void main(String[] args)
    {
        System.out.println("=== Arithmetic Slices ===");
        Solution solution = new Solution();
        int[][] input = {{1,3,5,7,9}, {7,7,7,7}, {3,-1,-5,-9}, {1,2,3,4}};
        for (int[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("# of arithmetic slices = "+solution.numberOfArithmeticSlices(A));
        }
    }
}


class Solution
{
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int sum = 0;
        int len = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i]+A[i-2] == 2*A[i-1]) {
                if (len == 0) {
                    len = 3;
                } else {
                    len++;
                }
            } else {
                if (len > 0) {
                    sum += (len-1)*(len-2)/2;
                }
                len = 0;
            }
        }

        if(len > 0) {
            sum += (len-1)*(len-2)/2;
        }

        return sum;
    }
}
