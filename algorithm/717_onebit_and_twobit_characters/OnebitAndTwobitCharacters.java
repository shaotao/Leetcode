import java.io.*;
import java.util.*;


class OnebitAndTwobitCharacters
{
    public static void main(String[] args)
    {
        System.out.println("=== 1-bit and 2-bit Characters ===");
        Solution solution = new Solution();
        int[][] input = {{1,0,0}, {1,1,1,0}};
        for (int[] bits : input) {
            System.out.println("bits = "+Arrays.toString(bits));
            System.out.println("one-bit = "+solution.isOneBitCharacter(bits));
        }
    }
}


class Solution
{
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length) {
            if (i == bits.length-1) { return true; }
            if (bits[i] == 0) { i++; }
            else { i+=2; }
        }
        
        return false;
    }
}
