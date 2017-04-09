import java.io.*;
import java.util.*;


class BitwiseANDOfNumbersRange
{
    public static void main(String[] args) {
        System.out.println("=== Bitwise AND of Numbers Range");
        Solution solution = new Solution();
        int[][] input = { {5, 7},
                          {2, 4},
                          {2, 2} };
        for(int i = 0; i < input.length; i++) {
            int m = input[i][0];
            int n = input[i][1];
            int ret = solution.rangeBitwiseAnd(m, n);
            System.out.println("bit-and ["+m+", "+n+"] = "+ret);            
        }
    }
}

class Solution
{
    public int rangeBitwiseAnd(int m, int n) {
        int ret = 0;
        
        int num_bits = 0;
        int temp = m;
        while (temp != 0) {
            num_bits++;
            temp = temp>>1;
        }
        
        for (int i = num_bits; i>= 1; i--) {
            ret = ret << 1;
            int r = m % (2<<(i-1));

            //System.out.println("m = "+m+", (2<<i) = "+(2<<(i-1)));
            //System.out.println("r = "+r);
            if( ((i>1) ? (r < (2<<(i-2))) : (r==0)) ||
                (r + (n-m) > (2<<(i-1)) - 1 )) {
                ret += 0;
            } else {
                ret += 1;
            }

            //System.out.println("ret = "+ret);
        }

        return ret;
    }
}
