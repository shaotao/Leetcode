import java.io.*;
import java.util.*;


class Base7
{
    public static void main(String[] args)
    {
	System.out.println("=== Base 7 ===");
	Solution solution = new Solution();

        int[] nums = {0, 100, -7};

        for(int num : nums) {
            System.out.println(String.format("base7(%d)=\"%s\"", num, solution.convertToBase7(num)));
        }
    }
}


class Solution
{
    public String convertToBase7(int num) {
        StringBuffer ret = new StringBuffer();
        boolean positive = (num>=0);
        if(num < 0) { num *= -1; }

        while(num >= 7) {
            ret.insert(0, (num%7));
            num = num/7;
        }

        if(num > 0 || ret.length()==0) { ret.insert(0, num); }
        
        if(!positive) { ret.insert(0, "-"); }
        
        return ret.toString();
    }
}
