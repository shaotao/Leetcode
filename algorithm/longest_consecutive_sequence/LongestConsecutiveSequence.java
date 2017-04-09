import java.io.*;
import java.util.*;


class LongestConsecutiveSequence
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Consecutive Sequence ===");
        Solution solution = new Solution();

        //int[] num = {100, 4, 200, 1, 3, 2};
        int[] num = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
	//int[] num = {-4,-1,4,-5,1,-6,9,-6,0,2,2,7,0,9,-3,8,9,-2,-6,5,0,3,4,-2};
	//int[] num = {-6,-9,8,-8,-1,-3,-6,8,-9,-1,-4,-8,-5,0,1,6,-8,-5,-7,8,-2,-8,4,5,-5,-1,-5};

        int result = solution.longestConsecutive(num);
        
        System.out.print("num: ");
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+" ");
        }
        System.out.println();
        System.out.println("result = "+result);
    }
}


class Solution
{
    public void print_map(HashMap<Integer, int[]> map)
    {
	Iterator<Integer> iter = map.keySet().iterator();
	while(iter.hasNext())
	{
	    int key = iter.next();
	    int[] range = map.get(key);
	
	    System.out.print("key = "+key+", range = ");
	    for(int i = 0; i < range.length; i++)
	    {
		System.out.print(range[i]+" ");
	    }
	    System.out.println();
	}	
    }
    
    public int longestConsecutive(int[] num)
    {
	int result = 0;

	HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
	
	for(int i = 0; i < num.length; i++)
	{
	    int key = num[i];

	    if(map.containsKey(key)) 
	    {
		continue; 
	    }
	    else if(map.containsKey(key-1) && !map.containsKey(key+1))
	    {
		int[] range = map.get(key-1);
		range[1] = key;
		map.put(key, range);
	    }
	    else if(map.containsKey(key+1) && !map.containsKey(key-1))
	    {
		int[] range = map.get(key+1);
		range[0] = key;
		map.put(key, range);
	    }
	    else if(!map.containsKey(key-1) && !map.containsKey(key+1))
	    {
		int[] range = new int[2];
                range[0] = key;
                range[1] = key;
		map.put(key, range);
	    }
	    else 
	    {
		int[] range_left = map.get(map.get(key-1)[0]);
		int[] range_right = map.get(map.get(key+1)[1]);

                range_left[1] = range_right[1];
                range_right[0] = range_left[0];

		map.put(key, range_left);
	    }
	}

	// search the map for the longest list
	Iterator<Integer> iter = map.keySet().iterator();
	int count = 0;
	while(iter.hasNext())
	{
	    int key = iter.next();
	    int[] range = map.get(key);

            int seq = range[1] - range[0] + 1;

	    if(count == 0 || result < seq)
	    {
		result = seq;
	    }
	    
	    count++;
	}
	
	return result;
    }

    // use a bit map to store the status of all numbers
    // between min and max, not exactly o(n) time
    public int longestConsecutive2(int[] num)
    {
        int result = 0;

        int min = -1;
        int max = -1;
        
        if(num.length == 0) { return 0; }
        
        // find the min and max, find the range
        for(int i = 0; i < num.length; i++)
        {
            if(i == 0 || min > num[i])
            {
                min = num[i];
            }

            if(i == 0 || max < num[i])
            {
                max = num[i];
            }
        }

        // now we allocate the array with initial value = min-1
        int size = (int)(((long)max-min+1)/8) + (((max-min+1)%8 != 0) ? 1:0);

        byte[] array = new byte[size];
        
        //System.out.println("min = "+min+", max = "+max);
        //System.out.println("size = "+size);

        for(int i = 0; i < size; i++) { array[i] = 0; }

        for(int i = 0; i < num.length; i++)
        {
            array[(int) (((long)num[i]-min)/8)] |= (byte) Math.pow(2, ((long)num[i]-min)%8);
        }
        
        //System.out.println("first byte = "+array[0]);
        //System.out.println("last byte = "+array[size-1]);

        // scan array for longest consecutive sequence of '1's
        int cur_seq = 0;
        for(int i = 0; i < size; i++)
        {            
            for(int j = 0; j < 8; j++)
            {
                byte a = (byte) (array[i] >> j);
                
                if((a & 1) == 1)
                {
                    cur_seq++;
                    result = ( (cur_seq > result) ? cur_seq : result);
                }
                else
                {
                    cur_seq = 0;
                }
            }
        }

        return result;
    }
}

