import java.io.*;
import java.util.*;


class PositionsOfLargeGroups
{
    public static void main(String[] args)
    {
        System.out.println("=== Positions of Large Groups ===");
        Solution solution = new Solution();
        String[] input = {"abbxxxxzzy", "abc", "abcdddeeeeaabbbcd"};
        for (String S : input) {
            List<List<Integer>> ret = solution.largeGroupPositions(S);
            System.out.println("S = "+S);
            System.out.println("ret = "+ret);
        }
    }
}


class Solution
{
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int count = 0;
        int start = -1;
        int end = -1;
        char prev = '\0';
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (count == 0) {
                prev = ch;
                start = i;
                end = i;
                count++;
            } else {
                if (ch == prev) {
                    count++;
                    end = i;
                } else {
                    if (count >= 3)  {
                        List<Integer> pair = Arrays.asList(start, end);
                        ret.add(pair);
                    }
                    count = 1;
                    prev = ch;
                    start = i;
                    end = i;
                }
            }
        }
        if (count >= 3)  {
            List<Integer> pair = Arrays.asList(start, end);
            ret.add(pair);
        }
        return ret;
    }
}
