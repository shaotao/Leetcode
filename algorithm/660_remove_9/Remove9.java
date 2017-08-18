import java.io.*;
import java.util.*;


class Remove9
{
    public static void main(String[] args)
    {
	System.out.println("=== Remove 9 ===");
	Solution solution = new Solution();

        int[] array = {7, 9, 100};
        for(int n:array) {
            System.out.println(String.format("%d) %d", n, solution.newInteger(n)));
        }
    }
}


class Solution
{
    public int newInteger(int n) {
        StringBuffer buf = new StringBuffer();
        while(n >= 9) {
            buf.append(n%9);
            n = n/9;
        }

        buf.append(n);

        return Integer.parseInt(buf.reverse().toString());
    }
}
