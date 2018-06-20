import java.io.*;
import java.util.*;
import java.util.stream.*;

class RotatedDigits
{
    public static void main(String[] args)
    {
        System.out.println("=== Rotated Digits ===");
        Solution solution = new Solution();
        int N = 10;
        System.out.println("N = "+N);
        System.out.println("good number = "+solution.rotatedDigits(N));
    }
}


class Solution
{
    public int rotatedDigits(int N) {
        //return (int) IntStream.range(1, N+1).filter(i -> isValid(i)).count();
        int ret = 0;
        for (int i = 1; i <=N; i++) {
            ret += isValid(i)?1:0;
        }
        return ret;        
    }

    private boolean isValid(int n) {
        boolean hasGood = false;
        //System.out.print("n = "+n+", ");

        while (n > 0) {
            int r = n%10;
            if (r == 3 || r == 4 || r == 7) {
                return false;
            } else if (r == 2 || r == 5 || r == 6 || r == 9) {
                hasGood = true;
            }
            n = n/10;
        }

        //System.out.println("hasGood = "+hasGood);
        
        return hasGood;
    }
}
