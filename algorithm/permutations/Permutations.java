import java.io.*;
import java.util.*;


class Permutations
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int n = 5;
        int[] num = new int[n];

        for(int i = 0; i < n; i++)
        {
            num[i] = i+1;
        }

        ArrayList<ArrayList<Integer>> result = solution.permutate(num);

        for(int i = 1; i <= result.size(); i++)
        {
            System.out.println(i+" = "+result.get(i-1));
        }
    }
}

class Solution
{
    public ArrayList<ArrayList<Integer>> permute(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();

        create_list(result, map, list, num, 1);

        return result;        
    }


    public void create_list(ArrayList<ArrayList<Integer>> result, HashMap<Integer, Integer> map, ArrayList<Integer> list, int[] num, int idx_digit)
    {

        if(idx_digit > num.length)
        {
            ArrayList<Integer> copy_list = new ArrayList<Integer>(list);
            result.add(copy_list);
            return;
        }


        for(int i = 0; i < num.length; i++)
        {
            int val = num[i];

            if(idx_digit == 1)
            {
                list.clear();
                map.clear();
            }

            if(map.get(val) != null)
            {
                // this digit is used
                continue;
            }

            int size = list.size();

            list.add(val);
            map.put(val, val);

            create_list(result, map, list,  num, idx_digit+1);

            list.remove(size);
            map.remove(val);
        }
    }
}


