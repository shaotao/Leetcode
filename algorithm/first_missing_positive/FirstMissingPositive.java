import java.io.*;
import java.util.*;


class FirstMissingPositive
{
    public static void main(String[] args)
    {
        System.out.println("=== First Missing Positive ===");
        Solution solution = new Solution();
        
        int[] A = {3,4,-1,1};
        //int[] A = {1};
        
        int result = solution.firstMissingPositive(A);

        System.out.print("int[] A: ");
        for(int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.println();

        System.out.println("first missing positive = "+result);
    }
}


class Solution
{
    // use O(n) time and constant space
    public int firstMissingPositive(int[] A)
    {
        // each A[i] = [1, A.length] should be placed
        // at location A[A[i]-1], such that by scanning A,
        // we expect to see 1, 2, 3, 4, ..., A.length
        // if any one is missing, that is the result,
        // if all match, the next missing positive is A.length+1
        for(int i = 0; i < A.length; i++)
        {
            int target_idx = A[i]-1;
            if(target_idx == i || target_idx < 0 || target_idx >= A.length) { continue; }

            // ok, we can swap the A[i] to A[A[i]-1]
            int temp = A[target_idx];
            A[target_idx] = A[i];
            A[i] = temp;
	    
	    if(A[i] != A[target_idx])
	    {
		i--;
	    }
        }
        
        // next, we scan A, it should be 1, 2, 3, 
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != (i+1)) { return i+1; }
        }

        // if we get here, A is [1, 2, 3, ..., A.length]
        // next missing positive integer is A.length+1
        return A.length+1;
    }

    // use O(n) time and O(n) space, simpler than solution 3
    public int firstMissingPositive2(int[] A)
    {
        int result = 1;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] > 0) { map.put(A[i], A[i]); }
        }

        for(int i = 1; i <= A.length+1; i++)
        {
            if(!map.containsKey(i)) { return i; }
        }
        
        // we should not get here
        return -1;
    }    

    // this solution does NOT use constant space.
    // it uses O(n) space.
    public int firstMissingPositive3(int[] A)
    {
        int result = 1;

        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        
        for(int i = 0; i < A.length; i++)
        {
            int key = A[i];
            
            if(map.containsKey(key)) { continue; }
            else if(!map.containsKey(key-1) && map.containsKey(key+1))
            {
                // update the head of range
                int[] range = map.get(key+1);
                range[0] = key;
                map.put(key, range);
            }
            else if(map.containsKey(key-1) && !map.containsKey(key+1))
            {
                // update the tail of range
                int[] range = map.get(key-1);
                range[1] = key;
                map.put(key, range);
            }
            else if(!map.containsKey(key-1) && !map.containsKey(key+1))
            {
                // start a new segment
                int[] range = new int[2];
                range[0] = range[1] = key;
                map.put(key, range);
            }
            else
            {
                // need to merge two segments
                int[] left_range = map.get(key-1);
                int[] right_range = map.get(key+1);
                
                left_range[1] = right_range[1];
                right_range[0] = left_range[0];
                
                map.put(key, left_range);
            }
        }
        
        // scan the map for range and try to get the first missing positive number
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext())
        {
            int key = iter.next();            
            int[] range = map.get(key);
            if(result >= range[0] && result <= range[1])
            {
                result = range[1] + 1;
            }
        }

        return result;
    }
}
