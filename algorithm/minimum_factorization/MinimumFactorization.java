import java.io.*;
import java.util.*;


class MinimumFactorization
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Factorization ===");
	Solution solution = new Solution();

        Integer[] array = {48,15,1};
        List<Integer> list = Arrays.asList(array);
        
        list.forEach((a) -> System.out.println(solution.smallestFactorization(a)));
    }
}


class Solution
{
    public int smallestFactorization(int a) {
        int ret = 0;

        if(a == 1) { return 1;}
        
        int n = a;
        StringBuffer buf = new StringBuffer();
        while (n >= 2) {
            boolean found = false;
            for (int i = 9; i >= 2; i--) {
                if (n % i == 0) {
                    n = n/i;
                    buf.append(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                return 0;
            }
        }

        try {
            ret = Integer.parseInt(buf.reverse().toString());
        } catch(NumberFormatException e) {
            return 0;
        }
        
        return ret;
    }
}
