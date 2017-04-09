import java.io.*;
import java.util.*;


class GasStation
{
    public static void main(String[] args)
    {
	System.out.println("=== Gas Station ===");
	
	Solution solution = new Solution();
	
	//int[] gas = {1, 2, 3, 4, 5};
	//int[] cost = {5, 4, 3, 2, 1};

	int[] gas = {1, 2};
	int[] cost = {2, 1};
	
	int idx = solution.canCompleteCircuit3(gas, cost);
	
	System.out.println("station = "+idx);
    }
}


class Solution
{
    public Solution()
    {
    }

    public int canCompleteCircuit3(int gas[], int cost[])
    {
	int n = gas.length;
	
	int[] node = new int[n];
	int sum = 0;

	ArrayList<Integer> list = new ArrayList<Integer>();

	for(int i = 0; i < n; i++)
	{
	    node[i] = gas[i] - cost[i];
	    sum += node[i];
	    
	    if(node[i] < 0 && node[(i+1)%n] > 0)
	    {
		list.add((i+1)%n);
	    }
	}
	
	if(sum < 0) { return -1; }
	
	for(int i = 0; i < n; i++)
	{
	    if(node[i] < 0 && node[(i+1)%n] > 0)
	    {
		list.add((i+1)%n);
	    }
	}
	if(list.size() == 0) { return 0; }

	// get the list of start idx to test, whose parents
	// have a negative node value

	for(int i = 0; i < list.size(); i++)
	{
	    boolean complete = true;
	    sum = 0;

	    for(int j = 0; j < n; j++)
	    {
		int idx = (list.get(i)+j)%n;
		
		sum += node[idx];
		if(sum < 0) { complete = false; break; }
	    }
	    
	    if(complete == true) { return list.get(i); }	    
	}

	return -1;
    }

    public int canCompleteCircuit2(int gas[], int cost[])
    {
	int n = gas.length;
	
	for(int i = 0; i < n; i++)
	{
	    boolean complete = true;
	    int sum = 0;

	    if(gas[i] < cost[i]) { continue; }

	    for(int j = 0; j < n; j++)
	    {
		int idx = (i+j)%n;
		
		sum += (gas[idx] - cost[idx]);
		if(sum < 0) { complete = false; break; }
	    }
	    
	    if(complete == true) { return i; }
	}

	return -1;       
    }

    public int canCompleteCircuit(int gas[], int cost[])
    {
	int n = gas.length;

	ArrayList<Integer> list = new ArrayList<Integer>();

	int sum = 0;
	for(int i = 0; i < n; i++)
	{
	    int left = gas[i] - cost[i];
	    list.add(left);
	    sum += left;
	}
	if(sum < 0) { return -1; }

	for(int i = 0; i < n; i++)
	{
	    boolean done = true;
	    sum = 0;
	    if(list.get(i) < 0) { done = false; continue; }
	    for(int j = 0; j < n; j++)
	    {
		int idx = (i+j)%n;
		sum += list.get(idx);
		if(sum < 0) { done = false; break; }
	    }
	    
	    if(done == true) { return i; }
	}

	return -1;       
    }

}
