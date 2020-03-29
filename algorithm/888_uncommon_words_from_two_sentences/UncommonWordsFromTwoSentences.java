import java.io.*;
import java.util.*;


class UncommonWordsFromTwoSentences
{
    public static void main(String[] args)
    {
        System.out.println("=== Uncommon Words from Two Sentences ===");
        Solution solution = new Solution();
        String[][] input = {{"this apple is sweet", "this apple is sour"},
                            {"apple apple", "banana"}};
        for (String[] pair : input) {
            System.out.println("A = "+pair[0]);
            System.out.println("B = "+pair[1]);
            System.out.println("uncommon ="+Arrays.toString(solution.uncommonFromSentences(pair[0], pair[1])));
        }
    }
}


class Solution
{
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : A.split(" ")) {
            if (word.length() == 0) { continue; }
            int count = 1;
            if (map.containsKey(word)) {
                count += map.get(word);
            }
            map.put(word, count);
        }

        for (String word : B.split(" ")) {
            if (word.length() == 0) { continue; }
            int count = 1;
            if (map.containsKey(word)) {
                count += map.get(word);
            }
            map.put(word, count);
        }

        List<String> list = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
