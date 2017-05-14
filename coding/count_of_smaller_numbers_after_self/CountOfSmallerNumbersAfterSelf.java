import java.io.*;
import java.util.*;


class CountOfSmallerNumbersAfterSelf
{
    public static void main(String[] args)
    {
        System.out.println("=== Count of Smaller Numbers After Self ===");
        Solution solution = new Solution();
        int[] nums = {5, 2, 6, 1};
        List<Integer> list = solution.countSmaller(nums);

        System.out.print("nums: ");
        System.out.println(Arrays.toString(nums));
        System.out.print("smaller: ");
        for (Integer i : list) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
}


class Solution
{
    public List<Integer> countSmaller(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(nums == null) {
            return list;
        }

        int size = nums.length;
        for(int i = 0; i < size; i++) {
            int count = 0;
            for(int j = i+1; j < size; j++) {
                if(nums[j] < nums[i]) { count++; }
            }
            list.add(count);
        }
        
        return list;
    }

    public List<Integer> countSmaller_naive(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(nums == null) {
            return list;
        }

        int size = nums.length;
        for(int i = 0; i < size; i++) {
            int count = 0;
            for(int j = i+1; j < size; j++) {
                if(nums[j] < nums[i]) { count++; }
            }
            list.add(count);
        }
        
        return list;
    }
}
