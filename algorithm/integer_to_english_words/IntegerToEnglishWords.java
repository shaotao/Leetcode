import java.io.*;
import java.util.*;


class IntegerToEnglishWords
{
    public static void main(String[] args)
    {
        System.out.println("=== Integer to English Words ===");
        Solution solution = new Solution();

        int[] nums = {123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 1234567890, 20, 100, 101};

        for(int num: nums) {
            System.out.println("num = "+num+", words = "+solution.numberToWords(num));
        }
    }
}


class Solution
{
    public String numberToWords(int num) {

        if(num == 0) { return "Zero"; }
      
        StringBuffer str = new StringBuffer("");

        boolean lead = true;
        int val = 0;
        // billion
        val = num/1000000000;
        if(val > 0) {
            if(!lead) { str.append(" "); } else { lead = false; }
            str.append(parse(val));
            str.append(" Billion");
        }

        // million
        num = num%1000000000;
        val = num/1000000;
        if(val > 0) {
            if(!lead) { str.append(" "); } else { lead = false; }
            str.append(parse(val));
            str.append(" Million");
        }

        // thousand
        num = num%1000000;
        val = num/1000;
        if(val > 0) {
            if(!lead) { str.append(" "); } else { lead = false; }
            str.append(parse(val));
            str.append(" Thousand");
        }

        // the rest
        num = num%1000;
        if(num > 0) {
            if(!lead) { str.append(" "); } else { lead = false; }
            str.append(parse(num));
        }

        if(str.length() == 0) { str.append("Zero"); }
        return str.toString();
    }

    // val = 0 ~ 999 inclusive
    public String parse(int val) {
        StringBuffer str = new StringBuffer("");
        boolean lead = true;
        if(val >= 100) {
            if(lead) { lead = false; } else { str.append(" "); }
            str.append(digit_map(val/100));
            str.append(" Hundred");
        }

        val = val%100;
        if(val >= 20) {
            // get tens
            if(lead) { lead = false; } else { str.append(" "); }
            str.append(digit_map((val/10)*10));

            // get 0-9 digits
            if(val%10 > 0) {
                if(lead) { lead = false; } else { str.append(" "); }
                str.append(digit_map(val%10));
            }
        } else if (val > 0) {
            if(lead) { lead = false; } else { str.append(" "); }            
            str.append(digit_map(val));
        }

        return str.toString();
    }

    // 0 ~ 9 inclusive
    public String digit_map(int digit) {
        
        if(digit == 0) {
            return "Zero";
        } else if(digit == 1) {
            return "One";
        } else if (digit == 2) {
            return "Two";
        } else if (digit == 3) {
            return "Three";
        } else if (digit == 4) {
            return "Four";
        } else if (digit == 5) {
            return "Five";
        } else if (digit == 6) {
            return "Six";
        } else if (digit == 7) {
            return "Seven";
        } else if (digit == 8) {
            return "Eight";
        } else if (digit == 9) {
            return "Nine";
        } else if (digit == 10) {
            return "Ten";
        } else if (digit == 11) {
            return "Eleven";
        } else if (digit == 12) {
            return "Twelve";
        } else if (digit == 13) {
            return "Thirteen";
        } else if (digit == 14) {
            return "Fourteen";
        } else if (digit == 15) {
            return "Fifteen";
        } else if (digit == 16) {
            return "Sixteen";
        } else if (digit == 17) {
            return "Seventeen";
        } else if (digit == 18) {
            return "Eighteen";
        } else if (digit == 19) {
            return "Nineteen";
        } else if (digit == 20) {
            return "Twenty";
        } else if (digit == 30) {
            return "Thirty";
        } else if (digit == 40) {
            return "Forty";
        } else if (digit == 50) {
            return "Fifty";
        } else if (digit == 60) {
            return "Sixty";
        } else if (digit == 70) {
            return "Seventy";
        } else if (digit == 80) {
            return "Eighty";
        } else if (digit == 90) {
            return "Ninety";
        }

        return null;
    }
}
