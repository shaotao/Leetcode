import java.io.*;
import java.util.*;


class Triangle
{
    public static void main(String[] args)
    {
	System.out.println("=== Triangle ===");
	Solution solution = new Solution();
	
	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> row1 = new ArrayList<Integer>();
	ArrayList<Integer> row2 = new ArrayList<Integer>();
	ArrayList<Integer> row3 = new ArrayList<Integer>();
	ArrayList<Integer> row4 = new ArrayList<Integer>();

	row1.add(2);
	row2.add(3); row2.add(4);
	row3.add(6); row3.add(5); row3.add(7);
	row4.add(4); row4.add(1); row4.add(8); row4.add(3);

	triangle.add(row1);
	triangle.add(row2);
	triangle.add(row3);
	triangle.add(row4);
	
	int result = solution.minimumTotal(triangle);
	System.out.println("minimum total = "+result);
    }
}


class Solution
{
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
    {
	int result = 0;
	ArrayList<Integer> array = new ArrayList<Integer>();
	
	// compute the sum
	for(int idx_row = 0; idx_row < triangle.size(); idx_row++)
	{
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    
	    ArrayList<Integer> list = triangle.get(idx_row);
	    
	    for(int i = 0; i < list.size(); i++)
	    {
		if(i == 0)
		{
		    int val = 0;
		    if(array.size() > 0) { val = array.get(0); }
		    temp.add(list.get(i) + val);
		}
		else if(i == list.size()-1)
		{
		    int val = 0;
		    if(array.size() > 0) { val = array.get(array.size()-1); }
		    temp.add(list.get(i) + val);		    
		}
		else
		{
		    // check array[i-1] and array[i]
		    // take the minimum
		    int val = array.get(i-1) < array.get(i) ? array.get(i-1):array.get(i);
		    temp.add(list.get(i) + val);
		}
	    }

	    array = temp;
	}

	// get the minimum sum
	for(int i = 0; i < array.size(); i++)
	{
	    if(i == 0 || result > array.get(i)) 
	    { 
		result = array.get(i); 
	    }
	}
	return result;
    }
}
