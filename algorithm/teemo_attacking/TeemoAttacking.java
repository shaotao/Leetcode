import java.io.*;
import java.util.*;


class TeemoAttacking
{
    public static void main(String[] args)
    {
	System.out.println("=== Teemo Attacking ===");
	Solution solution = new Solution();

        int[][] inputs = {{1,4}, {1,2}, {1,2,3,4,5}};
        int[] lens = {2,2,5};

        for(int i = 0; i < lens.length; i++) {
            int[] input = inputs[i];
            int len = lens[i];

            System.out.println("input = "+Arrays.toString(input));
            System.out.println("len = "+len);
            System.out.println("output = "+solution.findPoisonedDuration(input, len));
        }
    }
}


class Solution
{
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int i = 0; i < timeSeries.length-1; i++) {
            int val = timeSeries[i];
            int next = -1;
            if(timeSeries.length > 1) {
                next = timeSeries[i+1];
            }

            total += ((next==-1)||(val+duration-1 < next))?(duration):(duration - (val+duration-next));
        }

        if(timeSeries.length > 0) {
            total += duration;
        }
        
        return total;
    }
}
