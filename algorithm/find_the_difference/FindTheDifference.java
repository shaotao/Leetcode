import java.io.*;
import java.util.*;


class FindTheDifference
{
    public static void main(String[] args)
    {
	System.out.println("=== Find the Difference ===");
	Solution solution = new Solution();

        String s = "abcd";
        String t = "abcde";
        char ch = solution.findTheDifference(s, t);

        System.out.println("s = "+s+", t = "+t+", diff = "+ch);
    }
}


class Solution
{
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map_s = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map_t = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map_s.containsKey(ch)) {
                map_s.put(ch, 1);
            } else {
                map_s.put(ch, map_s.get(ch)+1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!map_t.containsKey(ch)) {
                map_t.put(ch, 1);
            } else {
                map_t.put(ch, map_t.get(ch)+1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map_s.get(ch) != map_t.get(ch)) {
                return ch;
            }
        }
        
        return 0;
    }
}
