import java.io.*;
import java.util.*;


class Subsets
{
    public static void main(String[] args)
    {
		System.out.println("=== Subsets ===");
		
		int[] S = {1,2,3};
		Solution solution = new Solution();
		
		ArrayList<ArrayList<Integer>> result = solution.subsets(S);
		
		for(int i = 0; i < result.size(); i++)
		{
			ArrayList<Integer> one_set = result.get(i);
			
			System.out.print((i+1)+": ");
			for(int j = 0; j < one_set.size(); j++)
			{
				System.out.print(one_set.get(j)+" ");
			}
			
			System.out.println();
		}
    }
}

class Solution
{
	public Solution()
	{
	}
	
	public void sort_list(ArrayList<Integer> list)
	{
		int size = list.size();
		
		for(int i = 0; i < size; i++)
		{
			for(int j = i+1; j < size; j++)
			{
				int num_i = list.get(i);
				int num_j = list.get(j);
				
				if(num_i > num_j)
				{
					list.remove(i);
					list.add(i, num_j);
					list.remove(j);
					list.add(j, num_i);
				}
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S)
	{
		ArrayList<Integer> input_list = new ArrayList<Integer>();
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < S.length; i++)
		{
			input_list.add(S[i]);
		}
		
		// sort input_list
		sort_list(input_list);
		
		// next we create the list
		int range = (int)(Math.pow(2, input_list.size()));
		for(int num = 0; num < range; num++)
		{
			ArrayList<Integer> one_set = new ArrayList<Integer>();
			for(int j = 0; j < input_list.size(); j++)
			{
				int input = input_list.get(j);
				int check = (int)(Math.pow(2, input_list.size()-1-j));
				
				if((num & check) == 0)
				{
					// skip this number
					continue;
				}
				
				// add this number
				one_set.add(input);
			}
			
			result.add(one_set);
		}
		
		return result;
	}
}









