import java.io.*;
import java.util.*;


class ThreeSum
{
    public static void main(String args[])
    {
        System.out.println("=== 3Sum ===");
        //int[] num = {-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9};
        int[] num = {-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1};

        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.threeSum(num);
        int num_sets = result.size();

        System.out.println("=== result ===");
        for(int idx_set = 0; idx_set < num_sets; idx_set++)
        {
            ArrayList<Integer> num_set = result.get(idx_set);

            int a = num_set.get(0);
            int b = num_set.get(1);
            int c = num_set.get(2);

            System.out.print("["+a+","+b+","+c+"] ");
        }
        System.out.println();
    }
}

class Solution
{
    // use HashMap to do it
    public ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {

	// the value is <idx1, idx2, num1, num2> so the 3rd number
	// can use idx to avoid duplicate insertion to map
	// key = num1 + num2;
	HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
	
	
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        sort_array(num);

        // for(int i = 0; i < num.length; i++)
        // {
        //     System.out.print(num[i]+", ");
        // }
        // System.out.println();

        int size = num.length;

        for(int idx_a = 0; idx_a < size; idx_a++)
        {
            for(int idx_b = idx_a+1; idx_b < size; idx_b++)
            {
		int a = num[idx_a];
		int b = num[idx_b];


		ArrayList<ArrayList<Integer>> list = map.get(a+b);
		if(list == null)
		{
		    list = new ArrayList<ArrayList<Integer>>();
		    map.put(a+b, list);
		}

		// ensure no duplicate a, b values with other items
		boolean dup_flag = false;
		for(int i = 0; i < list.size(); i++)
		{
		    if(list.get(i).get(1).equals(a) &&
		       list.get(i).get(3).equals(b))
		    {
			dup_flag = true;
			break;
		    }
		}
		
		if(dup_flag == false)
		{
		    ArrayList<Integer> one_list = new ArrayList<Integer>();
		    one_list.add(idx_a);
		    one_list.add(a);
		    one_list.add(idx_b);
		    one_list.add(b);
		    list.add(one_list);
		}
		
            }
        }

	// try to insert the 3rd number to map
	for(int idx_c = 0; idx_c < size; idx_c++)
	{
	    int c = num[idx_c];
	    int target_key = -1*c;
	    
	    ArrayList<ArrayList<Integer>> list = map.get(target_key);
	    if(list == null)
	    {
		// sum is not 0
		continue;
	    }

	    // ok, sum is 0, check if we can insert c by comparing idx_c
	    // with idx_a and idx_b
	    for(int i = 0; i < list.size(); i++)
	    {
		if(list.get(i).size() == 6)
		{
		    continue;
		}

		if(list.get(i).get(0).equals(idx_c) == true || 
		   list.get(i).get(2).equals(idx_c) == true)
		{
		    continue;
		}

		// ok, c is not a number with the same index as a or b
		// insert c to the list.get(i)
		if(c <= list.get(i).get(1))
		{
		    // insert c before a
		    list.get(i).add(0, idx_c);
		    list.get(i).add(1, c);
		}
		else if(c > list.get(i).get(1) && c <= list.get(i).get(3))
		{
		    // insert c after a, before b
		    list.get(i).add(2, idx_c);
		    list.get(i).add(3, c);
		}
		else
		{
		    // insert c after b
		    list.get(i).add(4, idx_c);
		    list.get(i).add(5, c);
		}				
		   
	    }

	    // as a, b are non-duplicate in the list, there will be no duplicates	    
	}

	// add all lists to result
	for(ArrayList<ArrayList<Integer>> value : map.values())
	{
	    for(int i = 0; i < value.size(); i++)
	    {
		// some map value has no match, skip it
		if(value.get(i).size() < 6)
		{
		    continue;
		}

		// if we get here, this is a valid triplet
		ArrayList<Integer> triplet = new ArrayList<Integer>();
		triplet.add(value.get(i).get(1));
		triplet.add(value.get(i).get(3));
		triplet.add(value.get(i).get(5));

		result.add(triplet);
		//System.out.println("add "+triplet);
	    }
	}


        // remove duplicates
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
        for(int idx_set_i = 0; idx_set_i < result.size(); idx_set_i++)
        {
            boolean dup_flag = false;
            ArrayList<Integer> set_i = result.get(idx_set_i);
            for(int idx_set_j = 0; idx_set_j < result2.size(); idx_set_j++)
            {
                ArrayList<Integer> set_j = result2.get(idx_set_j);

                if(set_i.get(0).equals(set_j.get(0)) &&
                   set_i.get(1).equals(set_j.get(1)) &&
                   set_i.get(2).equals(set_j.get(2)))
                {
                    dup_flag = true;
                    break;
                }
            }

            if(dup_flag == false)
            {
                result2.add(set_i);
            }
        }

        return result2;
    }

    public void sort_array(int[] num)
    {
        int size = num.length;

        for(int idx_i = 0; idx_i < size; idx_i++)
        {
            for(int idx_j = idx_i+1; idx_j < size; idx_j++)
            {
                int temp = 0;

                if(num[idx_i] > num[idx_j])
                {
                    temp = num[idx_i];
                    num[idx_i] = num[idx_j];
                    num[idx_j] = temp;
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum2(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        sort_array(num);

        // for(int i = 0; i < num.length; i++)
        // {
        //     System.out.print(num[i]+", ");
        // }
        // System.out.println();

        int size = num.length;

        for(int idx_a = 0; idx_a < size; idx_a++)
        {
            for(int idx_b = idx_a+1; idx_b < size; idx_b++)
            {
                for(int idx_c = idx_b+1; idx_c < size; idx_c++)
                {
                    int a = num[idx_a];
                    int b = num[idx_b];
                    int c = num[idx_c];

                    if(a + b + c == 0)
                    {
                        ArrayList<Integer> set = new ArrayList<Integer>();
                        set.add(a);
                        set.add(b);
                        set.add(c);

                        result.add(set);
                    }
                }
            }
        }

        // remove duplicates
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
        for(int idx_set_i = 0; idx_set_i < result.size(); idx_set_i++)
        {
            boolean dup_flag = false;
            ArrayList<Integer> set_i = result.get(idx_set_i);
            for(int idx_set_j = 0; idx_set_j < result2.size(); idx_set_j++)
            {
                ArrayList<Integer> set_j = result2.get(idx_set_j);

                if(set_i.get(0).equals(set_j.get(0)) &&
                   set_i.get(1).equals(set_j.get(1)) &&
                   set_i.get(2).equals(set_j.get(2)))
                {
                    dup_flag = true;
                    break;
                }
            }

            if(dup_flag == false)
            {
                result2.add(set_i);
            }
        }

        return result2;
    }

}


