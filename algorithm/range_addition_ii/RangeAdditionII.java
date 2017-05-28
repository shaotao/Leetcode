import java.io.*;
import java.util.*;


class RangeAdditionII
{
    public static void main(String[] args)
    {
	System.out.println("=== Range Addition II ===");
	Solution solution = new Solution();

        int m = 3; int n = 3; int[][] ops = {{2,2}, {3,3}};
        System.out.println("max count = "+solution.maxCount(m, n, ops));
    }
}


class Solution
{
    public int maxCount(int m, int n, int[][] ops) {
        int minx = m;
        int miny = n;

        for(int i = 0; i < ops.length; i++) {
            if(minx == 0 || minx > ops[i][0]) { minx = ops[i][0]; }
            if(miny == 0 || miny > ops[i][1]) { miny = ops[i][1]; }
        }
        
        return minx*miny;
    }
}
