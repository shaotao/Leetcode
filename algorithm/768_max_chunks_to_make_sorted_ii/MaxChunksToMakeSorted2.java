import java.io.*;
import java.util.*;


class MaxChunksToMakeSorted2
{
    public static void main(String[] args)
    {
        System.out.println("=== Max Chunks To Make Sorted II ===");
        Solution solution = new Solution();
        int[][] input = {{5,4,3,2,1},
                         {2,1,3,4,4}};
        for(int[] arr : input) {
            System.out.println("arr = "+Arrays.toString(arr));
            System.out.println("max chunks = "+solution.maxChunksToSorted(arr));
        }
    }
}


class Solution
{
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = arr[0];
        // scan left to right for max
        for (int i = 0; i < size; i++) {
            max = (max >= arr[i])?max:arr[i];
            if (max == sorted[i]) {
                map.put(i, 1);
            }
        }

        int min = arr[size-1];
        // scan right to left for min
        for (int i = size-1; i> 0; i--) {
            min = (min <= arr[i])?min:arr[i];
            if (min == sorted[i]) {
                int count = 1;
                if (map.containsKey(i-1)) {
                    count += map.get(i-1);
                }
                map.put(i-1, count);
            }
        }

        int splits = 1;
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                splits++;
            }
        }
        
        return splits;
    }
}
