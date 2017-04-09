import java.io.*;
import java.util.*;


class ExcelSheetColumnTitle
{
    public static void main(String[] args)
    {
        System.out.println("=== Excel Sheet Column Title ===");
        Solution solution = new Solution();
        
        int[] nums = {1,2,3,26,27,28};
        
        for(int num : nums) {
            String result = solution.convertToTitle(num);
            
            System.out.println(num + " -> "+result);
        }
    }
}


class Solution
{
    // assume n is always > 0
    public String convertToTitle(int n)
    {
        int num = n;
        String result = "";

        while(num > 0) {
            int remain = num%26;
            if(remain == 0) { remain = 26; }
            
            char ch = (char)('A' + remain-1);
            result = ch + result;
            
            num = (num - remain)/26;
        }

        return result;
    }
}
