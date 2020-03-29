import java.io.*;
import java.util.*;


class FractionToRecurringDecimal
{
    public static void main(String[] args)
    {
        System.out.println("=== Fraction to Recurring Decimal ===");
        Solution solution = new Solution();
        int[] num = {1, 7, 1, 99, 1, 13, 2, 8, 1, 6, 355, 113, 1, 90, 1, 990, -50, 8, 1, 214748364, -1, -2147483648, -2147483648, 1};
        for(int i = 0; i <= num.length-2; i+=2) {
            int a = num[i];
            int b = num[i+1];
            String result = solution.fractionToDecimal(a, b);
            System.out.println(a+"/"+b+" = "+result);
        }
    }
}


class Solution
{
    public String fractionToDecimal(int i_numerator, int i_denominator)
    {
        String result = "";

        long numerator = i_numerator;
        long denominator = i_denominator;
        boolean negative = (numerator*denominator < 0);

        if(numerator < 0) { numerator *= -1; }
        if(denominator < 0) { denominator *= -1; }

        long quotient = numerator/denominator;
        long remainder = numerator - quotient*denominator;

        if(remainder == 0) { return (negative?"-":"")+quotient+""; }

        // list of remainders, used to track the repeating remainders
        ArrayList<Long> list = new ArrayList<Long>();

        // map the remainder to the quotients
        HashMap<Long, String> map = new HashMap<Long, String>();
        int repeat_idx = -1;

        System.out.println("negative = "+negative);

        while(remainder != 0) {
            // check if remainder is already in the map
            if (map.containsKey(remainder)) {
                // we have a repeat, return the result
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i) == remainder) {
                        repeat_idx = i;
                        break;
                    }
                }
                break;
            } else {
                long tmp = remainder;
                list.add(remainder);

                String mapped_result = "";
                int count = 0;
                while(remainder < denominator) {
                    remainder *= 10;
                    count++;
                    if(count > 1) { mapped_result += '0'; }
                }

                mapped_result += remainder / denominator;
                map.put(tmp, mapped_result);

                remainder = remainder % denominator;
            }
        }

        result = quotient + ".";
        String repeat = "";
        for(int i = repeat_idx; i >= 0 && i < list.size(); i++) {
            repeat += map.get(list.get(i));
        }

        if(repeat_idx >= 1 && share_end(repeat, map.get(list.get(repeat_idx-1))) > 0) {
            for(int i = 0; i <= repeat_idx-2; i++) {
                result += map.get(list.get(i));
            }

            String prev = map.get(list.get(repeat_idx-1));
            int len = share_end(repeat, prev);
            //System.out.println("share len = "+len+", repeat = "+repeat);
            //System.out.println("prev = "+prev+", prev_substring = "+prev.substring(prev.length()-len, prev.length()));
            result += prev.substring(0, prev.length() - len);
            result += "("+prev.substring(prev.length()-len, prev.length())+repeat.substring(0, repeat.length()-len)+")";
        } else {
            if(repeat_idx >= 0) {
                for(int i = 0; i < repeat_idx; i++) {
                    result += map.get(list.get(i));
                }
                if(repeat.length() > 0) {
                    result += "("+repeat+")";
                }
            } else {
                for(int i = 0; i < list.size(); i++) {
                    result += map.get(list.get(i));
                }
            }
        }

        if(negative) { result = "-"+result; }

        return result;
    }

    // return the number of last chars shared by a and b
    public int share_end(String a, String b) {
        int len = 0;

        if(a == null || b == null) { return 0; }

        for(int i = 0; i < a.length() && i < b.length(); i++) {
            char last_a = a.charAt(a.length()-1-i);
            char last_b = b.charAt(b.length()-1-i);
            if(last_a == last_b) { len++; }
        }

        return len;
    }
}
