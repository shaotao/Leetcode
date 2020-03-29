import java.io.*;
import java.util.*;


class PrimeNumberOfSetBitsInBinaryRepresentation
{
    public static void main(String[] args)
    {
        System.out.println("=== Prime Number of Set Bits in Binary Representation ===");
        Solution solution = new Solution();
        int L = 6; int R = 10;
        System.out.println("L = "+L+", R = "+R+", ret = "+solution.countPrimeSetBits(L, R));
        L = 10; R = 15;
        System.out.println("L = "+L+", R = "+R+", ret = "+solution.countPrimeSetBits(L, R));
    }
}


class Solution
{
    private static final Set<Integer> set = new HashSet<>();
    private static final int[] array = new int[]{2,3,5,7,11,13,17,19,23,29,31};
    static {
        for (int i : array) {
            set.add(i);
        }
    }
    
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            count += set.contains(numOneBits(i))?1:0;
        }
        return count;
    }

    private int numOneBits(int x) {
        int ret = 0;
        while (x > 0) {
            ret += (x & 1);
            x = x>>1;
        }

        return ret;
    }
}
