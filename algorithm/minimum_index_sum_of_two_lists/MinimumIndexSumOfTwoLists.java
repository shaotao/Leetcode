import java.io.*;
import java.util.*;


class MinimumIndexSumOfTwoLists
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Index Sum of Two Lists ===");
	Solution solution = new Solution();

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] ret = solution.findRestaurant(list1, list2);
        System.out.println("list1 = "+Arrays.toString(list1));
        System.out.println("list2 = "+Arrays.toString(list2));
        System.out.println("min index common = "+Arrays.toString(ret));
    }
}


class Solution
{
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        int i = 0;
        for(String s:list1) {
            map1.put(s, i++);
        }

        for(String s:list2) {
            map2.put(s, i++);
        }

        int min = -1;
        List<String> ret = new ArrayList<String>();
        for(String s:list1) {
            if(!map2.containsKey(s)) { continue; }
            int val = map1.get(s) + map2.get(s);
            if(min==-1 || val < min) {
                min = val;
                ret.clear();
                ret.add(s);
            } else if(val == min) {
                ret.add(s);
            }
        }

        return ret.toArray(new String[0]);
    }
}
