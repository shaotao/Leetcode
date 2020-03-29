import java.io.*;
import java.util.*;


class FairCandySwap
{
    public static void main(String[] args)
    {
        System.out.println("=== Fair Candy Swap ===");
        Solution solution = new Solution();
        int[][] array_A = new int[][]{{1,1}, {1,2}, {2}, {1,2,5}};
        int[][] array_B = new int[][]{{2,2}, {2,3}, {1,3}, {2,4}};
        for (int i = 0; i < array_A.length; i++) {
            System.out.println("A = "+Arrays.toString(array_A[i]));
            System.out.println("B = "+Arrays.toString(array_B[i]));
            System.out.println("Swap = "+Arrays.toString(solution.fairCandySwap(array_A[i], array_B[i])));
        }
    }
}


class Solution
{
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];
        int sumA = 0;
        int sumB = 0;
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        
        for (int i : A) {
            sumA += i;
            setA.add(i);
        }
        for (int i : B) {
            sumB += i;
            setB.add(i);
        }
        
        int diff = (sumA - sumB)/2;
        boolean found = false;
        for (int a : setA) {
            if (setB.contains(a-diff)) {
                ret[0] = a;
                ret[1] = a-diff;
                break;
            }
        }
        
        return ret;
    }
}
