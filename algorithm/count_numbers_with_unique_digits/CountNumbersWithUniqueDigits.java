import java.io.*;
import java.util.*;


class CountNumbersWithUniqueDigits
{
    public static void main(String[] args)
    {
	System.out.println("=== Count Numbers with Unique Digits ===");
	Solution solution = new Solution();

        int n = 2;
        int ret = solution.countNumbersWithUniqueDigits(n);
        System.out.println("n = "+n+", result = "+ret);
    }
}


class Solution
{
    public int countNumbersWithUniqueDigits(int n) {
        int ret = 0;

        if(n == 0) { return 1; }
        else {
            for(int k = 1; k <= n; k++) {
                int tmp = 1;
                if(k == 1) { tmp = 10; }
                else {
                    for(int i = 1; i <= k; i++) {
                        int choice = 9;
                        if(i == 1) { choice = 9; }
                        else {
                            choice = (10-(i-1));
                            if(choice < 0) {
                                choice = 0;
                            }
                        }
                        
                        tmp *= choice;
                    }
                }
                
                ret += tmp;
            }
        }
        
        return ret;
    }
}
