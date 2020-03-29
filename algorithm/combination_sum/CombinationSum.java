import java.io.*;
import java.util.*;


class CombinationSum
{
    public static void main(String[] args)
    {
	System.out.println("=== Combination Sum II ===");
	Solution solution = new Solution();
	
        int[] candidates = {2,3,6,7};
        int target = 7;

	ArrayList<ArrayList<Integer>> result = solution.combinationSum(candidates, target);

	System.out.print("candidates: ");
	for(int i = 0; i < candidates.length; i++)
	{
	    System.out.print(candidates[i]+" ");
	}
	System.out.println();
	
	System.out.println("target = "+target);

	System.out.println(result.size()+" results: ");
	for(int i = 0; i < result.size(); i++)
	{
	    System.out.print((i+1)+")");
	    int length = result.get(i).size();
	    
	    for(int j = 0; j < length; j++)
	    {
		System.out.print(result.get(i).get(j)+" ");
	    }
	    System.out.println();
	}
    }
}


class Solution
{
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	// get the map of candidates -> count
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> key_list = new ArrayList<Integer>();
	
	for(int i = 0; i < candidates.length; i++)
	{
	    int key = candidates[i];
            key_list.add(key);
	}

        // sort the key_list
        sort_list(key_list);

	// ok, we have the map and the sorted key_list now,
	// try to find the combinations
        ArrayList<Integer> temp = new ArrayList<Integer>();

        find_combination(result, temp, key_list, target);
        
        filter_duplicates(result);
        	
	return result;
    }

    // remove duplicate lists from result
    public void filter_duplicates(ArrayList<ArrayList<Integer>> result)
    {
        for(int i = 0; i < result.size(); i++)
        {
            for(int j = i+1; j < result.size(); j++)
            {
                ArrayList<Integer> list_i = result.get(i);
                ArrayList<Integer> list_j = result.get(j);
                
                if(list_i.size() != list_j.size()) { continue; }
                
                boolean dup = true;
                for(int idx = 0; idx < list_i.size(); idx++)
                {
                    if(list_i.get(idx) != list_j.get(idx))
                    {
                        dup = false;
                        break;
                    }
                }
                
                if(dup == true)
                {
                    result.remove(j);
                    j--;
                }
            }
        }
    }

    public void print_list(ArrayList<Integer> list)
    {
        if(list == null)
        {
            System.out.println("print_list() error: list is null!");
            return; 
        }

        System.out.print("[");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i));
            if(i != list.size()-1) { System.out.print(" "); }
        }
        System.out.println("]");
    }

    public void sort_list(ArrayList<Integer> list)
    {
        //sort the list
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i+1; j < list.size(); j++)
            {
                int item_i = list.get(i);
                int item_j = list.get(j);
                
                if(item_i > item_j)
                {
                    list.remove(i);
                    list.add(i, item_j);
                    list.remove(j);
                    list.add(j, item_i);
                }
            }
        }        
    }
    
    public void find_combination(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> key_list, int target)
    {        
        if(target < 0) { return; }

        // we have a match
        if(target == 0)
        {
            ArrayList<Integer> new_list = new ArrayList<Integer>(temp);
            sort_list(new_list);
            result.add(new_list);
            return;
        }

        // try each key for this round
        if(key_list.size() > 0)
        {
            int key = key_list.get(0);
            
            key_list.remove(0);
            
            // try from 0 to N of such key
            int count = 0;
            while(true)
            {
                if(key*count > target) { break; }

                for(int i = 0; i < count; i++) 
                {
                    temp.add(key);
                }

                find_combination(result, temp, key_list, target-key*count);
                
                temp.subList(temp.size()-count, temp.size()).clear();
                
                count++;
            }
            
            key_list.add(0, key);
        }        
    }
}
