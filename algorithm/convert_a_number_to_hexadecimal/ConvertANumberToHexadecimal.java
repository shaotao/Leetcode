import java.io.*;
import java.util.*;


class ConvertANumberToHexadecimal
{
    public static void main(String[] args)
    {
	System.out.println("=== Convert a Number to Hexadecimal ===");
	Solution solution = new Solution();

        int[] nums = {26, -1};
        for(int num : nums) {
            System.out.println("hex("+num+") = "+solution.toHex(num));
        }
    }
}


class Solution
{
    static HashMap<Integer, String> map = new HashMap<Integer, String>();
    static {
        for(int i = 0; i <= 15; i++) {
            if(i< 10) { map.put(i, ""+i); }
            else if (i==10) { map.put(i, "a"); }
            else if (i==11) { map.put(i, "b"); }
            else if (i==12) { map.put(i, "c"); }
            else if (i==13) { map.put(i, "d"); }
            else if (i==14) { map.put(i, "e"); }
            else if (i==15) { map.put(i, "f"); }
        }        
    }
    
    public String toHex(int num)
    {
        String ret = "";

        long n = num;

        if(n < 0) {
            n = (long)(Math.pow(2, 32)) + n;
        }
        
        while(n >= 0) {
            int remain = (int)(n%16);
            ret = map.get(remain)+ret;

            n = n/16;
            if(n == 0) { break; }
        }
        
        return ret;
    }
}
