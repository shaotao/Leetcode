import java.io.*;
import java.util.*;


class CountLargestGroup
{
    public static void main(String[] args)
    {
        System.out.println("=== Count Largest Group ===");
        Solution solution = new Solution();

        int[] input = {13, 2, 15, 24};
        for (int n :input) {
            System.out.println(String.format("n = %d, count = %d", n, solution.countLargestGroup(n)));
        }
            
    }
}


class Solution
{
    // compute the sum of all digits in n
    private int getSum(int n) {
        int tmp = n;
        int sum = 0;
        while (tmp > 0) {
            sum += tmp%10;
            tmp = tmp/10;
        }

        return sum;
    }
    
    public int countLargestGroup(int n) {
        int ret = 0;

        // a map to store sum to count
        // and find the max count
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            int count = 1;
            if (map.containsKey(sum)) {
                count += map.get(sum);
            } 
            map.put(sum, count);
            maxCount = (count > maxCount)?count:maxCount;
        }
        
        // iterate the map and find the # of keys = max count 
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                ret++;
            }
        }
        
        return ret;
    }
}
