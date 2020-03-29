import java.io.*;
import java.util.*;


class PlusOne
{
    public static void main(String[] args)
    {
        System.out.println("=== PlusOne ===");
        
        Solution solution = new Solution();

        int[] digits = {8,9,9,9};
        
        int[] result = solution.plusOne(digits);
    
        PlusOne.print_array(digits);    
        PlusOne.print_array(result);    
    }

    public static void print_array(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
}

class Solution
{
    public Solution()
    {
    }

    public int[] plusOne(int[] digits)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int addition = 1;
        for(int i = digits.length -1 ; i >= 0; i--)
        {
            int num = digits[i] + addition;

            addition = num / 10;
            int digit = num % 10;
            
            list.add(0, digit);
            //System.out.println("num = "+num+", digit = "+digit+", addition = "+addition);
        }
        
        if(addition > 0)
        {
            list.add(0, addition);
        }

        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
