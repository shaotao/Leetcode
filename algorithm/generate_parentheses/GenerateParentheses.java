import java.io.*;
import java.util.*;


class GenerateParentheses
{
    public static void main(String[] args)
    {
        System.out.println("=== Generate Parentheses ===");
        Solution solution = new Solution();

        int n = 3;
        ArrayList<String> result = solution.generateParenthesis(n);
        
        System.out.println("n = "+n);        
        System.out.println("num of arrangements = "+result.size());
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println((i+1)+": "+result.get(i)+" ");
        }
        System.out.println();
    }
}


class Solution
{
    public ArrayList<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        
        if(n <= 0) { return result; }
        
        StringBuffer temp = new StringBuffer("(");

        create_pairs(result, temp, n-1, n);
        
        return result;
    }

    public void create_pairs(ArrayList<String> result, StringBuffer temp, int num_open, int num_close)
    {
        // check if num_open and num_close are both 0, if yes, store temp to result
        if(num_open == 0 && num_close == 0)
        {
            result.add(temp.toString());
            return;
        }
        
        // if not, we need to place some more parenthesis to temp
        // it can be either a ( if any, or a ) is we num_close > num_open 
        if(num_open > 0)
        {
            temp.append("(");
            create_pairs(result, temp, num_open-1, num_close);
            temp.deleteCharAt(temp.length()-1);
        }
        
        if(num_close > num_open)
        {
            temp.append(")");
            create_pairs(result, temp, num_open, num_close-1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}