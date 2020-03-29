import java.io.*;
import java.util.*;


class GrayCode
{
    public static void main(String[] args)
    {
        System.out.println("=== Gray Code ===");
        Solution solution = new Solution();
        int n = 3;

        ArrayList<Integer> result = solution.grayCode(n);
        
        System.out.println("n = "+n);
        System.out.print("gray code: ");
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
}


class Solution
{
    public ArrayList<Integer> grayCode(int n)
    {        
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(n < 1) { result.add(0); return result; }

        int size = (int) Math.pow(2, n);
        int num[] = new int[size];
        for(int i = 0; i < size; i++)
        {
            num[i] = i;
        }
        
        int start_idx = 2;
        int last_idx = size-1;

        while(start_idx < last_idx)
        {
            int idx = start_idx;
            while(idx < last_idx)
            {
                //System.out.println("swap "+(idx)+" and "+(idx+start_idx-1));
                // reverse num[idx, idx + start_idx -1]
                for(int i = 0; i < start_idx/2; i++)
                {
                    int tmp = num[idx+i];
                    num[idx+i] = num[idx+start_idx-1-i];
                    num[idx+start_idx-1-i] = tmp;
                }

                idx += 2*start_idx;
            }

            start_idx *= 2;
        }

        for(int i = 0; i < size; i++)
        {
            result.add(num[i]);
        }
        
        return result;

    }
}
