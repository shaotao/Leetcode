import java.io.*;
import java.util.*;


class InsertDeleteGetRandom
{
    public static void main(String[] args)
    {
	System.out.println("=== Insert Delete GetRandom O(1) ===");
	Solution solution = new Solution();

        RandomizedSet randomSet = new RandomizedSet();
        System.out.println("randomSet.insert(1) = "+randomSet.insert(1));
        System.out.println("randomSet.remove(2) = "+randomSet.remove(2));
        System.out.println("randomSet.insert(2) = "+randomSet.insert(2));
        System.out.println("randomSet.getRandom() = "+randomSet.getRandom());
        System.out.println("randomSet.remove(1) = "+randomSet.remove(1));
        System.out.println("randomSet.insert(2) = "+randomSet.insert(1));
        System.out.println("randomSet.getRandom() = "+randomSet.getRandom());
    }
}


class RandomizedSet
{
    private Random rand = null;
    private HashMap<Integer, Integer> map = null;
    private ArrayList<Integer> list = null;
    
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) { return false; }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) { return false; }
        int idx = map.get(val);
        if(list.size() > 1) {
            int lastVal = list.get(list.size()-1);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        list.remove((int)(list.size()-1));
        map.remove(val);
        return true;
    }

    public int getRandom() {
        if(list.size() == 0) { return 0; }
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
