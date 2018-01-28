import java.io.*;
import java.util.*;


class ReorganizeString
{
    public static void main(String[] args)
    {
        System.out.println("=== Reorganize String ===");
        Solution solution = new Solution();
        String[] input = {"aab", "aaab", "vvvlo"};
        for(String S: input) {
            System.out.println("S = "+S);
            System.out.println("output = "+solution.reorganizeString(S));
        }
    }
}


class Solution
{
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        // if count >= threshold, can reorganize string
        int threshold = (S.length()%2 == 0)?(S.length()/2+1):(S.length()/2 +2);
        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int count = 1;
            if(map.containsKey(ch)) {
                count += map.get(ch);
            }
            map.put(ch, count);
            if(count >= threshold) {
                return "";
            }
        }

        // it is possible, create a sample string
        List<Character> chars = new ArrayList<Character>(map.keySet());
        StringBuffer buf = new StringBuffer();
        Character prev = null;

        // find the char not equal to prev and with the max count
        while(buf.length() < S.length()) {
            int max = -1;
            Character maxCh = null;
            for (Character ch : chars) {
                if (ch == prev) { continue; }
                if( map.get(ch) > 0 && max < map.get(ch)) {
                    max = map.get(ch);
                    maxCh = ch;
                }
            }
            if(max > 0) {
                prev = maxCh;
                map.put(maxCh, map.get(maxCh)-1);
                buf.append(maxCh);
            }
        }

        return buf.toString();
    }
}
