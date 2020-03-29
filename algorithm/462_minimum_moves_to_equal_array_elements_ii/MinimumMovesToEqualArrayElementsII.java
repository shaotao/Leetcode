import java.io.*;
import java.util.*;
import java.util.stream.*;

class MinimumMovesToEqualArrayElementsII
{
    public static void main(String[] args)
    {
        System.out.println("=== Minimum Moves to Equal Array Elelemnts II ===");
        Solution solution = new Solution();
        //int[] nums = {1,2,3};
        int[] nums = {203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("min moves = "+solution.minMoves2(nums));
    }
}


class Solution
{
    public int minMoves2(int[] nums) {
        long ret = 0;
        if (nums == null || nums.length == 0) { return 0; }
        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;
        int prev = nums[0];
        for (int i : nums) {
            if(count == 0 || i == prev) {
                count++;
            } else {
                countMap.put(prev, count);
                count = 1;
                prev = i;
            }
        }

        if(count > 0) {
            countMap.put(prev, count);
        }

        List<Integer> keys = new ArrayList<>(countMap.keySet());
        Collections.sort(keys);
        //System.out.println("keys = "+keys);

        long total = 0;
        
        for (int i = 1; i < keys.size(); i++) {
            total += (countMap.get(keys.get(i))*(keys.get(i)-keys.get(0)));
        }
        ret = total;
        
        int left = 0;
        for (int i = 1; i < keys.size(); i++) {
            left += countMap.get(keys.get(i-1));
            total += left * (keys.get(i) - keys.get(i-1));
            total -= (nums.length-left) * (keys.get(i) - keys.get(i-1));

            ret = (total < ret)?total:ret;
        }
        
        return (int)ret;
    }
}
