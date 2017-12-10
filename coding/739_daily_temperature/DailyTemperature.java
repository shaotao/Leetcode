import java.io.*;
import java.util.*;


class DailyTemperature
{
    public static void main(String[] args)
    {
        System.out.println("=== Daily Temperature ===");
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("temperatures = "+Arrays.toString(temperatures));
        System.out.println("higher = "+Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}


class Solution
{
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int t = 30; t <= 100; t++) {
            map.put(t, new ArrayList<Integer>());
        }

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            List<Integer> list = map.get(t);
            list.add(i);
        }

        //System.out.println("map = "+map);

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            for (int j = t+1; j <= 100; j++) {
                List<Integer> list = map.get(j);
                for (int idx : list) {
                    if(idx > i && (ret[i] == 0 || (idx-i) < ret[i])) {
                        ret[i] = idx-i;
                        break;
                    }
                }
            }
        }
        
        return ret;
    }
}
