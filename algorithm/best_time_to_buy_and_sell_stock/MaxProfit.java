import java.io.*;
import java.util.*;


class MaxProfit
{
    public static void main(String[] args)
    {
	System.out.println("=== Best Time to Buy and Sell Stock ===");
	
	Solution solution = new Solution();
	
	int[] prices = {1,4,3,6,7,3,2,8,4,5,9,8,10,2,1,3,4,5};
	
	int result = solution.maxProfit(prices);
	
	System.out.println("max profit = "+result);
    }
}

class Point
{
    int x = 0;
    int h = 0;
    
    public Point(int x, int h)
    {
	this.x = x;
	this.h = h;
    }
}

class Solution
{
    public int maxProfit(int[] prices)
    {
	int max = 0;

	// get the left list
	ArrayList<Point> left_list = new ArrayList<Point>();
	ArrayList<Point> right_list = new ArrayList<Point>();
	
	int curr_h = -1;
	for(int i = 0; i < prices.length; i++)
	{
	    if(curr_h < 0 || curr_h > prices[i])
	    {
		Point p = new Point(i, prices[i]);
		left_list.add(p);
		curr_h = prices[i];
	    }
	}
	
	curr_h = -1;
	for(int i = prices.length-1; i >= 0; i--)
	{
	    if(curr_h < 0 || curr_h < prices[i])
	    {
		Point p = new Point(i, prices[i]);
		right_list.add(p);
		curr_h = prices[i];
	    }
	}

	for(int i = 0; i < left_list.size(); i++)
	{
	    Point left = left_list.get(i);
	    for(int j = 0; j < right_list.size(); j++)
	    {
		Point right = right_list.get(j);
		if(left.x >= right.x)
		{
		    break;
		}

		int profit = (right.h - left.h);
		
		if(profit > max) { max = profit; }
	    }
	}
	
	return max;
    }
}
