import java.io.*;
import java.util.*;


class ExcelSheetColumnNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Excel Sheet Column Number ===");
        Solution solution = new Solution();
        String[] input = {"A", "B", "C", "Z", "AA", "AB"};
        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i]+" -> "+solution.titleToNumber(input[i]));
        }
    }
}


class Solution
{
    public int titleToNumber(String s)
    {
        int length = s.length();
        int num = 0;
        char ch;
        for(int i = length-1; i >= 0; i--) {
            ch = s.charAt(i);
            num += (ch-64)*Math.pow(26, length-1-i);
        }

        return num;
    }
}
