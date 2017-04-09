import java.io.*;
import java.util.*;


class PowerOfTwo
{
    public static void main(String[] args)
    {
        System.out.println("=== Power of Two ===");
        Solution solution = new Solution();

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for(int num: nums) {
            System.out.println("num = "+num+", power_of_two = "+solution.isPowerOfTwo(num));
        }
    }
}

class Solution
{
    public boolean isPowerOfTwo(int n)
    {
        if(n <= 0) {
            return false;
        }
        
        int i = n;
        while(i > 0) {
            if( (i > 1) && ((i & 1) != 0)) { return false; }
            i = i>>1;
        }

        return true;
    }
}
