import java.io.*;
import java.util.*;


class IsomorphicStrings
{
    public static void main(String[] args) {
        System.out.println("=== Isomorphic Strings ===");
        Solution solution = new Solution();
        String[] input = {"egg", "add",
                          "foo", "bar",
                          "ab", "aa",
                          "paper", "title"};
        for(int i = 0; i < input.length; i+=2) {
            String s = input[i];
            String t = input[i+1];
            boolean ret = solution.isIsomorphic(s, t);
            System.out.println("s = \""+s+"\", t = \""+t+"\", isIsomorphic: "+ret);
        }
    }
}


class Solution
{
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);
            if (map1.containsKey(s_ch) && map1.get(s_ch) != t_ch) {
                return false;
            } else {
                map1.put(s_ch, t_ch);
            }

            if (map2.containsKey(t_ch) && map2.get(t_ch) != s_ch) {
                return false;
            } else {
                map2.put(t_ch, s_ch);
            }
        }
        
        return true;
    }
}
