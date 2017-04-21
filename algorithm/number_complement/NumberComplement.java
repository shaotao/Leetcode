import java.io.*;
import java.util.*;


class NumberComplement
{
    public static void main(String[] args)
    {
	System.out.println("=== Number Complement ===");
	Solution solution = new Solution();
        int[] nums = {1,5};

        for(int num : nums) {
            System.out.println("num = "+num+", complement = "+solution.findComplement(num));
        }
            
    }
}


class Solution
{
    public int findComplement(int num) {
        int tmp = num;
        int map = 0;
        while(tmp > 0) {
            map = (map<<1) +1;
            tmp = (tmp>>1);
        }
        
        return (~num)&map;
    }
}
