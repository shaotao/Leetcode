import java.io.*;
import java.util.*;


class ValidPerfectSquare
{
    public static void main(String[] args)
    {
	System.out.println("=== Valid Perfect Square ===");
	Solution solution = new Solution();

        int[] nums = {16,14,808201};
        for(int num:nums) {
            System.out.println("num = "+num+", perfect square = "+solution.isPerfectSquare(num));
        }
    }
}


class Solution
{
    public boolean isPerfectSquare(int num) {
        return findSqrt(num, 0, num);
    }

    private boolean findSqrt(int num, int left, int right) {
        if(left < 0 || left > num ||
           right < 0 || right > num||
           left > right) {
            return false;
        }

        if(right - left <= 1) {
            return (((long)left*left) == num || ((long)right*right) == num);
        } else {
            int middle = (left+right)/2;
            if(((long)middle*middle) == num) { return true; }
            else if (((long)middle*middle) < num) {
                return findSqrt(num, middle, right);
            } else {
                return findSqrt(num, left, middle);
            }
        }
    }
}
