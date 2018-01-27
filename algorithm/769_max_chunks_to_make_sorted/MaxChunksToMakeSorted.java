import java.io.*;
import java.util.*;


class MaxChunksToMakeSorted
{
    public static void main(String[] args)
    {
        System.out.println("=== Max Chunks To Make Sorted ===");
        Solution solution = new Solution();
        int[][] input = {{4,3,2,1,0},
                         {1,0,2,3,4}};
        for (int[] arr : input) {
            System.out.println("arr = "+Arrays.toString(arr));
            System.out.println("max chunks = "+solution.maxChunksToSorted(arr));
        }
    }
}


class Solution
{
    public int maxChunksToSorted(int [] arr) {
        int size = arr.length;
        int splits = 0;
        int max = arr[0];
        for (int i = 0; i < size-1; i++) {
            max = (max < arr[i])?arr[i]:max;
            if(max == i) { splits++;}
        }

        return splits+1;
    }
}
