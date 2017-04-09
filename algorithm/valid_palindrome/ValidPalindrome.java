import java.io.*;
import java.util.*;


class ValidPalindrome
{
    public static void main(String[] args)
    {
        System.out.println("=== Valid Palindrome ===");
        String s = "A man, a plan, a canal: Panama";
        
        Solution solution = new Solution();
        boolean ret = solution.isPalindrome(s);
        System.out.println("s = |"+s+"|, isPalindrome = "+ret);
    }
}


class Solution
{
    public boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right)
        {
            // find the next alphanumeric character from left
            while(left < s.length())
            {
                char ch = s.charAt(left);
                
                if((ch >='0' && ch<='9') ||
                   (ch >='a' && ch<='z') ||
                   (ch >='A' && ch <= 'Z'))
                {
                    break;
                }
                else
                {
                    left++;
                }
            }
            
            // find the next alphanumeric char from right
            while(right >= 0)
            {
                char ch = s.charAt(right);
                
                if((ch >='0' && ch<='9') ||
                   (ch >='a' && ch<='z') ||
                   (ch >='A' && ch <= 'Z'))
                {
                    break;
                }
                else
                {
                    right--;
                }
            }
                       
            if(left > right) { break; }
            else 
            {
                char left_ch = s.charAt(left);
                char right_ch = s.charAt(right);

                if( (left_ch >= '0' && left_ch <= '9' && left_ch != right_ch) ||
                    (left_ch >= 'a' && left_ch <= 'z' && left_ch != right_ch && left_ch != (right_ch+32)) ||
                    (left_ch >= 'A' && left_ch <= 'Z' && left_ch != right_ch && left_ch != (right_ch-32)) )
                {
                    return false;
                }
                
                left++;
                right--;
            }
        }
        
        return true;
    }
}
