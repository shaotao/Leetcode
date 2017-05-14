import java.io.*;
import java.util.*;


class RepeatedDNASequences
{
    public static void main(String[] args)
    {
        System.out.println("=== Repeated DNA Sequences ===");
        Solution solution = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> list = solution.findRepeatedDnaSequences(s);
        System.out.println("input: "+s);
        System.out.print("output: ");
        for(String output:list)
        {
            System.out.print(output+", ");
        }
        System.out.println();
    }
}

class Solution
{
    // use a simple way to reduce memory and time cost
    public List<String> findRepeatedDnaSequences(String s)
    {
        ArrayList<String> list = new ArrayList<String>();
        
        return list;
    }

    // use a hash to map substring to idx
    public List<String> findRepeatedDnaSequences3(String s)
    {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

        if(s == null || s.length() < 20)
        {
            return list;
        }
        
        for(int i = 0; i <= s.length()-10; i++)
        {
            String sub = s.substring(i, i+10);
            if(map.containsKey(sub)) {
                map.get(sub).add(new Integer(i));
            } else {
                ArrayList<Integer> new_list = new ArrayList<Integer>();
                new_list.add(new Integer(i));
                map.put(sub, new_list);
            }
        }
        
        for(String key : map.keySet())
        {
            ArrayList<Integer> idxList = map.get(key);
            int size = idxList.size();
            if (idxList.get(size-1) - idxList.get(0) >= 10){
                list.add(key);
            }
        }

        return list;
    }

    // the naive solution, O(n^2)
    public List<String> findRepeatedDnaSequences2(String s)
    {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        if(s == null || s.length() < 20)
        {
            return list;
        }

        for(int i = 0; i <= s.length()-20; i++)
        {
            for(int j = i+10; j <= s.length()-10; j++)
            {
                boolean match = true;
                for(int k = 0; k < 10; k++)
                {
                    if(s.charAt(i+k) != s.charAt(j+k))
                    {
                        match = false;
                        break;
                    }
                }
                if(match == true)
                {
                    System.out.println("i = "+i+", j = "+j);
                    map.put(s.substring(i, i+10), new Integer(1));
                    break;
                }
            }
        }

        // put keys in map to list
        for(String key:map.keySet())
        {
            list.add(key);
        }

        return list;
    }
}
