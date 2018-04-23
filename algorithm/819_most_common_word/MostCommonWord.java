import java.io.*;
import java.util.*;


class MostCommonWord
{
    public static void main(String[] args)
    {
        System.out.println("=== Most Common Word ===");
        Solution solution = new Solution();
        //String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        //String[] banned = {"hit"};
        //String paragraph = "Bob. hIt, baLl";
        //String[] banned = {"bob", "hit"};
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = {"abc","abcd","jeff"};
        String most = solution.mostCommonWord(paragraph, banned);
        System.out.println("paragraph = "+paragraph);
        System.out.println("banned = "+Arrays.toString(banned));
        System.out.println("most common word = "+most);
    }
}


class Solution
{
    private static final String[] marks = {"!", "?", "'", ",", ";", "."};
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for (String mark : marks) {
            paragraph = paragraph.replace(mark, "");
        }

        Set<String> set = new HashSet<>();
        for (String ban : banned) {
            set.add(ban);
        }

        String[] words = paragraph.split("\\s+");
        int max = 0;
        String maxWord = null;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word.length() == 0 || set.contains(word)) { continue; }
            int count = 1;
            if (map.containsKey(word)) {
                count += map.get(word);
            }
            map.put(word, count);
            if (count > max) {
                max = count;
                maxWord = word;
            }
        }
        
        System.out.println(map);
        
        return maxWord;
    }
}
