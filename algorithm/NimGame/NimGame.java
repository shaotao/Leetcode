import java.io.*;
import java.util.*;

class NimGame
{
    public static void main(String[] args)
    {
        System.out.println("=== Nim Game ===");
        Solution solution = new Solution();
        int num = 10;
        
        for(int i = 1; i <= num; i++) {
            System.out.println("n = "+i+", can win nim: "+solution.canWinNim(i));
        }
    }
}

class Solution
{
    public boolean canWinNim(int n) {
        return (n%4 != 0);
    }
}
