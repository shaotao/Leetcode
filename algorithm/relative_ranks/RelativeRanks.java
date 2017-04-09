import java.io.*;
import java.util.*;


class RelativeRanks
{
    public static void main(String[] args)
    {
	System.out.println("=== Relative Ranks ===");
	Solution solution = new Solution();

        int[] nums = {5,4,3,2,1};
        String[] ret = solution.findRelativeRanks(nums);
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("ranks = "+Arrays.toString(ret));
    }
}


class Solution
{
    public String[] findRelativeRanks(int[] nums) {
        String[] ret = null;

        if(nums == null || nums.length == 0) { return new String[0]; }
        
        int[] ranks = Arrays.copyOf(nums, nums.length);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // sort nums
        for(int i = 0; i < ranks.length; i++) {
            for(int j = i+1; j < ranks.length; j++) {
                if(ranks[i] < ranks[j]) {
                    int tmp = ranks[i];
                    ranks[i] = ranks[j];
                    ranks[j] = tmp;
                }
            }
        }
        for(int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], i+1);
        }

        ret = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int rank = map.get(val);
            String str = null;
            if(rank == 1) { str = "Gold Medal"; }
            else if(rank == 2) { str = "Silver Medal"; }
            else if(rank == 3) { str = "Bronze Medal"; }
            else { str = Integer.toString(rank); }
            ret[i] = str;
        }
        
        return ret;
    }
}
