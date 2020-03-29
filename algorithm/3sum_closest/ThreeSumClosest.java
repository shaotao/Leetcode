import java.io.*;
import java.util.*;


class ThreeSumClosest
{
    public static void main(String args[])
    {
        System.out.println("=== 3Sum Closest ===");

	//int[] num = {25,-12,2,66,-8,67,67,-93,-97,-68,-49,-24,49,90,31,87,-1,14,50,-25,69,-91,-23,82,-43,96,80,43,4,-87,40,24,-71,-10,-16,78,-60,-20,-84,69,84,84,16,-23,-25,88,15,72,-82,-72,-16,49,50,26,3,26,-92,82,-69,60,-81,24,-25,-47,-77,-37,-33,69,21,-50,56,-43,18,-87,96,47,59,37,100,23,-34,-69,-12,-83,-65,91,75,100,24,80,64,-27,-31,39,-46,-73,88,-13,-10,67,95,27,91,-61,-44,67,0,-29,-57,-61,-62,83,-6,82,-58,-58,-5,-87,-44,9,-20,-28,3,17,57,-63,78,34,7,-68,30,-49,77,-97,15,-42,-49,-22,-60,78,84,35,19};
	//int target = 250;

	//int[] num = {1, 1, 1};
	//int target = 0;

        int[] num = {-1, 2, 1, -4};
        int target = 1;

        Solution solution = new Solution();

        //int result = solution.threeSumClosest(num, target);
        //int result = solution.threeSumClosest2(num, target);
        //int result = solution.threeSumClosest3(num, target);
        int result = solution.threeSumClosest4(num, target);

        System.out.println("target_value = "+target+", closest_sum = "+result);
    }
}

class Solution
{

