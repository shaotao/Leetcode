import java.io.*;
import java.util.*;


class SelfDividingNumbers
{
    public static void main(String[] args)
    {
        System.out.println("=== Self Dividing Numbers ===");
        Solution solution = new Solution();
        int left = 1;
        int right = 22;
        List<Integer> ret = solution.selfDividingNumbers(left, right);
        System.out.println("left="+left+", right="+right+", output="+ret);
    }
}


class Solution
{
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            if (n < 10) { list.add(n); }
            else {
                int tmp = n;
                boolean valid = true;
                while (tmp > 0) {
                    int digit = tmp%10;
                    if (digit == 0 || n % digit != 0) {
                        valid = false;
                        break;
                    }
                    tmp = tmp/10;
                }
                if(valid) { list.add(n); }
            }
        }
        return list;
    }
}
