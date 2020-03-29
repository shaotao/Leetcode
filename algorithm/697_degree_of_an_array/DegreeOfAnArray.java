import java.io.*;
import java.util.*;


class DegreeOfAnArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Degree of An Array ===");
        Solution solution = new Solution();
        int[][] input= {{1,2,2,3,1},
                        {1,2,2,3,1,4,2}};
        for (int[] nums : input) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("shortest subarray length = "+solution.findShortestSubArray(nums));
        }
    }
}

class Point {
    private int count;
    private int left;
    private int right;

    public Point(int idx) {
        this.count = 1;
        left = idx;
        right = idx;
    }

    public void add(int idx) {
        count++;
        left = (idx<left)?idx:left;
        right = (idx>right)?idx:right;
    }

    public int range() {
        return right - left+1;
    }

    public int count() {
        return count;
    }
}

class Solution
{
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Point> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Point p = map.get(nums[i]);
            if(p == null) {
                p = new Point(i);
                map.put(nums[i], p);
            } else {
                p.add(i);
            }
        }

        int max = 0;
        int range = nums.length;
        for(Integer key : map.keySet()) {
            Point p = map.get(key);
            if(p.count() > max) {
                max = p.count();
                range = p.range();
            } else if (p.count() == max) {
                if(range > p.range()) {
                    range = p.range();
                }
            }
        }

        return range;
    }
}
