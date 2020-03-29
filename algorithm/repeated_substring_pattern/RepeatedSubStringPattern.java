import java.io.*;
import java.util.*;


class RepeatedSubstringPattern
{
    public static void main(String[] args)
    {
	System.out.println("=== Repeated Substring Pattern ===");
	Solution solution = new Solution();
        String[] inputs = {"abab",
                           "aba",
                           "abcabcabcabc",
                           "babbbbaabb"};

        for(String input: inputs) {
            System.out.println("repeat "+input+": "+solution.repeatedSubstringPattern(input));
        }
    }
}


class Solution
{
    public boolean repeatedSubstringPattern(String str) {

        if(str == null || str.length() < 2) { return false; }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // try to find repeat number
        for(char ch: str.toCharArray()) {
            int count = 1;
            if(map.containsKey(ch)) {
                count += map.get(ch);
            }
            map.put(ch, count);
        }

        int min_num = -1;
        for(Character ch: map.keySet()) {
            int count = map.get(ch);
            if(min_num == -1 || min_num > count) {
                min_num = count;
            }
        }
        
        // repeat can be 1 ~ min_num, check for each case
        for(int repeat = min_num; repeat >= 2; repeat--) {
            if(str.length() % repeat != 0) { continue; }
            int len = str.length()/repeat;
            
            boolean success = true;
            for(int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                for(int j = 0; j < repeat; j++) {
                    if(str.charAt(j*len + i) != ch) {
                        success = false;
                        break;
                    }
                }

                if(!success) {
                    break;
                }
            }

            if(success) { return true; }
        }
        
        return false;
    }
}
