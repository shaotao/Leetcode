import java.io.*;
import java.util.*;


class RansomNote
{
    public static void main(String[] args)
    {
	System.out.println("=== Ransom Note ===");
	Solution solution = new Solution();

        System.out.println("canConstruct(\"\", \"\") -> "+solution.canConstruct("", ""));
        System.out.println("canConstruct(\"a\", \"b\") -> "+solution.canConstruct("a", "b"));
        System.out.println("canConstruct(\"aa\", \"ab\") -> "+solution.canConstruct("aa", "ab"));
        System.out.println("canConstruct(\"aa\", \"aab\") -> "+solution.canConstruct("aa", "aab"));
    }
}


class Solution
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        HashMap<Character, Integer> map_note = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map_magazine = new HashMap<Character, Integer>();

        if(ransomNote == null || magazine == null) {
            return false;
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(map_note.containsKey(ch)) {
                map_note.put(ch, map_note.get(ch)+1);
            } else {
                map_note.put(ch, 1);
            }
        }

        for(int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if(map_magazine.containsKey(ch)) {
                map_magazine.put(ch, map_magazine.get(ch)+1);
            } else {
                map_magazine.put(ch, 1);
            }
        }
        

        for(Character ch : map_note.keySet()) {
            if(!map_magazine.containsKey(ch) ||
               map_magazine.get(ch) < map_note.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
