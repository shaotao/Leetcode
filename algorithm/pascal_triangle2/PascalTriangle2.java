import java.io.*;
import java.util.*;


class PascalTriangle2
{
    public static void main(String[] args)
    {
        System.out.println("=== Pascal Triangle 2 ===");
        
        Solution solution = new Solution();

        for(int n = 0; n <= 10; n++)
        {
            System.out.print(n+"): ");
            ArrayList<Integer> result = solution.getRow(n);
            
            print_result(result);
        }
    }

    public static void print_result(ArrayList<Integer> result)
    {
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i)+", ");
        }
        System.out.println("");
    }
}

class Solution
{
    public ArrayList<Integer> getRow(int rowIndex)
    {
        if(rowIndex == 0)
        { 
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            return list;
        }
        else if(rowIndex == 1)
        { 
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(1);
            return list;
        }

        int[] prev = new int[rowIndex+1];
        int[] curr = new int[rowIndex+1];

        for(int i = 0; i < rowIndex+1; i++)
        {
            prev[i] = 0;
            curr[i] = 0;
        }

        prev[0] = 1;
        curr[0] = curr[1] = 1;


        // index is >= 2, we need to loop
        for(int round = 2; round <= rowIndex; round++)
        {
            int[] tmp = prev;
            prev = curr;
            curr = tmp;

            for(int i = 1; i < rowIndex; i++)
            {
                curr[i] = prev[i] + prev[i-1];
            }
        }

        curr[rowIndex] = 1;

        // convert the curr to array list and return
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < rowIndex+1; i++)
        {
            result.add(curr[i]);
        }

        return result;
    }
}
