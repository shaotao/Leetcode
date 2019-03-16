import java.io.*;
import java.util.*;


class MaximizeSumOfArrayAfterKNegations
{
    public static void main(String[] args)
    {
        System.out.println("=== Maximize Sum Of Array After K Negations ===");
        Solution solution = new Solution();
        int[][] input = {{4,2,3},
                         {3,-1,0,2},
                         {2,-3,-1,5,-4},
                         {-2,9,9,8,4}};
        int[] Ks = {1, 3, 2, 5};
        for (int i = 0; i < input.length; i++) {
            System.out.println("A = "+Arrays.toString(input[i]));
            System.out.println("K = "+Ks[i]);
            System.out.println("result = "+solution.largestSumAfterKNegations(input[i], Ks[i]));
        }
    }
}


class Solution
{
    public int largestSumAfterKNegations(int[] A, int K) {
        // sort A first,
        Arrays.sort(A);

        int t = K;
        int sum = 0;
        int min = A[0]>=0?A[0]:(-1*A[0]);
        for (int a : A) {
            int abs = a>=0?a:(-1*a);
            min = (min>abs)?abs:min;
            
            if (a < 0 && t > 0) {
                sum += abs;
                t--;
            } else {
                sum += a;
            }
        }

        if (t > 0 && t%2 == 1) {
            sum -= 2*min;
        }

        return sum;
    }
}
