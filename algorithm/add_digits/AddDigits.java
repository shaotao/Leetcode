import java.io.*;
import java.util.*;

class AddDigits
{
    public static void main(String[] args)
    {
        System.out.println("=== Add Digits ===");
        Solution solution = new Solution();
        int[] nums = {38, 101};
        for(int num: nums) {
            System.out.println("addDigits("+num+") = "+solution.addDigits(num));
        }
    }
}


class Solution
{
    public int addDigits(int num)
    {
        if(num < 0) {
            System.out.println("Solution.addDigits() error: invalid num = "+num);
            return -1;
        }

        while(num/10 > 0) {
            int sum = 0;
            int tmp = num;
            while(tmp > 0) {
                sum += tmp%10;
                tmp = tmp/10;
            }

            num = sum;
        }

        return num;
    }
}
