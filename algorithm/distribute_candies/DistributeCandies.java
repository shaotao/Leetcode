import java.io.*;
import java.util.*;


class DistributeCandies
{
    public static void main(String[] args)
    {
	System.out.println("=== Distribute Candies ===");
	Solution solution = new Solution();

        int[] candies = {1,1,2,2,3,3};
        System.out.println("candies = "+Arrays.toString(candies));
        System.out.println("solution.distributeCandies = "+solution.distributeCandies(candies));
    }
}


class Solution
{
    public int distributeCandies(int[] candies) {
        if(candies == null) { return 0; }
        Set<Integer> set = new HashSet<Integer>();
        int max = candies.length/2;
        for(int candy : candies) {
            set.add(candy);
        }

        return (set.size()>max)?max:set.size();
    }
}
