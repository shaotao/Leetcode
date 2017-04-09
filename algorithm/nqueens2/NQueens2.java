import java.io.*;
import java.util.*;

class NQueens2
{
    public static void main(String[] args)
    {
	System.out.println("=== NQueens ===");
    
	Solution solution = new Solution();
	
	int n = 12;
	
	int result = solution.totalNQueens(n);

	System.out.println(n+" queens problem has "+result+" solutions.");
    }
}


class Solution
{
    public Solution() {}

    public int totalNQueens(int n)
    {
	ArrayList<int[]> result = new ArrayList<int[]>();

	int[] list = new int[n];
	for(int i = 0; i < n; i++) { list[i] = -1; }	
	
	fill_board(0, n, list, result);

	return result.size();
    }

    // level = 0, 1, 2, ..., n-1
    public void fill_board(int level, int n, int[] list, ArrayList<int[]> result)
    {	
	for(int xn = 0; xn < n; xn++)
	{
	    boolean valid = true;
	    for(int j = 0; j < level; j++)
	    {
		if(xn == list[j] || Math.abs(xn - list[j]) == level -j)
		{
		    valid = false;
		    break;
		}
	    }
	    
	    if(!valid) { continue; }

	    list[level] = xn;
	    if(level >= n-1)
	    {
		// add list to result
		int[] new_list = new int[n];
		for(int i = 0; i < n; i++) { new_list[i] = list[i]; }
		
		result.add(new_list);
	    }
	    else
	    {
		fill_board(level+1, n, list, result);
	    }
	    
	    list[level] = -1;
	}
    }
}
