import java.io.*;
import java.util.*;


class CardFlippingGame
{
    public static void main(String[] args)
    {
        System.out.println("=== Card Flipping Game ===");
        Solution solution = new Solution();
        int[] fronts = {1,2,4,4,7};
        int[] backs = {1,3,4,1,3};
        int ret = solution.flipgame(fronts, backs);
        System.out.println("fronts = "+Arrays.toString(fronts));
        System.out.println("backs = "+Arrays.toString(backs));
        System.out.println("smallest good number = "+solution.flipgame(fronts, backs));
    }
}


class Solution
{
    public int flipgame(int[] fronts, int[] backs) {
        int ret = 0;

        Set<Integer> avoid = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                avoid.add(fronts[i]);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int front :fronts) { set.add(front); }
        for (int back : backs) { set.add(back); }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int val : list) {
            if (!avoid.contains(val)) {
                ret = val;
                break;
            }
        }
        
        return ret;
    }
}
