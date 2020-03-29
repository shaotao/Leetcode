import java.io.*;
import java.util.*;


class MinimumSizeSubarraySum
{
    public static void main(String[] args)
    {
        System.out.println("=== Minimum Size Subarray Sum ===");
        Solution solution = new Solution();
        int[][] nums = { {2,3,1,2,4,3},
                         {5,1,3 ,5,10,7,4,9,2,8}
        };
        int[] s = {7, 15};
        for(int i = 0; i < nums.length; i++) {
            int ret = solution.minSubArrayLen(s[i], nums[i]);
            System.out.println("min len = "+ret);
        }
    }
}

class Solution
{
    public int minSubArrayLen(int s, int[] nums) {
        int size = nums.length;
        int[] count_array = new int[size];
        int[] sum_array = new int[size];

        for(int i = 0; i < size; i++) {
            int prev_sum = (i == 0)?0:sum_array[i-1];
            int prev_count = (i==0)?0:count_array[i-1];
            int sum = prev_sum + nums[i];
            int count = prev_count + 1;
            if(sum >= s) {
                // trim the sum to just >= s
                int temp_sum = sum;
                for(int j = prev_count; j >= 1; j--) {
                    temp_sum -= nums[i-j];
                    if(temp_sum >= s) {
                        sum = temp_sum;
                        count--;
                    } else {
                        break;
                    }
                }    
            }
            
            sum_array[i] = sum;
            count_array[i] = count;
        }
        
        // scan sum_array[i] for entries >= s and get min count_array[i]
        int min_len = 0;
        boolean first = true;
        for(int i = 0; i < size; i++) {
            if(sum_array[i] >= s && (first || min_len > count_array[i])) {
                min_len = count_array[i];
                first = false;
            }
        }

        print_array("sum_array", sum_array);
        print_array("count_array", count_array);

        return min_len;
    }

    public void print_array(String title, int[] nums) {
        System.out.print(title+": ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+", ");
        }
        System.out.println();
    }
}
