import java.io.*;
import java.util.*;


class IntegerToRoman
{
    public static void main(String[] args)
    {
        System.out.println("=== Integer to Roman ===");
        Solution solution = new Solution();
        int num = 3999;
        
        String result = solution.intToRoman(num);
        
        System.out.println("num = "+3999+", roman = "+result);
    }
}


class Solution
{
    public String intToRoman(int num)
    {
        String[] thousand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ind = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        String result = "";
        
        result = thousand[(num/1000)%10]+hundred[(num/100)%10]+ten[(num/10)%10] + ind[num%10];
        
        return result;
    }
}
