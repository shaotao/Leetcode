import java.io.*;
import java.util.*;


class HappyNumber
{
    public static void main(String[] args) {
        System.out.println("=== Happy Number ===");
        Solution solution = new Solution();
        int[] list = {19, 2, 1};

        for(int input: list) {
            boolean ret = solution.isHappy(input);
            System.out.println("isHappy("+input+") = "+ret);
        }
    }
}

class Solution
{
    public boolean isHappy(int n) {
        boolean ret = false;
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(n == 1) { return true; }
        else if(n == 0) { return false; }
        
        int val = n;
        while (val != 1) {
            if (list.contains(val)) {
                break;
            }
            list.add(val);

            // get the sum of square of each digit
            int num = val;
            val = 0;
            while (num > 0) {
                int digit = num%10;
                num = num/10;
                val += digit*digit;
            }
            
            if (val == 1) {
                ret = true;
                break;
            }
        }
        
        return ret;
    }
}
