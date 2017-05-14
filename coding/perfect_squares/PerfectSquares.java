import java.io.*;
import java.util.*;


class PerfectSquares
{
    public static void main(String[] args)
    {
        System.out.println("=== Perfect Squares ===");
        Solution solution = new Solution();

        int n = 20;

        /*
        for(int i = 1; i <= n; i++) {
            int num_squares = solution.numSquares(i);
            System.out.println("i = "+i+", num_squares = "+num_squares);
        }
        */
        n = 8935;
        int num_squares = solution.numSquares(n);
        System.out.println("n = "+n+", num_squares = "+num_squares);
        
    }
}

class Solution
{
    public int numSquares(int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        
        for(int i = 2; i <= n; i++) {

            int sqrt = (int)(Math.sqrt(i));
            if(i == sqrt*sqrt) {
                list.add(1);
            } else {   
                // for i > 0
                int min = 1;
                for(int j = 1; j <= i/2; j++) {
                    int num = list.get(j) + list.get(i-j);
                    if(j == 1 || min > num) {
                        min = num;
                    }
                }
                list.add(min);
            }
        }

        return list.get(n);
    }
}
