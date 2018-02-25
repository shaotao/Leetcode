import java.io.*;
import java.util.*;


class MinCostClimbingStairs
{
    public static void main(String[] args)
    {
        System.out.println("=== Min Cost Climbing Stairs ===");
        Solution solution = new Solution();
        int[][] array_cost = {{10, 15, 20},
                              {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}};
        for (int[] cost : array_cost) {
            System.out.println("cost = "+Arrays.toString(cost));
            System.out.println("min cost = "+solution.minCostClimbingStairs(cost));
        }
    }
}


class Solution
{
    public int minCostClimbingStairs(int[] cost) {
        int sum[] = new int[cost.length+1];

        sum[0] = 0;
        sum[1] = 0;
        for (int i = 2; i < sum.length; i++) {
            int t1 = sum[i-2] + cost[i-2];
            int t2 = sum[i-1] + cost[i-1];
            sum[i] = (t1 < t2)?t1:t2;
        }

        return sum[cost.length];
    }
}
