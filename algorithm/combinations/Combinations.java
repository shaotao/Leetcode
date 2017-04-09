import java.io.*;
import java.util.*;


class Combinations
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        //int n = 4;
        //int k = 2;
        int n = 10;
        int k = 5;

        ArrayList<ArrayList<Integer>> result = solution.combine(n, k);

        for(int i = 1; i <= result.size(); i++)
        {
            System.out.println(i+" = "+result.get(i-1));
        }
    }
}

class Solution
{
    public ArrayList<ArrayList<Integer>> combine(int n, int k)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();

        create_list(result, map, list, n, k, 1, null);

        return result;        
    }


    public void create_list(ArrayList<ArrayList<Integer>> result, HashMap<Integer, Integer> map, ArrayList<Integer> list, int n, int k, int idx_digit, Integer bar)
    {

        if(idx_digit > k)
        {
            ArrayList<Integer> copy_list = new ArrayList<Integer>(list);
            result.add(copy_list);
            return;
        }


        for(int i = 1; i <= n; i++)
        {
            if(idx_digit == 1)
            {
                list.clear();;
                map.clear();
            }

            if(map.get(i) != null)
            {
                // this digit is used
                continue;
            }

            if(bar != null && i < bar)
            {
                continue;
            }

            int size = list.size();

            list.add(i);
            map.put(i, i);

            create_list(result, map, list,  n, k, idx_digit+1, i);

            list.remove(size);
            map.remove(i);
        }
    }
}


