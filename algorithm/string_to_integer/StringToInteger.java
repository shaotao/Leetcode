import java.io.*;
import java.util.*;

class StringToInteger
{
    public static void main(String[] args)
    {
        System.out.println("=== StringToInteger ===");
        //String str = "    -12345abc   ";
        //String str = "2147483648";
        //String str = "-1";
        //String str = "    10522545459";
        String str = " -11919730356x";

        Solution solution = new Solution();
        int result = solution.atoi(str);
        
        System.out.println("atoi(\""+str+"\") = "+result);
    }
}


class Solution
{
    public int atoi(String str)
    {
        int max =  2147483647;
        int min = -2147483648;
        
        int sign = 1;
        int result = 0;
        boolean started = false;

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            
            if(started == true) 
            {
                if(ch > '9' || ch < '0')
                {
                    break;
                }
                else
                {
                    int digit = ch - '0';;
                    int prev_result = result;

                    if( (prev_result*10)/10 != prev_result)
                    {
                        return sign==-1?min:max;
                    }


                    result = result*10 + digit;
                }
            }
            else
            {
                if(ch == '+' || ch == '-')
                {
                    sign = (ch == '+' ? 1 : -1);
                    started = true;
                }
                else if(ch == ' ')
                {
                    continue;
                }
                else if(ch >= '0' && ch <= '9')
                {
                    int digit = ch - '0';
                    int prev_result = result;
                    if( (prev_result*10)/10 != prev_result)
                    {
                        return sign==-1?min:max;
                    }


                    started = true;
                }
                else
                {
                    break;
                }
            }
        }
        
        result *= sign;

        if(sign == 1 && result < 0) { return max; }
        else if(sign == -1 && result > 0) { return min; }
        else { return result; }
    }
}

