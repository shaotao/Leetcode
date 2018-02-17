import java.io.*;
import java.util.*;


class RabbitsInForest
{
    public static void main(String[] args)
    {
        System.out.println("=== Rabbits in Forest ===");
        Solution solution = new Solution();
        int[][] answers_array = {{1, 1, 2},
                                 {10, 10, 10},
                                 {}}; 
        for (int[] answers : answers_array) {
            System.out.println("answers = "+Arrays.toString(answers));
            System.out.println("number of rabbits = "+solution.numRabbits(answers));
        }
    }
}


class Solution
{
    public int numRabbits(int[] answers) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int answer : answers) {
            int count = 1;
            if (map.containsKey(answer+1)) {
                count += map.get(answer+1);
            }
            map.put(answer+1, count);
        }

        for (int claim : map.keySet()) {
            int count = map.get(claim);
            int groups = (int) Math.ceil(1.0*count/claim);
            total += claim*groups;
        }
        return total;
    }
}
