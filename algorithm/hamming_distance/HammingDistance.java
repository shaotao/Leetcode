import java.io.*;
import java.util.*;


class HammingDistance
{
    public static void main(String[] args)
    {
	System.out.println("=== Hamming Distance ===");
	Solution solution = new Solution();
        int x = 1;
        int y = 4;
        System.out.println("x = "+x+", y = "+y+", hamming distance = "+solution.hammingDistance(x,y));
    }
}


class Solution
{
    public int hammingDistance(int x, int y) {
        int t = x^y;
        int count = 0;
        while(t > 0) {
            count += (t & 1);
            t = t>>1;
        }
        return count;
    }
}
