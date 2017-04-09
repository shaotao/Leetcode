import java.io.*;
import java.util.*;


class FindPeakElement
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Peak Element ===");
        Solution solution = new Solution();
        //int[] num = {1,2,3,1};
        int[] num = {1,2,3,4,5,2,1};
        int result = solution.findPeakElement(num);
        System.out.print("num = ");
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+",");
        }
        System.out.println();
        System.out.println("peak idx = "+result);
    }
}


class Solution
{
    public int findPeakElement(int[] num)
    {
        int left = 0;
        int right = num.length-1;
        
        while(left < right)
        {
            if(left == right -1) {
                return (num[left] > num[right])?left:right;
            } else {
                int middle = (left+right)/2;
                if(num[middle] < num[middle-1]) {
                    right = middle;
                } else {
                    left = (right-left == 1)?middle+1:middle;
                }
            }
        }
        
        return left;
    }
}
