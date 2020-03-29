import java.io.*;
import java.util.*;


class WiggleSort2
{
    public static void main(String[] args)
    {
        System.out.println("=== Wiggle Sort II ===");
        Solution solution = new Solution();

        int[][] array_of_nums = {{1, 5, 1, 1, 6, 4},
                                 {1, 3, 2, 2, 3, 1},
                                 {4, 5, 5, 6}};

        for(int[] nums: array_of_nums) {
            System.out.println("nums: "+Arrays.toString(nums));
            solution.wiggleSort(nums);
            System.out.println("after wiggle sort: "+Arrays.toString(nums));
        }
    }
}

class Solution
{
    public void wiggleSort(int[] nums)
    {
        if(nums == null) { return; }
        int size = nums.length;
        if(size == 0) { return; }
        
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // now nums is sorted, interleave 0~n/2, n/2+1 ~ n-1
        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1 = (size-1)/2;
        int p2 = size-1;
        while(p1 >= 0 || p2 >= (size-1)/2+1) {
            if(p1 >= 0) {
                list.add(nums[p1]);
                p1--;
            }

            if(p2 >= (size-1)/2 + 1) {
                list.add(nums[p2]);
                p2--;
            }
        }

        for(int i = 0; i < size; i++) {
            nums[i] = list.get(i);
        }
    }
}
