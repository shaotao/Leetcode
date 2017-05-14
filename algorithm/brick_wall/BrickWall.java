import java.io.*;
import java.util.*;


class BrickWall
{
    public static void main(String[] args)
    {
	System.out.println("=== Brick Wall ===");
	Solution solution = new Solution();

        List<List<Integer>> wall = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        List<Integer> l4 = new ArrayList<Integer>();
        List<Integer> l5 = new ArrayList<Integer>();
        List<Integer> l6 = new ArrayList<Integer>();
        wall.add(l1);
        wall.add(l2);
        wall.add(l3);
        wall.add(l4);
        wall.add(l5);
        wall.add(l6);
        l1.add(1); l1.add(2); l1.add(2); l1.add(1);
        l2.add(3); l2.add(1); l2.add(2);
        l3.add(1); l3.add(3); l3.add(2);
        l4.add(2); l4.add(4);
        l5.add(3); l5.add(1); l5.add(2);
        l6.add(1); l6.add(3); l6.add(1); l6.add(1);
        
        System.out.println("wall = "+wall);
        System.out.println("least bricks = "+solution.leastBricks(wall));
    }
}


class Solution
{
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0) { return 0; }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall) {
            int sum = 0;
            for(int i = 0; i < list.size()-1; i++) {
                sum += list.get(i);
                int val = 1;
                if(map.containsKey(sum)) {
                    val += map.get(sum);
                }
                map.put(sum, val);
            }
        }

        int skip = 0;
        for(int value : map.values()) {
            if(skip < value) { skip = value; }
        }

        return (wall.size()-skip);
    }
}
