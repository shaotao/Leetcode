import java.io.*;
import java.util.*;


class NextPermutation
{
    public static void main(String[] args)
    {
        System.out.println("=== Next Permutation ===");
        
        int[] num = {1, 2, 4, 3};
        //int[] num = {};
        //int[] num = {4, 3, 2, 1};
        Solution solution = new Solution();
        
        System.out.print("num: ");
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+" ");
        }
        System.out.println();

        solution.nextPermutation(num);
        
        System.out.print("next permutation: ");
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}


class Solution
{
    public void nextPermutation(int[] num)
    {
        if(num.length < 2) { return; }

        int target_i = -1;
        for(int i = num.length-2; i >= 0; i--)
        {
            int target_j = -1;
            for(int j = i+1; j < num.length; j++)
            {
                if(num[j] > num[i] && 
                   ( target_j < 0 || num[target_j] > num[j]))
                {
                    target_i = i;
                    target_j = j;
                }
            }

            if(target_j >= 0)
            {
                // swap target_i and target_j
                int temp = num[target_i];
                num[target_i] = num[target_j];
                num[target_j] = temp;
                break; 
            }
        }

        // sort element in ascending order
        // from num[target_i+1 : num.length-1]
        for(int i = target_i+1; i < num.length; i++)
        {
            for(int j = i+1; j < num.length; j++)
            {
                if(num[i] > num[j])
                {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }
}
