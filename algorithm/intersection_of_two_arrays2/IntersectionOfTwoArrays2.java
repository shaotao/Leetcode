import java.io.*;
import java.util.*;


class IntersectionOfTwoArrays2
{
    public static void main(String[] args)
    {
	System.out.println("=== Intersection of Two Arrays II ===");
	Solution solution = new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] ret = solution.intersection(nums1, nums2);
        System.out.println("nums1 = "+Arrays.toString(nums1));
        System.out.println("nums2 = "+Arrays.toString(nums2));
        System.out.println("intersection = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int n:nums1) {
            if(!map1.containsKey(n)) {
                map1.put(n, 1);
            } else {
                map1.put(n, map1.get(n)+1);
            }
        }

        for(int n:nums2) {
            if(!map2.containsKey(n)) {
                map2.put(n, 1);
            } else {
                map2.put(n, map2.get(n)+1);
            }
        }

        for(Integer i:map1.keySet()) {
            if(map2.containsKey(i)) {
                int n = map1.get(i);
                if(n > map2.get(i)) { n = map2.get(i); }

                for(int j = 0; j < n; j++) {
                    list.add(i);
                }
            }
        }

        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) { array[i] = list.get(i); }
        return array;
    }
}
