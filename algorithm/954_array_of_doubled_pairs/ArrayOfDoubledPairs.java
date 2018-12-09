import java.io.*;
import java.util.*;


class ArrayOfDoubledPairs
{
    public static void main(String[] args)
    {
        System.out.println("=== Array of Doubled Pairs ===");
        Solution solution = new Solution();
        int[][] input = {
            //{0,0},
            //{3,1,3,6},
            //{2,1,2,6},
            //{4,-2,2,-4},
            //{1,2,4,16,8,4},
            //{10,20,40,80},
            //{3,1,3,6},
            {0,4,0,2,-6,-4,8,-3,0,0,2,-6,-3,-6,-2,-3,1,4}
        };

        for (int[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("canReorderDoubled = "+solution.canReorderDoubled(A));
        }
    }
}


class Solution
{
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            int count = 1;
            if (map.containsKey(a)) {
                count += map.get(a);
            }
            map.put(a, count);
        }

        //System.out.println(">> map = "+map);
        
        for (int key : map.keySet()) {
            int more = key*2;

            int count_key = map.get(key);
            if (map.containsKey(more)) {
                int count_more = map.get(more);
                map.put(more, (count_more<=count_key)?0:(count_more - count_key));
                map.put(key, (count_key<=count_more)?0:(count_key - count_more));                
            }

            if (key%2 == 0) {
                int less = key/2;
                count_key = map.get(key);
                if (map.containsKey(less)) {
                    int count_less = map.get(less);
                    map.put(less, (count_less<=count_key)?0:(count_less - count_key));
                    map.put(key, (count_key<=count_less)?0:(count_key - count_less));
                }
            }

            //System.out.println("key = "+key+", map = "+map);
        }

        System.out.println("map = "+map);
        
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                if (key == 0 && map.get(key)%2 == 0) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
