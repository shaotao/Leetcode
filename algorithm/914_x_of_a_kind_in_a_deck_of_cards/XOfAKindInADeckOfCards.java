import java.io.*;
import java.util.*;


class XOfAKindInADeckOfCards
{
    public static void main(String[] args)
    {
        System.out.println("=== X of a Kind in a Deck of Cards ===");
        Solution solution = new Solution();
        int[][] array = {{1,2,3,4,4,3,2,1},
                         {1,1,1,2,2,2,3,3},
                         {1},
                         {1,1},
                         {1,1,2,2,2,2},
                         {1,1,1,1,2,2,2,2,2,2}};
        for (int[] input : array) {
            System.out.println("input = "+Arrays.toString(input));
            System.out.println("x of kind = "+solution.hasGroupsSizeX(input));
        }
    }
}


class Solution
{
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            int count = map.containsKey(i)?(map.get(i)+1):1;
            map.put(i, count);
        }

        int min = map.values().stream().mapToInt(v -> v).min().orElse(0);
        for (int i = 2; i <= min; i++) {
            final int div = i;
            boolean tmp = map.values().stream().allMatch(v -> (v%div == 0));
            if (tmp) {
                return true;
            }
        }
        
        return false;
    }
}
