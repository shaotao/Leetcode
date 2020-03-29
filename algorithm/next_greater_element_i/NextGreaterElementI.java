import java.io.*;
import java.util.*;


class NextGreaterElementI
{
    public static void main(String[] args)
    {
	System.out.println("=== Next Greater Element I ===");
	Solution solution = new Solution();

        int[][] list_nums1 = {{4,1,2},
                              {2,4}};
        int[][] list_nums2 = {{1,3,4,2},
                              {1,2,3,4}};

        for(int i = 0; i < list_nums1.length; i++) {
            int[] nums1 = list_nums1[i];
            int[] nums2 = list_nums2[i];

            int[] ret = solution.nextGreaterElement(nums1, nums2);
            System.out.println("nums1 = "+Arrays.toString(nums1));
            System.out.println("nums2 = "+Arrays.toString(nums2));
            System.out.println("Output = "+Arrays.toString(ret));
        }
    }
}


class Solution
{
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] ret = new int[findNums.length];
        
        for(int i=0; i < findNums.length; i++) {
            boolean found = false;
            int idx = map.get(findNums[i]);
            for(int j = idx+1; j<nums.length; j++) {
                if(nums[j] > findNums[i]) {
                    ret[i] = nums[j];
                    found = true;
                    break;
                }
            }
            if(!found) { ret[i] = -1; }
        }

        return ret;
    }
}
