import java.io.*;
import java.util.*;


public class BestTimeToBuyAndSellStock3
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();
	
	System.out.println("=== Best Time to Buy and Sell Stock 3 ===");
	int[] prices = {5,4,3,2,1,10};
	
	int profit = solution.maxProfit(prices);
	
	System.out.print("prices: ");
	for(Integer price: prices) 
        {
            System.out.print(price+", ");
	}
	System.out.println();

	System.out.println("max profit = "+profit);
    }
}

class Solution
{
    public int maxProfit(int[] prices)
    {
        int max_profit = 0;

        int size = prices.length;
        if(size == 0) { return 0; }

        int[][] matrix = new int[size][size];
	
        // compute the price diference matrix
        for(int i = 0; i < size; i++)
        {
            for(int j = i+1; j < size; j++)
            {
                matrix[i][j] = prices[j] - prices[i];
            }
        }
        
        // max profit to the left inclusive
        int[] left_profit = new int[size];

        // max profit to the right inclusive
        int[] right_profit = new int[size];

        // compute max profit to the left
        int left = 0;
        for(int i = 0; i < size; i++)
        {
            for(int j = i-1; j >= 0; j--)
            {
                if(matrix[j][i] > left)
                {
                    left = matrix[j][i];
                }
            }
            
            left_profit[i] = left;
        }

        // compute the max profit to the right
        int right = 0;
        for(int i = size-1; i >= 0; i--)
        {
            for(int j = i+1; j < size; j++)
            {
                if(matrix[i][j] > right)
                {
                    right = matrix[i][j];
                }
            }
            
            right_profit[i] = right;
        }

        // System.out.println("left_profit: ");
        // for(int value: left_profit)
        // {
        //     System.out.print(value + ", ");
        // }
        // System.out.println();
        
        // System.out.println("right_profit: ");
        // for(int value: right_profit)
        // {
        //     System.out.print(value + ", ");
        // }
        // System.out.println();
        
        // add up the left and right profit
        for(int i = 0; i < size; i++)
        {
            int max_right = right_profit[i];
            int max_left = (i > 0)?left_profit[i-1]:0;

            int profit = max_left + max_right;
            if(max_profit < profit) { max_profit = profit; }
        }
        
        return max_profit;
    }
}
