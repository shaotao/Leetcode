import java.io.*;
import java.util.*;


class FindKthLargest
{
    public static void main(String[] args) {
        System.out.println();
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        int ret = solution.findKthLargest(nums, k);
        print_array(nums);
        String tag = "th";
        if(k%10 == 1) {
            tag = "st";
        } else if(k%10 == 2) {
            tag = "nd";
        } else if(k%10 == 3) {
            tag = "rd";
        }
        System.out.println(k+tag+" largest = "+ret);
    }

    public static void print_array(int[] nums) {
        System.out.print("nums: ");
        for(int num: nums) {
            System.out.print(num+",");
        }
        System.out.println();
    }
}


class Solution
{
    public int findKthLargest(int[] nums, int k) {
        int ret = 0;
        ArrayList<Integer> top = new ArrayList<Integer>();

        for(int num: nums) {
            if(top.size() == 0) {
                top.add(num);
            } else {
                int idx = -1;
                for(int i = 0; i < top.size() && i < k; i++) {
                    if(num > top.get(i)) {
                        idx = i;
                        break;
                    }
                }

                if(idx >= 0) {
                    top.add(idx, num);
                } else if(idx == -1 && top.size() < k) {
                    top.add(num);
                }
            }
        }
        
        return top.get(k-1);
    }
}
