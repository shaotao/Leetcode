import java.io.*;
import java.util.*;


class ShuffleAnArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Shuffle An Array ===");
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
	Solution solution = new Solution(nums);

        System.out.println("array = "+Arrays.toString(nums));
        for(int i = 0; i <100; i++) {
            System.out.println(i+") shuffle = "+Arrays.toString(solution.shuffle()));
            //System.out.println(i+") reset = "+Arrays.toString(solution.reset()));
        }
    }
}


class Solution
{
    int[] input = null;
    Random rand = null;
    
    public Solution(int[] nums) {
        rand = new Random();
        input = new int[nums.length];
        for(int i = 0; i < nums.length; i++) { input[i] = nums[i]; }
    }

    public int[] reset() {
        return input;
    }

    public int[] shuffle() {
        int[] ret = new int[input.length];

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < input.length; i++) {
            list.add(i);
        }

        int count = input.length;
        for(int i = count; i >= 1; i--) {
            int idx = rand.nextInt(i);
            ret[count-i] = input[list.get(idx)];
            list.remove((int)idx);
        }
        
        return ret;
    }
}
