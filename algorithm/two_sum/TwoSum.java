import java.io.*;
import java.util.*;


class TwoSum
{
    public static void main(String[] args)
    {
		Solution solution = new Solution();
	
		int[] numbers = {2, 7, 11, 15};
		int target = 9;

		int[] result = solution.twoSum(numbers, target);

		System.out.println("numbers = "+array_to_string(numbers));
		System.out.println("target = "+target);

		System.out.println("result = "+array_to_string(result));
    }
    
    public static String array_to_string(int[] numbers)
    {
		StringBuffer result = new StringBuffer("");
		for(int i = 0; i < numbers.length; i++)
		{
			result.append(" "+numbers[i]);
		}
	
		return result.toString();
    }
}

class Solution
{
    public Solution()
    {
    }
    
    public int[] twoSum(int[] numbers, int target)
    {
		int size = numbers.length;

		for(int i = 0; i < size; i++)
		{
			for(int j = i+1; j < size; j++)
			{
				if(numbers[i]+numbers[j] == target)
				{
					int [] result = new int[2];
					result[0] = i+1;
					result[1] = j+1;

					return result;
				}
			}
		}
	
		return null;
    }
}