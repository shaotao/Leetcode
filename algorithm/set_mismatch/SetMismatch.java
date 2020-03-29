import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class SetMismatch
{
    public static void main(String[] args)
    {
	System.out.println("=== Set Mismatch ===");
	Solution solution = new Solution();
        int[] nums = {1,2,2,4};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("error nums = "+Arrays.toString(solution.findErrorNums(nums)));
    }
}


class Solution
{
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        int size = nums.length;
        int[] array = new int[size];

        /*
        Arrays.stream(nums).forEach(n -> array[n-1]++);
        IntStream.rangeClosed(0, size-1)
            .filter(i -> array[i] != 1)
            .forEach(i -> { ret[array[i]==0?1:0] = i+1;});
        */
        for(int num:nums) { array[num-1]++; }
        for(int i = 0; i < size; i++) {
            if (array[i] == 0) { ret[1] = i+1; }
            else if (array[i] == 2) { ret[0] = i+1; }
        }
        return ret;
    }
}
