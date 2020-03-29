import java.io.*;
import java.util.*;


class NumberOfSubarraysWithBoundedMaximum
{
    public static void main(String[] args)
    {
        System.out.println("=== Number of Subarrays with Bounded Maximum ===");
        Solution solution = new Solution();
        int[] A = {2,1,4,3};
        int L = 2;
        int R = 3;

        System.out.println("A = "+Arrays.toString(A));
        System.out.println("L = "+L);
        System.out.println("R = "+R);
        System.out.println("number of subarrays = "+solution.numSubarrayBoundedMax(A, L, R));
    }
}


class Solution
{
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        int ret = 0;
        for (int n : A) {
            count++;
            if (n >= L && n <= R) {
                count++;
            } else if (count > 0) {
                list.add(count);
                count = 0;
            }
        }
        if(count > 0) {
            list.add(count);
        }

        for (int n : list) {
            ret += n*(n-1)/2;
        }
        return ret;
    }
}
