import java.io.*;
import java.util.*;


class HandOfStraights
{
    public static void main(String[] args)
    {
        System.out.println("=== Hand of Straights ===");
        Solution solution = new Solution();
        int[][] input = {{1,2,3,6,2,3,4,7,8},
                         {1,2,3,4,5},
                         {1,1,2,2,3,3}};
        int[] Ws = {3, 4, 3};
        for (int i = 0; i < input.length; i++) {
            System.out.println("hand = "+Arrays.toString(input[i]));
            System.out.println("W = "+Ws[i]);
            System.out.println("is N straight = "+solution.isNStraightHand(input[i], Ws[i]));
        }
    }
}


class Solution
{
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || W <= 0 || hand.length%W != 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<Integer>();
        
        for (int card : hand) {
            int count = 1;
            if (map.containsKey(card)) {
                count += map.get(card);
            } else {
                keys.add(card);
            }
            map.put(card, count);
        }

        Collections.sort(keys);

        //System.out.println("keys = "+keys);
        //System.out.println("map = "+map);
        
        for(Integer key: keys) {
            int count = map.get(key);
            if (count == 0) {
                continue;
            } else {
                for(int i = 0; i < W; i++) {
                    Integer n = map.get(key+i);
                    if (n == null || n.intValue() < count) {
                        return false;
                    } else {
                        map.put(key+i, n-count);
                    }
                }
            }
        }

        for (Integer key: map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        
        return true;
    }
}
