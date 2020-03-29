import java.io.*;
import java.util.*;


class MultiplyStrings
{
    public static void main(String[] args)
    {
        System.out.println("=== Multiply Strings ===");
        Solution solution = new Solution();
        
        String num1 = "123456789";
        String num2 = "987654321";
        
        String result = solution.multiply(num1, num2);
        
        System.out.println(num1+" x "+num2+" = "+result);
        
    }
}


class Solution
{
    public String add(String num1, String num2)
    {
        StringBuffer input1 = new StringBuffer(num1);
        StringBuffer input2 = new StringBuffer(num2);
        input1.reverse();
        input2.reverse();


        StringBuffer buf = new StringBuffer("");        
        int carry = 0;
        
        int size = (num1.length() >= num2.length()) ? num1.length() : num2.length();
        for(int i = 0; i < size; i++)
        {
            int a = 0;
            int b = 0;
            
            if(i < num1.length())
            {
                a = input1.charAt(i) - '0';
            }

            if(i < num2.length())
            {
                b = input2.charAt(i) - '0';
            }
            
            //System.out.println("a = "+a+", b = "+b+", carry = "+carry);

            int digit = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            
            buf.insert(0, digit);
        }

        if(carry > 0)
        {
            buf.insert(0, carry);
        }
        

        return buf.toString();
    }
    
    public String times(String num1, char ch)
    {
        StringBuffer buf = new StringBuffer("");

        if(num1.equals("0") || ch == '0') { return "0"; }
        
        int carry = 0;
        int b = ch - '0';
        for(int i = num1.length()-1; i >= 0; i--)
        {
            int a = num1.charAt(i) - '0';
            int digit = (a*b+carry)%10;
            carry = (a*b+carry)/10;
            
            buf.insert(0, digit);            
        }

        if(carry > 0)
        {
            buf.insert(0, carry);
        }

        return buf.toString();
    }

    public String multiply(String num1, String num2)
    {
        String result = "0";
        
        for(int i = num2.length()-1; i >= 0; i--)
        {
            char ch = num2.charAt(i); 
            String temp = times(num1, ch);

            //System.out.println("num1 = "+num1+", ch = "+ch+", product = "+temp);
            
            for(int j = 0; j < (num2.length()-i-1); j++)
            {
                if(temp.equals("0") == false)
                {
                    temp += "0";
                }
            }

            String prev = result;

            result = add(result, temp);
            //System.out.println("result = "+prev+", temp = "+temp+", sum = "+result);
            
        }

        return result;
    }
}
