import java.io.*;
import java.util.*;


class PeakIndexInAMountainArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Peak Index in a Mountain Array ===");
        Solution solution = new Solution();
        int[][] input = {{0,1,0}, {0,2,1,0}};
        for (int[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("Peak Index = "+solution.peakIndexInMountainArray(A));
        }
    }
}


class Solution
{
    public int peakIndexInMountainArray(int[] A) {
        if(A == null) { return -1; }
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                return i-1;
            }
        }
        return -1;
    }
}
