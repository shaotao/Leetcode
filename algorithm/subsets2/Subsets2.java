import java.io.*;
import java.util.*;


class Subsets2
{
    public static void main(String[] args)
    {
        System.out.println("=== Subsets II ===");
        Solution solution = new Solution();
        int[] num = {1,2,2};
                
        ArrayList<ArrayList<Integer>> result = solution.subsetsWithDup(num);
        
        System.out.print("num: ");
        print_array(num);

        System.out.println(result.size()+" results:");
        print_result(result);
    }

    public static void print_array(int[] num)
    {
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }

    public static void print_result(ArrayList<ArrayList<Integer>> result)
    {
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print((i+1)+") [");
            for(int j = 0; j < result.get(i).size(); j++)
            {
                System.out.print(result.get(i).get(j));
                if(j != result.get(i).size()-1)
                {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }        
    }
}


class Solution
{
    public void print_map(HashMap<Integer, Integer> map)
    {
        Iterator<Integer> iter = map.keySet().iterator();
        
        System.out.println("map:");
        while(iter.hasNext())
        {
            int key = iter.next();
            int val = map.get(key);
            System.out.println(key+" -> "+val);
        }
    }
    
    public void sort_list(ArrayList<Integer> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i+1; j < list.size(); j++)
            {
                int item_i = list.get(i);
                int item_j = list.get(j);
                
                if(item_i > item_j)
                {
                    list.remove(i);
                    list.add(i, item_j);
                    list.remove(j);
                    list.add(j, item_i);
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        // get the map of the num
        ArrayList<Integer> key_list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++)
        {
            int key = num[i];
            if(map.containsKey(key))
            {
                int val = map.get(key);
                map.put(key, val+1);
            }
            else
            {
                map.put(key, 1);
                key_list.add(key);
            }
        }        

        // >> debug here
        //print_map(map);
        // << debug here

        sort_list(key_list);

        ArrayList<Integer> temp = new ArrayList<Integer>();
        find_set(result, temp, key_list, map);

        return result;
    }
    
    public void find_set(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> key_list, HashMap<Integer, Integer> map)
    {
        if(key_list.size() == 0)
        {
            ArrayList<Integer> new_list = new ArrayList<Integer>(temp);
            result.add(new_list);
            
            return;
        }

        // find the first key
        int key = key_list.get(0);
        key_list.remove(0);
        for(int count = 0; count <= map.get(key); count++)
        {
            for(int i = 0; i < count; i++) { temp.add(key); }
            
            find_set(result, temp, key_list, map);
            
            temp.subList(temp.size()-count, temp.size()).clear();
        }
        
        key_list.add(0, key);
    }
}
