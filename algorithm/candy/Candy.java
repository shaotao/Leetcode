import java.io.*;
import java.util.*;

class Candy
{
    public static void main(String[] args)
    {
        System.out.println("=== Candy ===");
        Solution solution = new Solution();

        int[] a = {5,1,1,1,10,2,1,1,1,3};
        int sum = solution.candy(a);
        
        System.out.println("sum = "+sum);
    }
}

class Solution
{
    public int candy(int[] ratings)
    {
        boolean updated = true;
        
        int[] b = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++)
        {
            b[i] = 1;
        }
        
        while(updated == true)
        {
            updated = false;
            
            // scan from left to right
            for(int i = 1; i < ratings.length; i++)
            {
                if(ratings[i] > ratings[i-1] && b[i] <= b[i-1])
                {
                    b[i] = b[i-1] + 1;
                    updated = true;
                }
            }

            // scan from right to left
            for(int i = ratings.length-2; i >= 0; i--)
            {
                if(ratings[i] > ratings[i+1] && b[i] <= b[i+1])
                {
                    b[i] = b[i+1] + 1;
                    updated = true;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < b.length; i++)
        {
            sum += b[i];
        }

        System.out.print("ratings = ");
        for(int i = 0; i < b.length; i++)
        {
            System.out.print(ratings[i]+", ");
        }
        System.out.println();

        System.out.print("nums = ");
        for(int i = 0; i < b.length; i++)
        {
            System.out.print(b[i]+", ");
        }
        System.out.println();

        return sum;
    }
}
