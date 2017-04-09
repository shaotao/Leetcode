import java.io.*;
import java.util.*;


class FindMinimumInRotatedSortedArray2
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Minimum in Rotated Sorted Array II ===");
        Solution solution = new Solution();
        int[][] nums = {{2,2,2,2,2,4,4,4,5,5,5,5,5,5,5,6,7,7,7,7,0,0,0,0,0,0,1,2,2,2,2,2},
                        {2, 0, 1, 1, 1},
                        {2, 2, 0, 1, 1, 2},
                        {3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3},
                        {1, 1, 1}};

        for (int[] num: nums) {
            int result = solution.findMin(num);
            print_array(num);
            System.out.println("min = "+result);
        }
    }

    public static void print_array(int[] num)
    {
        if(num == null) { return; }
        int size = num.length;
        
        System.out.print("int[] num =");
        for(int i = 0; i < size; i++)
        {
            System.out.print(" "+num[i]);
        }
        System.out.println();
    }
}

class Solution
{
    // iterate all the 11 cases that left, middle, right can be
    public int findMin(int[] num)
    {
        int result = 0;
        
        if(num == null || num.length == 0) { 
            System.out.println("findMin() error: invalid num = "+num);
            return 0; 
        }

        int left = 0;
        int right = num.length - 1;
        
        while(right >= left) {

            if(right - left <= 1) {
                return (num[left] < num[right])? num[left]:num[right];
            }
            
            int middle = (left + right)/2;
            
            if( (num[left] < num[middle] && num[middle] > num[right] && num[left] >= num[right]) ||
                (num[left] == num[middle] && num[left] > num[right]) || 
                (num[left] > num[middle] && num[middle] > num[right]) ) {
                left = middle;
            } else if (num[left] == num[middle] && num[middle] == num[right]) {
                // search left and right from middle to find the low point or high point
                int probe_left = middle;
                int probe_right = middle;
                boolean split = false;
                while(probe_left > left || probe_right < right) {
                    if(probe_left > left) { probe_left--; }
                    if(probe_right < right) { probe_right++; }
                    
                    if(num[probe_left] > num[middle]) { left = middle; split = true; break; }
                    else if(num[probe_left] < num[middle]) { right = middle; split = true; break; }
                    
                    if(num[probe_right] > num[middle]) { right = middle; split = true; break; }
                    else if(num[probe_right] < num[middle]) { left = middle; split = true; break; }
                }

                // if we get here, all numbers are equal in this range,
                if(split == false) { return num[middle]; }
            } else {
                right = middle;
            }
        }
        

        return result;
    }
}
