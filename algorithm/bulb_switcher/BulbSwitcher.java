import java.io.*;
import java.util.*;


class BulbSwitcher
{
    public static void main(String[] args)
    {
        System.out.println("=== Bulb Switcher ===");
        Solution solution = new Solution();
        //int n = 12;
        int n = 100000000;

        System.out.println("n = "+n+", lighted bulbs = "+solution.bulbSwitch(n));
    }
}


class Solution
{
    public int bulbSwitch(int n) {
        if(n <= 0) { return 0; }
        return ((int)(Math.sqrt(n)));
    }
    
    public int bulbSwitch2(int n)
    {
        int total = 0;
        
        // for each bulb
        for(int i = 1; i <= n; i++) {
            int sqrt = (int) (Math.sqrt(i));
            if(i == sqrt*sqrt) { total++; }
        }

        return total;
    }
}
