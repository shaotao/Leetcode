import java.io.*;
import java.util.*;


class PoorPigs
{
    public static void main(String[] args)
    {
        System.out.println("=== My Class ===");
        Solution solution = new Solution();
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        System.out.println("buckets = "+buckets);
        System.out.println("minutesToDie = "+minutesToDie);
        System.out.println("minutesToTest = "+minutesToTest);
        System.out.println("min # of pigs = "+solution.poorPigs(buckets, minutesToDie, minutesToTest));
    }
}


class Solution
{
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = (int)Math.ceil(1.0*minutesToTest/minutesToDie);
        int num = (int)Math.ceil(buckets/rounds);
        return num;
    }
}
