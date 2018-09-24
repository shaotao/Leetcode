import java.io.*;
import java.util.*;


class BitwiseOrsOfSubarrays
{
    public static void main(String[] args)
    {
        System.out.println("=== Bitwise ORs of Subarrays ===");
        Solution solution = new Solution();
        int[][] input = {{0},
                         {1,1,2},
                         {1,2,4}};
        for (int[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("number of bitwise ORs = "+solution.subarrayBitwiseORs(A));
        }
    }
}


class Solution
{
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                set.add(or(A, i, j));
            }
        }
        return set.size();
    }

    private int or(int[] A, int i, int j) {
        int val = A[i];
        for (int k = i+1; k <=j ; k++) {
            val = (val | A[k]);
        }
        return val;
    }
    
    public int subarrayBitwiseORs2(int[] A) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        trace(A, 0, list, set);
        
        return set.size();
    }

    private void trace(int[] A, int idx, List<Integer> list, Set<Integer> set) {
        if (idx < A.length) {
            // put the current node
            list.add(A[idx]);
            trace(A, idx+1, list, set);
            list.remove((int)(list.size()-1));

            // don't put current node
            trace(A, idx+1, list, set);
        } else {
            // if list is not emtpy, compute bitwise OR and put to set
            if (!list.isEmpty()) {
                set.add(bitwiseOR(list));
            }
        }
    }

    private int bitwiseOR(List<Integer> list) {
        System.out.println("list = "+list);
        int val = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            val = (val | list.get(i));
        }
        return val;
    }
}
