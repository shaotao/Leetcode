import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class DeleteAndEarn
{
    public static void main(String[] args)
    {
        System.out.println("=== Delete and Earn ===");
        Solution solution = new Solution();
        int[][] arrays = {{3,4,2},
                          {2,2,3,3,3,4}};
        for (int[] nums : arrays) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("earn = "+solution.deleteAndEarn(nums));
        }
    }
}


class Solution
{
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.stream().forEach(x -> {
                if(map.containsKey(x)) {
                    map.put(x, map.get(x)+x);
                } else {
                    map.put(x, x);
                }
            });

        int[] sortedKeys = map.keySet().stream().sorted().mapToInt(x->x).toArray();
        int[] score = new int[sortedKeys.length];

        //System.out.println("map = "+map);
        //System.out.println("sortedKeys = "+Arrays.toString(sortedKeys));

        for (int i = 0; i < sortedKeys.length; i++) {
            if (i == 0) {
                score[i] = map.get(sortedKeys[i]);
            } else if (i == 1) {
                int k2 = sortedKeys[i];
                int k1 = sortedKeys[i-1];
                if (k2 - k1 == 1) {
                    score[i] = (map.get(k2) > map.get(k1))?map.get(k2):map.get(k1);
                } else {
                    score[i] = score[i-1] + map.get(k2);
                }
            } else {
                int k3 = sortedKeys[i];
                int k2 = sortedKeys[i-1];
                if(k3 - k2 == 1) {
                    score[i] = (score[i-2] + map.get(k3))>score[i-1]? (score[i-2] + map.get(k3)): score[i-1];
                } else {
                    score[i] = score[i-1] + map.get(k3);
                }
            }
            //System.out.println("score = "+Arrays.toString(score));
        }
        
        return score[score.length-1];
    }
}
