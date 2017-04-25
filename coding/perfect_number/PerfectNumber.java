import java.io.*;
import java.util.*;


class PerfectNumber
{
    public static void main(String[] args)
    {
	System.out.println("=== Perfect Number ===");
	Solution solution = new Solution();
        int[] nums = {28,99999996};

        for(int num: nums) {
            System.out.println("number = "+num+", perfect number = "+solution.checkPerfectNumber(num));
        }
    }
}


class Solution
{
    public boolean checkPerfectNumber(int num) {
        if(num <= 0) { return false; }
        if(num == 1) { return true; }

        int sum = 0;
        for(int i = 1; i <= num/2; i++) {
            sum += (num%i == 0)?i:0;
        }
        
        return sum==num;
    }
}
