import java.io.*;
import java.util.*;


class TopKFrequentElements
{
    public static void main(String[] args)
    {
	System.out.println("=== Top K Frequent Elements ===");
	Solution solution = new Solution();

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        List<Integer> list = solution.topKFrequent(nums, k);
        System.out.println("nums = "+Arrays.toString(nums)+", k = "+k);
        System.out.println("result = "+list);
    }
}


class Solution
{
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();

        if(nums == null || nums.length == 0 || k <= 0) { return list; }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num:nums) {
            if(map.containsKey(num)) { map.put(num, map.get(num)+1); }
            else { map.put(num, 1); }
        }

        // use binary search to insert num to list order by frequency
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            // insert to list using binary search
            int left = 0;
            int right = list.size()-1;
            int idx = 0;
            
            while(left <= right) {
                if(value >= map.get(list.get(left))) {
                    idx = left;
                    break;
                } else if (value <= map.get(list.get(right))) {
                    idx = right+1;
                    break;
                } else {
                    if(right - left == 1) {
                        idx = left+1;
                        break;
                    } else {
                        int mid = (left+right)/2;
                        if(map.get(list.get(mid)) >= value) { left = mid; }
                        else { right = mid; }
                    }
                }
            }

            list.add(idx, key);
        }

        // return the first k elements;
        return list.subList(0, k);
    }
}
