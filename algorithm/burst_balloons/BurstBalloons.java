import java.io.*;
import java.util.*;


class BurstBalloons
{
    public static void main(String[] args)
    {
	System.out.println("=== Burst Balloons ===");
	Solution solution = new Solution();

        int[] nums = {3,1,5,8};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("max coins = "+solution.maxCoins(nums));
    }
}


class Solution
{
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) { return 0; }
        int n = nums.length;

        int[] mynums = new int[2 + n];
        mynums[0] = 1; mynums[n+1] = 1;
        for(int i = 1; i <= n; i++) {
            mynums[i] = nums[i-1];
        }

        int[][] array = new int[n+2][n+2];
        
        for(int j = 2; j <= n+1; j++) {
            int i = 0;
            int d = 0;
            for(int t = j; t <= n+1; t++) {
                int a = i+d;
                int b = j+d;
                array[a][b] = f(array, mynums, a, b);
                //System.out.println("array["+a+"]["+b+"] = "+array[a][b]);
                d++;
            }
        }

        return array[0][n+1];
    }

    public int f(int[][] array, int[] mynums, int a, int b) {
        if((b - a) < 2) {
            return 0;
        } else if ((b - a) == 2) {
            return (mynums[a]*mynums[a+1]*mynums[b]);
        } else {
            int max = 0;
            for(int i = a+1; i <=b-1; i++) {
                int value = array[a][i] + mynums[a]*mynums[i]*mynums[b] + array[i][b];
                
                if(i == (a+1) || value > max) {
                    max = value;
                }
            }

            return max;
        }
    }
}
