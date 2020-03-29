import java.util.*;
import java.io.*;


class SingleNumber2
{
    public static void main(String[] args)
    {
        System.out.println("=== SingleNumber ===");
        
        Solution solution = new Solution();
        
        int[] A = {1,2,3,4,4,5,6,3,2,1,6,1,2,3,4,6};
        
        int result = solution.singleNumber(A);
        
        System.out.print("array = ");
        for(int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        System.out.println("single number = "+result);
    }
}


class Solution
{
    public int singleNumber(int[] A)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < A.length; i++)
        {
            Integer value = map.get(A[i]);
            if(value == null)
            {
                // this is a new number
                map.put(A[i], 1);
            }
            else if(value < 2)
            {
                map.put(A[i], value+1);
            }
            else
            {
                // this is a number which has appeared 3 times, 
                // remove it from map
                map.remove(A[i]);
            }
        }
        
        // take the only element left in map
        Integer result = null;
        for(Integer key : map.keySet())
        {
            result = key;
            break;
        }

        return result;
    }
}