    public int threeSumClosest3(int[] num, int target)
    {
        boolean uninit = true;
        int result = 0;
        int min_diff = 0;

        for(int i = 0; i < num.length; i++)
        {
            for(int j = i+1; j < num.length; j++)
            {
                for(int k = j+1; k < num.length; k++)
                {
                    int sum = num[i]+num[j]+num[k];
                    int diff = (int)Math.abs(sum - target);
                    if(uninit == true || diff < min_diff)
                    {
                        uninit = false;
                        min_diff = diff;
                        result = sum;
                    }
                }
            }
        }
        
        return result;
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


    public void sort_list(ArrayList<Integer> list)
    {
	for(int i = 0; i < list.size(); i++)
	{
	    for(int j = i+1; j < list.size(); j++)
	    {
		if(list.get(i) > list.get(j))
		{
		    // swap i and j
		    int item_i = list.get(i);
		    int item_j = list.get(j);
		    list.remove(j);
		    list.remove(i);
		    list.add(i, item_j);
		    list.add(j, item_i);
		}
	    }
	}
    }

    // use HashMap to do it
    public int threeSumClosest(int[] num, int target)
    {

	// the value is <idx1, idx2, num1, num2> so the 3rd number
	// can use idx to avoid duplicate insertion to map
	// key = num1 + num2;
	HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
	
        sort_array(num);

        // for(int i = 0; i < num.length; i++)
        // {
        //     System.out.print(num[i]+", ");
        // }
        // System.out.println();

        int size = num.length;

	ArrayList<Integer> key_list = new ArrayList<Integer>();

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

		    key_list.add(a+b);
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

	sort_list(key_list);
	//System.out.println(key_list);

	// try to add the 3rd number
	Integer closest_sum = null;
	int min_diff = 0;

	for(int idx_c = 0; idx_c < size; idx_c++)
	{
	    int c = num[idx_c];

	    // use binary search to find the entry
	    int left = 0;
	    int right = key_list.size()-1;
	    int start_mid_idx = left;

	    while(left < right)
	    {
		if(key_list.get(left)+c >= target)
		{
		    // target is <= left bound, stop, return left
		    start_mid_idx = left;
		    break;
		}
		else if(key_list.get(right)+c <= target)
		{
		    // target is >= right bound, stop, return right
		    start_mid_idx = right;
		    break;
		}
		else
		{
		    // start_mid_idx take either left or right
		    if( Math.abs(key_list.get(left)+c - target) <=
			Math.abs(key_list.get(right)+c - target))
		    {
			start_mid_idx = left;
		    }
		    else
		    {
			start_mid_idx = right;
		    }

		    int mid_idx = (left+right)/2;

		    if( key_list.get(mid_idx)+c == target)
		    {
			start_mid_idx = mid_idx;
			break;
		    }
		    else if( key_list.get(mid_idx)+c > target)
		    {
			// search on the left
			int prev_right = right;
			right = mid_idx;

			if(right >= prev_right)
			{
			    right -= 1;
			}
		    }
		    else
		    {
			// search on the right
			int prev_left = left;
			left = mid_idx;
			
			if(left <= prev_left)
			{
			    left += 1;
			}
		    }
		}
	    }


	    // now we have the start_mid_idx
	    // find an key_list idx within the vincinty
	    // that idx_c will not be duplcated in the triplet
	    //System.out.println("c = "+c+", key_list item = "+key_list.get(start_mid_idx)+", start_mid_idx = "+start_mid_idx);

	    // now we have start_mid_idx, try to find a idx that is close to it
	    int final_idx = -1;
	    
	    // search left	    
	    int left_idx = -1;
	    for(int idx = start_mid_idx; idx >= 0; idx--)
	    {
		ArrayList<ArrayList<Integer>> value = map.get(key_list.get(idx));
		boolean valid = false;

		for(int idx_list = 0; idx_list < value.size(); idx_list++)
		{
		    ArrayList<Integer> list = value.get(idx_list);
		    
		    if(list.get(0) != idx_c && list.get(2) != idx_c)
		    {
			left_idx = idx;

			valid = true;
			break;
		    }
		}

		if(valid == true)
		{
		    break;
		}

	    }

	    // search right
	    int right_idx = -1;
	    for(int idx = start_mid_idx+1; idx< key_list.size(); idx++)
	    {
		ArrayList<ArrayList<Integer>> value = map.get(key_list.get(idx));
		boolean valid = false;

		for(int idx_list = 0; idx_list < value.size(); idx_list++)
		{
		    ArrayList<Integer> list = value.get(idx_list);
		    
		    if(list.get(0) != idx_c && list.get(2) != idx_c)
		    {
			right_idx = idx;
			valid = true;
			break;
		    }
		}

		if(valid == true)
		{
		    break;
		}
		
	    }

	    final_idx = left_idx;
	    if(final_idx < 0)
	    {
		final_idx = right_idx;
	    }
	    else
	    {
		if(right_idx >= 0)
		{
		    // check if we need to switch to right_idx
		    if( Math.abs(target - key_list.get(right_idx) - c) <
			Math.abs(target - key_list.get(left_idx) -c))
		    {
			final_idx = right_idx;
		    }
		}
	    }

	    if(final_idx == -1)
	    {
		continue;
	    }

	    //System.out.println("c = "+c+", key_list item = "+key_list.get(final_idx)+", final_idx = "+final_idx);

	    int sum = key_list.get(final_idx)+c;
	    int diff = Math.abs(target - sum);
		
	    
	    if(closest_sum == null || diff < min_diff)
	    {
		closest_sum = key_list.get(final_idx)+c;
		min_diff = diff;
	    }
	}
	    
        return closest_sum;
    }


    public int threeSumClosest2(int[] num, int target)
    {

	// the value is <idx1, idx2, num1, num2> so the 3rd number
	// can use idx to avoid duplicate insertion to map
	// key = num1 + num2;
	HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
	
        sort_array(num);

        // for(int i = 0; i < num.length; i++)
        // {
        //     System.out.print(num[i]+", ");
        // }
        // System.out.println();

        int size = num.length;

	ArrayList<Integer> key_list = new ArrayList<Integer>();

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

		    key_list.add(a+b);
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


	// try to add the 3rd number
	Integer closest_sum = null;
	int min_diff = 0;

	for(int idx_c = 0; idx_c < size; idx_c++)
	{
	    int c = num[idx_c];

	    for(Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry:map.entrySet())
	    {
		ArrayList<ArrayList<Integer>> value = entry.getValue();

		boolean value_ok = false;
		for(ArrayList<Integer> list:value)
		{
		    if(list.get(0).equals(idx_c) == false &&
		       list.get(2).equals(idx_c) == false)
		    {
			value_ok = true;
			break;
		    }
		}

		if(value_ok == false)
		{
		    // idx_c is used in all entries of this value
		    continue;
		}


		int sum_value = c + entry.getKey();
		int diff = Math.abs(sum_value - target);

		// ok, this value is fine
		// try to update the min-gap
		if(closest_sum == null || diff < min_diff)
		{
		    closest_sum = sum_value;
		    min_diff = diff;
		}
	    }
	}
	    
        return closest_sum;
    }

    // return the closet sum for the (i, j) pair
    public int find_closest_binary(int[] num, int left, int right, int i, int j, int target)
    {
        if(left >= right)
        {
            if(left != i && left != j)
            {
                return num[i]+num[j]+num[left];
            }
            else
            {
                return num[0]+num[1]+num[2];
            }
        }
        else
        {
            // check min, check max, check middle
            int min_idx = left;
            if(min_idx == i) { min_idx++; }
            if(min_idx == j) { min_idx++; }
            if(min_idx > right) { return num[0]+num[1]+num[2]; }
            else
            {
                if(num[min_idx] + num[i] + num[j] >= target)
                {
                    return num[i]+num[j]+num[min_idx];
                }
            }

            int max_idx = right;
            if(max_idx == j) { max_idx--; }
            if(max_idx == i) { max_idx--; }
            if(max_idx < left) { return num[0]+num[1]+num[2]; }
            else
            {
                if(num[max_idx] + num[i] + num[j] <= target)
                {
                    return num[i]+num[j]+num[max_idx];
                }
            }
            
            int ret1 = find_closest_binary(num, left, (left+right)/2, i, j, target);
            int ret2 = find_closest_binary(num, (left+right)/2+1, right, i, j, target);
            
            if(Math.abs(ret1 - target) < Math.abs(ret2 - target))
            {
                return ret1;
            }
            else 
            {
                return ret2;
            }
        }
    }

    public int threeSumClosest4(int[] num, int target)
    {
        // sort the array O(n^2)
        for(int i = 0; i < num.length; i++)
        {
            for(int j = i+1; j < num.length; j++)
            {
                if(num[i] > num[j])
                {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        
        boolean init = false;
        int closest_sum = 0;
        // get the sum2 values O(n^2)
        for(int i = 0; i < num.length; i++)
        {
            for(int j = i+1; j < num.length; j++)
            {
                // use binary search for the minimum sum
                // with pair[i][j]
                int ret = find_closest_binary(num, 0, num.length-1, i, j, target);
                if(init == false || Math.abs(closest_sum - target) > Math.abs(ret - target))
                {
                    init = true;
                    closest_sum = ret;
                }
            }
        }
        
        return closest_sum;
    }
}


