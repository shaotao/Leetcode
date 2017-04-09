import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

class Zigzag
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();
	
	//String input = "PAYPALISHIRING";
    //int nRows = 3;

    String input = "PAYPALISHIRING";
    int nRows = 2;

	String result = solution.convert(input, nRows);
	String result2 = solution.convert2(input, nRows);
	
	System.out.println("input = "+input);
	System.out.println("result = "+result);
	System.out.println("result2 = "+result2);
    }
}


class Solution 
{
 
    public Solution()
    {
    }

    public String convert2(String s, int nRows)
    {
        StringBuffer sb = new StringBuffer("");
        int str_length = s.length();

        int unit_size = 1;

        if(nRows >= 2)
        {
            unit_size = 2*nRows -2;
        }

        // append the characters row by row
        for(int idx_row = 0; idx_row < nRows; idx_row++)
        {
            for(int i = 0; i >= 0; i++)
            {
                int target_idx = i*unit_size + idx_row;
                if(target_idx >= str_length)
                {
                    break;
                }
                sb.append(s.charAt(target_idx));

                if(idx_row > 0 && idx_row < nRows-1)
                {    
                    target_idx += (nRows-1 - idx_row)*2;
                    if(target_idx >= str_length)
                    {
                        break;
                    }
                    sb.append(s.charAt(target_idx));
                }

            }

        }

        return sb.toString();
    }

    public String convert(String s, int nRows) 
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<StringBuffer> str_list = new ArrayList<StringBuffer>();
        for(int idx = 0; idx < nRows; idx++)
        {
            str_list.add(new StringBuffer(""));
        }
        
        ArrayList<Integer> idx_list = new ArrayList<Integer>();
        for(int idx = 0; idx < nRows; idx++)
        {
            idx_list.add(new Integer(idx));
        }
        
        for(int idx = nRows-2; idx >= 1; idx--)
        {
            idx_list.add(new Integer(idx));
        }

        int num_idx = idx_list.size();
        
        int num_chars = s.length();
        for(int idx_char = 0; idx_char < num_chars; idx_char++)
        {
            int target_str_idx = idx_list.get(idx_char%num_idx);
            
            char new_char = s.charAt(idx_char);
            StringBuffer target_str = str_list.get(target_str_idx);
            target_str.append(new_char);

            //System.out.println("target_str = "+target_str);
        }
        
        StringBuffer result = new StringBuffer("");
        
        for(int idx = 0; idx < nRows; idx++)
        {
            result.append(str_list.get(idx));
        }
        
        return result.toString();
    }
}


