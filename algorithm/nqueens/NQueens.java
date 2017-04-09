import java.io.*;
import java.util.*;

class NQueens
{
    public static void main(String[] args)
    {
	System.out.println("=== NQueens ===");
    
	Solution solution = new Solution();
	
	int n = 10;
	
	ArrayList<String[]> result = solution.solveNQueens(n);

	System.out.println(n+" queens problem has "+result.size()+" solutions: ");
	for(int i = 0; i < result.size(); i++)
	{
	    System.out.print((i+1)+"): ");
	    for(int j = 0; j < result.get(i).length; j++)
	    {
		System.out.print(result.get(i)[j]+" ");
	    }
	    System.out.println();
	}
    }
}


class Solution
{
    public Solution() {}

    public ArrayList<String[]> solveNQueens(int n)
    {
	ArrayList<String[]> result = new ArrayList<String[]>();

	int[] list = new int[n];
	for(int i = 0; i < n; i++) { list[i] = -1; }
	
	ArrayList<int[]> temp_result = new ArrayList<int[]>();
	
	fill_board(0, n, list, temp_result);

	// convert result to ArrayList<String[]>
	for(int i = 0; i < temp_result.size(); i++)
	{
	    int[] board = temp_result.get(i);

	    String[] array = new String[n];
	    
	    for(int j = 0; j < n; j++)
	    {
		StringBuffer buffer = new StringBuffer();
		
		for(int k = 0; k < n; k++) { buffer.append('.'); }
		buffer.setCharAt(board[j], 'Q');
		
		array[j] = buffer.toString();
	    }
	    
	    result.add(array);
	}

	return result;
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
