import java.io.*;
import java.util.*;


class FindAllAnagramsInAString
{
    public static void main(String[] args) throws Exception
    {
	System.out.println("=== Find All Anagrams in a String ===");
	Solution solution = new Solution();

        //String[] inputs = {"cbaebabacd", "abc",
        //                   "abab", "ab"};
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = null;
        String[] inputs = new String[2];
        int j = 0;
        while((line = reader.readLine()) != null) {
            inputs[j] = line;
            j++;
        }
        
        for(int i = 0; i < inputs.length-1; i+=2) {
            String s = inputs[i];
            String p = inputs[i+1];
            //System.out.println("s = "+s+", p = "+p+", anagram pos = "+solution.findAnagrams(s, p));
            System.out.println("anagram pos = "+solution.findAnagrams(s, p));
        }
    }
}


class Solution
{
    private HashMap<Character, Integer> stringToMap(String s)
    {
        if(s == null) { return null; }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()) {
            int count = 1;
            if(map.containsKey(ch)) {
                count += map.get(ch);
            }
            map.put(ch, count);
        }

        return map;
    }

    private boolean mapMatch(HashMap<Character, Integer> map1,
                             HashMap<Character, Integer> map2)
    {
        if(map1 == null || map2 == null) { return false; }
        if(map1.size() != map2.size()) { return false;}

        for(Character ch : map1.keySet()) {
            if(map2.get(ch) == null) { return false; }
            if(map1.get(ch).intValue() != map2.get(ch).intValue()) { return false; }
        }

        return true;
    }

    private HashMap<Character, Integer> mapAdd(HashMap<Character, Integer> map, char ch)
    {
        int count = 1;
        if(map.containsKey(ch)) {
            count += map.get(ch);
        }

        map.put(ch, count);

        return map;
    }

    private HashMap<Character, Integer> mapDelete(HashMap<Character, Integer> map, char ch)
    {
        if(!map.containsKey(ch)) { return map; }
        int count = map.get(ch);
        if(count <= 1) {
            map.remove(ch);
        } else {
            map.put(ch, count-1);
        }

        return map;
    }
    
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> list = new ArrayList<Integer>();

        int slen = s.length();
        int plen = p.length();
        int last_idx = slen - plen;
        HashMap<Character, Integer> map_p = stringToMap(p);
        HashMap<Character, Integer> map_s = null;
        for(int i = 0; i <= last_idx; i++) {
            if(i == 0) {
                map_s = stringToMap(s.substring(0, plen));
            } else {
                map_s = mapDelete(map_s, s.charAt(i-1));
                map_s = mapAdd(map_s, s.charAt(i+plen-1));
            }

            if(mapMatch(map_s, map_p)) { list.add(i); }
        }
        
        return list;
    }
}
