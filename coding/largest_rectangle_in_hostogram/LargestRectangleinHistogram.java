import java.io.*;
import java.util.*;


class LargestRectangleinHistogram
{
    public static void main(String[] args)
    {
        System.out.println("=== Largest Rectangle in Histogram! ===");
        Solution solution = new Solution();
        
        //int[] height = { 2, 1, 5, 6, 2, 3 };
        //int[] height = { 3, 3, 2, 2 };
        int[] height = { 2, 1, 3, 4, 2, 3 };
        //int[] height = new int[20000];
        //for(int i = 0; i < height.length; i++) { height[i] = i; }
        int ret = solution.largestRectangleArea(height);
        
        System.out.print("height[] = ");
        for(int i = 0; i < height.length; i++)
        {
            System.out.print(height[i]+", ");
        }
        System.out.println();

        System.out.println("largest rectangle area = "+ret);
    }
}


class Solution
{
    public int largestRectangleArea(int[] height)
    {
        int result = 0;
        int size = height.length;

        // create the array to store the min height between i, j(j>=i)
        int[][] min_heights = new int[size][size];
        for(int j = 0; j < size; j++)
        {
            for(int i = 0; i <= j; i++)
            {
                if(i ==j) { min_heights[i][j] = height[j]; }
                else
                {
                    min_heights[i][j] = (min_heights[i][j-1] < height[j])? min_heights[i][j-1]:height[j];
                }
                
                int area = (j-i+1)*min_heights[i][j];
                
                if(result < area) { result = area; }
            }
        }

        return result;
    }
}