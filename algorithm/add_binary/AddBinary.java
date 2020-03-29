import java.io.*;
import java.util.*;


class AddBinary
{
    public static void main(String[] args)
    {
        System.out.println("=== Add Binary ===");
        
        Solution solution = new Solution();
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("a+b = "+solution.addBinary(a, b));
    }
}

class Solution
{
    public String addBinary(String a, String b)
    {
        int size = (a.length() > b.length()) ? a.length() : b.length();
        
        StringBuffer buf_a = (new StringBuffer(a)).reverse();
        StringBuffer buf_b = (new StringBuffer(b)).reverse();
        
        char carry = '0';        
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < size; i++)
        {
            char bit_a = '0';
            char bit_b = '0';
            
            if(i < a.length()) { bit_a = buf_a.charAt(i); }
            if(i < b.length()) { bit_b = buf_b.charAt(i); }
            
            if(bit_a != bit_b)
            {
                char c = (carry == '1')? '0':'1';
                result.insert(0, c);
            }
            else
            {
                result.insert(0, carry);
                if(bit_a == '0') { carry = '0'; }
                else { carry = '1'; }
            }
        }

        if(carry == '1') { result.insert(0, '1'); }

        return result.toString();
    }
}
