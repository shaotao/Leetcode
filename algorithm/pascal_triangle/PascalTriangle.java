import java.io.*;
import java.util.*;


class PascalTriangle
{
    public static void main(String[] args)
    {
        System.out.println("=== Pascal Triangle ===");
        
        Solution solution = new Solution();
        int n = 5;
        
        ArrayList<ArrayList<Integer>> result = solution.generate(n);
        
        print_result(result);
    }

    public static void print_result(ArrayList<ArrayList<Integer>> result)
    {
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(i+"): ");
            ArrayList<Integer> list = result.get(i);
            for(int j = 0; j < list.size(); j++)
            {
                System.out.print(list.get(j)+", ");
            }
            System.out.println("");
        }
    }
}

class Solution
{
    public ArrayList<ArrayList<Integer>> generate(int numRows)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < numRows; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            result.add(list);
            list.add(1);
            if(i > 0) {list.add(1);}
        }

        for(int i = 0; i < numRows; i++)
        {
            ArrayList<Integer> curr = result.get(i);
            ArrayList<Integer> prev = null;

            if(i > 0) { prev = result.get(i-1); }

            for(int j = 1; j < i; j++)
            {
                curr.add(j, prev.get(j)+prev.get(j-1));
            }
        }

        return result;
    }
}
