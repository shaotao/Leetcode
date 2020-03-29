import java.io.*;
import java.util.*;


class BestTimeToBuyAndSellStock2
{
    public static void main(String[] args)
    {
        System.out.println("=== Best Time to Buy and Sell Stock II ===");
        Solution solution = new Solution();
        
        //int[] prices = {4,3,2,1,5,6,4,3,2,3,4,6,4,3,1,2,3};
        int[] prices = {2,2,5};
        
        int max_profit = solution.maxProfit(prices);
        
        System.out.print("prices: ");
        for(int i = 0; i < prices.length; i++)
        {
            System.out.print(prices[i]+" ");
        }
        System.out.println();

        System.out.println("max profit = "+max_profit);
    }
}


class Solution
{
    public int maxProfit(int[] prices)
    {
	if(prices.length < 2) { return 0; }

	// combine days with equal price
	int[] my_prices = new int[prices.length];
	int prev_price = -1;
	int count = 0;
	for(int i = 0; i < prices.length; i++)
	{
	    if(i == 0 || prev_price != prices[i])
	    {
		prev_price = prices[i];
		my_prices[count] = prices[i];
		count++;
	    }
	}

        int profit = 0;
        int prev = -1;
        
        for(int i = 0; i < count; i++)
        {
            // find the buy point
            if( prev == -1 && (i == 0 || my_prices[i-1] > my_prices[i]) && (i != my_prices.length-1) && (my_prices[i] < my_prices[i+1] ) )
            {
                // buy here
                prev = my_prices[i];
            }

            // find the sell point
            if( (i != 0) && (my_prices[i-1] < my_prices[i]) && (i == my_prices.length-1 || my_prices[i] > my_prices[i+1]))
            {
                if(prev == -1)
                {
                    System.out.println("error: selling before buying!");
                    return 0;
                }

                profit += my_prices[i] - prev;
                prev = -1;
            }
        }

        return profit;
    }
}
