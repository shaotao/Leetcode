import java.io.*;
import java.util.*;


class PartitionLabels
{
    public static void main(String[] args)
    {
        System.out.println("=== Partition Labels ===");
        Solution solution = new Solution();
        String S = "ababcbacadefegdehijhklij";
        System.out.println("S = "+S);
        System.out.println("output = "+solution.partitionLabels(S));
    }
}


class Solution
{
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!leftMap.containsKey(ch)) {
                leftMap.put(ch, i);
            }
        }
        for (int i = S.length()-1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (!rightMap.containsKey(ch)) {
                rightMap.put(ch, i);
            }
        }

        int prevRight = -1;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);            
            int currLeft = leftMap.get(ch);
            int currRight = rightMap.get(ch);

            if (currLeft == i && prevRight < i) {
                if (count > 0) { list.add(count); }
                count = 1;
            } else {
                count++;
            }

            prevRight = (prevRight>=currRight)?prevRight:currRight;
        }

        if (count > 0) { list.add(count); }

        return list;
    }
}
