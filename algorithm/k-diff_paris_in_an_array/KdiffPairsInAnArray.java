import java.io.*;
import java.util.*;


class KdiffPairsInAnArray
{
    public static void main(String[] args)
    {
	System.out.println("=== K-diff Pairs in an Array ===");
	Solution solution = new Solution();

        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("k = "+k);
        System.out.println("number of k-diff paris = "+solution.findPairs(nums, k));
    }
}


class Solution
{
    public int findPairs(int[] nums, int k) {
        int ret = 0;

        if(k < 0) { return 0; }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            int val = 1;
            if(map.containsKey(num)) {
                val += 1;
            }
            map.put(num, val);
        }

        for(Integer key : map.keySet()) {
            if(k == 0) {
                if(map.get(key) >= 2) {
                    ret++;
                }
            } else {
                if(map.containsKey(key+k)) {
                    ret++;
                }
            }
        }
        
        return ret;
    }
}
