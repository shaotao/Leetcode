import java.io.*;
import java.util.*;


class NextGreaterElementIII
{
    public static void main(String[] args)
    {
	System.out.println("=== Next Greater Element III ===");
	Solution solution = new Solution();
        int[] nums = {12, 21, 1234, 12222333, 12443322, 1999999999};

        for(int n: nums) {
            System.out.println("n = "+n+", next greater = "+solution.nextGreaterElement(n));
        }
    }
}


class Solution
{
    public int nextGreaterElement(int n) {
        int ret = -1;

        // get lengh of n
        int size = Integer.toString(n).length();
        int[] array = new int[size];
        int[] sorted = new int[size];
        int a = n;
        for(int i = size-1; i >= 0; i--) {
            array[i] = a%10;
            sorted[i] = array[i];
            a = a/10;
        }

        sort(sorted);
        int[] temp = new int[size];

        // permutation of array and find the minimum large element
        ret = findLarger(array, sorted, temp, 0, size);

        return ret;
    }

    public int findLarger(int[] array, int[] sorted, int[] temp, int idx, int size) {
        if(idx >= size) { return -1; }

        // we need to be larger than or equal to base
        int base = array[idx];

        // scan sorted array to pick the item >= base and store in temp
        for(int i = 0; i < size; i++) {
            int taken = sorted[i];
            if(taken < base) {
                continue;
            } else if (taken == base) {
                temp[idx] = taken;
                sorted[i] = -1;
                int ret = findLarger(array, sorted, temp, idx+1, size);
                if(ret > 0) { return ret; }
                sorted[i] = taken;
            } else {
                // append whatever left in sorted.
                temp[idx] = taken;
                sorted[i] = -1;
                // take the rest of sorted in order and insert to temp
                int ptr = idx+1;
                for(int j = 0; j < size; j++) {
                    if(sorted[j] >= 0) {
                        temp[ptr] = sorted[j];
                        ptr++;
                    }
                }

                return toInt(temp);
            }
        }

        return -1;
    }

    public void sort(int[] sorted) {
        if(sorted == null) { return; }
        for(int i = 0; i < sorted.length; i++) {
            for(int j = i+1; j < sorted.length; j++) {
                if(sorted[i] > sorted[j]) {
                    int tmp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }
    }
    
    public int toInt(int[] array) {
        if(array == null || array.length == 0) { return -1; }
        long ret = 0;
        for(int i = 0; i < array.length; i++) {
            ret = ret*10 + array[i];
        }

        if(ret > Math.pow(2, 31)) { return -1; }
        
        return (int)(ret);
    }
}
