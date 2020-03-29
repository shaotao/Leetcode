import java.io.*;
import java.util.*;


class FirstUniqueCharacterInAString
{
    public static void main(String[] args)
    {
	System.out.println("=== First Unique Character in a String ===");
	Solution solution = new Solution();

        String[] inputs = {"leetcode",
                           "loveleetcode"};
        for(String s:inputs) {
            System.out.println("s = \""+s+"\", pos = "+solution.firstUniqChar(s));
        }
    }
}


class Solution
{
    public int firstUniqChar(String s) {
        int ret = -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) {
                ret = i;
                break;
            }
        }

        return ret;
    }
}
