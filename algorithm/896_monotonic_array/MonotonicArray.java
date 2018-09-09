import java.io.*;
import java.util.*;


class MonotonicArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Monotonic Array ===");
        Solution solution = new Solution();

        int[][] input = {{1,2,2,3},
                         {6,5,4,4},
                         {1,3,2},
                         {1,2,4,5},
                         {1,1,1}};
        for (int[] A : input) {
            System.out.println("A="+Arrays.toString(A)+", monotonic="+solution.isMonotonic(A));
        }
    }
}


class Solution
{
    public boolean isMonotonic(int[] A) {

        // up= 1, down=-1, equal=0
        int dir = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (dir == 0) {
                    dir = 1;
                } else if (dir == -1) {
                    return false;
                }
            } else if (A[i] < A[i-1]) {
                if (dir==0) {
                    dir = -1;
                } else if (dir == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
