import java.io.*;
import java.util.*;


class ReverseBits
{
    public static void main(String[] args) {
        System.out.println("=== Reverse Bits ===");
        Solution solution = new Solution();
        int n = 43261596;
        int ret = solution.reverseBits(n);
        
        System.out.println("reverse bits of "+n+" = "+ret);
    }
}


class Solution
{
    public int reverseBits(int n) {

        int ret = 0;

        for(int i = 0; i < 32; i++) {
            int bit = n & 1;
            
            ret = (ret << 1) + bit;

            n = n>>1;
        }
        
        return ret;
    }
}
