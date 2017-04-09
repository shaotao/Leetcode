import java.io.*;
import java.util.*;


class RemoveDuplicateLetters
{
    public static void main(String[] args)
    {
        System.out.println("=== Remove Duplicate Letters ===");
        Solution solution = new Solution();
        String[] strs = {"bcabc", "cbacdcbc"};
        for (String str: strs) {
            System.out.println("Given: \""+str+"\", Return: \""+solution.removeDuplicateLetters(str)+"\"");
        }
    }
}


class Solution
{
    public String removeDuplicateLetters(String s)
    {
        StringBuffer ret = new StringBuffer();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        
        int size = s.length();
        for(int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)) {
                map.get(ch).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(ch, list);                
            }
        }

        // scan the map of lists to find the max-head;
        while(map.size() > 0) {
            int min_tail = s.length()-1;
            for(char ch : map.keySet()) {
                // scan the max head, out of all list items
                // pick the char with lowest value
                // append to ret and continue
                ArrayList<Integer> list = map.get(ch);

                int idx = list.get(list.size()-1);
                min_tail = (min_tail>idx)?idx:min_tail;                
            }

            // now we search [0, min_tail], find the left-most min-ch
            char min_ch = s.charAt(min_tail);
            int min_ch_idx = min_tail;

            for(char ch: map.keySet()) {

                if(ch > min_ch) { continue; }
                
                ArrayList<Integer> list = map.get(ch);
                for(int i = list.size()-1; i >= 0; i--) {
                    int idx = list.get(i);
                    if(idx < min_ch_idx) {
                        min_ch = s.charAt(idx);
                        min_ch_idx = idx;
                    }
                }
            }
            
            // and 1) append it to ret, 2) remove entry ch in map
            // 3) remove all entries in all lists that is greater than idx of that ch.
            //System.out.println("min_ch = "+min_ch);
            //System.out.println("min_ch_idx = "+min_ch_idx);
            
            ret.append(min_ch);
            map.remove(min_ch);
            for(char key: map.keySet()) {
                ArrayList<Integer> list = map.get(key);
                for(int i = list.size()-1; i>= 0; i--) {
                    if(list.get(i) <= min_ch_idx) {
                        list.remove((int) i);
                    }
                }
            }
        }
        
        return ret.toString();
    }
}
