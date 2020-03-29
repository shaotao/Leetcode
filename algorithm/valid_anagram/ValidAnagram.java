import java.io.*;
import java.util.*;


class ValidAnagram
{
    public static void main(String[] args)
    {
        System.out.println("=== Valid Anagram ===");
        Solution solution = new Solution();

        String[] strs = {"anagram", "nagaram", "rat", "car"};
        for(int i = 0; i < strs.length/2; i+=1) {
            String s = strs[2*i];
            String t = strs[2*i+1];

            boolean ret = solution.isAnagram(s, t);
            System.out.println("s = "+s+", t = "+t+", isAnagram: "+ret);
        }
    }
}

class Solution
{
    public boolean isAnagram(String s, String t)
    {
        HashMap<Character, Integer> map_s = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map_t = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map_s.containsKey(ch)) {
                map_s.put(ch, map_s.get(ch)+1);
            } else {
                map_s.put(ch, 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map_t.containsKey(ch)) {
                map_t.put(ch, map_t.get(ch)+1);
            } else {
                map_t.put(ch, 1);
            }
        }

        if(map_s.size() != map_t.size()) {
            return false;
        }
        
        for(Character key: map_s.keySet()) {
            if(map_t.containsKey(key) == false ||
               map_t.get(key).intValue() != map_s.get(key).intValue()) {
                return false;
            }
        }

        return true;
    }
}
