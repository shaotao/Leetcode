import java.io.*;
import java.util.*;


class CanPlaceFlowers
{
    public static void main(String[] args)
    {
	System.out.println("=== Can Place Flowers ===");
	Solution solution = new Solution();

        int[][] flowerbeds = {{1,0,0,0,1},
                              {1,0,0,0,1}};
        int n = 0;
        for(int[] flowerbed : flowerbeds) {
            n++;
            System.out.println("flowerbed = "+Arrays.toString(flowerbed)+", n = "+n+", can place: "+solution.canPlaceFlowers(flowerbed, n));
        }
    }
}


class Solution
{
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left = 0;

        int i = 0;
        while(i < flowerbed.length) {
            if(i == flowerbed.length-1) {
                left += (1-flowerbed[i]);
                i++;
            } else {
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    left++;
                }

                i += (2 + flowerbed[i+1]);
            }
        }

        //System.out.println("left = "+left);
        return (left >= n);
    }
}
