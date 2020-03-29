import java.io.*;
import java.util.*;


class UglyNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Ugly Number ==");
        Solution solution = new Solution();
        int[] nums = {1, 6, 8, 14};
        for(int num: nums) {
            System.out.println("isUgly("+num+") = "+solution.isUgly(num));
        }
    }
}

class Solution
{
    public boolean isUgly(int num)
    {
        if(num <= 0) { return false; }
        else if(num == 1) { return true; }

        while(num >= 5 && num%5 == 0) { num = num/5; }
        while(num >= 3 && num%3 == 0) { num = num/3; }
        while(num >= 2 && num%2 == 0) { num = num/2; }

        return (num == 1);
    }
}
