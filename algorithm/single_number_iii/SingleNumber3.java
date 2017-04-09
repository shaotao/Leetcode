import java.io.*;
import java.util.*;

class SingleNumber3
{
    public static void main(String[] args)
    {
        System.out.println("=== Single Number III ===");
        Solution solution = new Solution();
        int[] nums = {1,2,1,3,2,5};

        int[] ret = solution.singleNumber(nums);

        System.out.print("nums: ");
        for(int num: nums) {
            System.out.print(num+", ");
        }
        System.out.println();

        System.out.print("single numbers: ");
        for(int i: ret) {
            System.out.print(i+",");
        }
        System.out.println();
    }
}

class Solution
{
    public int[] singleNumber(int[] nums) {
        int max_count = 2;
        int[] ret = new int[max_count];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> keys = map.keySet();

        int count = 0;
        for(int key: keys) {
            if(map.get(key) == 1) {
                if(count < max_count) {
                    ret[count] = key;
                    count++;
                }
            }
        }
        return ret;
    }
}
