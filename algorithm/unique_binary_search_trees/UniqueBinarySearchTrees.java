import java.io.*;
import java.util.*;


class UniqueBinarySearchTrees
{
    public static void main(String[] args)
    {
	System.out.println("=== Unique Binary Search Trees ===");
	Solution solution = new Solution();
	
	int n = 3;
	System.out.println("num of trees = "+solution.numTrees(n));
    }
}

class Solution
{
    public Solution()
    {
    }

    public int numTrees(int n)
    {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(1);
	list.add(2);

	if(n <= 2) { return list.get(n); }

	for(int top = 3; top <= n; top++)
	{
	    int sum = 0;
	    for(int i = 1; i <= top; i++)
	    {
		sum += list.get(i-1)*list.get(top-i);
	    }
	    
	    list.add(sum);
	}
	
	return list.get(n);
    }
}

