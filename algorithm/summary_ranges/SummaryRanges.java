import java.io.*;
import java.util.*;

class SummaryRanges
{
    public static void main(String[] args) {
        System.out.println("=== Summary Range ===");
        Solution solution = new Solution();

        int[] nums = {0,1,2,4,5,7};

        int size = nums.length;
        System.out.print("nums = [");
        for(int i = 0; i < size; i++) {
            int num = nums[i];
            System.out.print(num+((i< (size-1))?",":""));
        }
        System.out.println("]");

        List<String> result = solution.summaryRanges(nums);
        size = result.size();

        System.out.print("summary ranges = [");
        for(int i = 0; i < size; i++) {
            String s = result.get(i);
            System.out.print(s+((i< (size-1))?",":""));
        }
        System.out.println("]");
    }
}

class Solution
{
    public List<String> summaryRanges(int[] nums)
    {
        ArrayList<String> list = new ArrayList<String>();

        if(nums == null) { return list; }

        int size = nums.length;
        int start_idx = -1;
        int end_idx = -1;
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                start_idx = i;
                end_idx = i;
            } else {
                if(nums[i] == nums[end_idx]+1) {
                    end_idx = i;
                } else {
                    if(end_idx > start_idx) {
                        list.add(nums[start_idx]+"->"+nums[end_idx]);
                    } else {
                        list.add(""+nums[start_idx]);
                    }
                    start_idx = i;
                    end_idx = i;
                }
            }
        }

        if(end_idx >= 0) {
            if(end_idx > start_idx) {
                list.add(nums[start_idx]+"->"+nums[end_idx]);
            } else {
                list.add(""+nums[start_idx]);
            }
        }
        
        return list;
    }
}
