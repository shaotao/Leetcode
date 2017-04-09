import java.io.*;
import java.util.*;


class MaxArea
{
    public static void main(String[] args)
    {
	System.out.println("=== Container with Most Water ===");
	
	Solution solution = new Solution();
	
	int[] height = {1,4,3,6,7,3,2,8,4,5,9,8,10,2,1,3,4,5};
	
	int result = solution.maxArea(height);
	
	System.out.println("max area = "+result);
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
    public int maxArea(int[] height)
    {
	int max = 0;

	// get the left list
	ArrayList<Point> left_list = new ArrayList<Point>();
	ArrayList<Point> right_list = new ArrayList<Point>();
	
	int curr_h = 0;
	for(int i = 0; i < height.length; i++)
	{
	    if(curr_h < height[i])
	    {
		Point p = new Point(i, height[i]);
		left_list.add(p);
		curr_h = height[i];
	    }
	}
	
	curr_h = 0;
	for(int i = height.length-1; i >= 0; i--)
	{
	    if(curr_h < height[i])
	    {
		Point p = new Point(i, height[i]);
		right_list.add(p);
		curr_h = height[i];
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
		int h = left.h < right.h ? left.h:right.h;

		int area = (right.x - left.x)*h;
		
		if(area > max) { max = area; }
	    }
	}
	
	return max;
    }
}
