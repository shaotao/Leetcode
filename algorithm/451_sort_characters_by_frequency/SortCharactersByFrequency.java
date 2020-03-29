import java.io.*;
import java.util.*;


class SortCharactersByFrequency
{
    public static void main(String[] args)
    {
        System.out.println("=== Sort Characters By Frequency ===");
        Solution solution = new Solution();
        String[] input = {"tree", "cccaaa", "Aabb"};
        for (String s : input) {
            System.out.println("s = "+s);
            System.out.println("freq sorted = "+solution.frequencySort(s));
        }
    }
}


class Solution
{
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = (map.get(ch)==null)?0:map.get(ch);
            map.put(ch, count+1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
                if (map.get(a) > map.get(b)) { return -1; }
                else if (map.get(a) == map.get(b)) { return 0; }
                else { return 1; }
            });
        //System.out.println("list = "+list);

        StringBuffer buf = new StringBuffer();
        list.forEach(ch -> {
                for (int i = 0; i < map.get(ch); i++) {
                    buf.append(ch);
                }
                return;
            });
        
        return buf.toString();
    }
}
