import java.io.*;
import java.util.*;
import java.util.stream.*;


class ShortestCompletingWord
{
    public static void main(String[] args)
    {
        System.out.println("=== Shortest Completing Word ===");
        Solution solution = new Solution();
        String[] licensePlateArray = {"1s3 PSt", "1s3 456"};
        String[][] wordsArray = {{"step", "steps", "stripe", "stepple"},
                                 {"looks", "pest", "stew", "show"}};
        for (int i = 0; i < licensePlateArray.length; i++) {
            String licensePlate = licensePlateArray[i];
            String[] words = wordsArray[i];
            String shortest = solution.shortestCompletingWord(licensePlate, words);
            System.out.println("licensePlate = "+licensePlate);
            System.out.println("words = "+Arrays.toString(words));
            System.out.println("shortest = "+shortest);
        }
    }
}


class Solution
{
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // sort the words by length
        List<String> dict = new ArrayList<>();
        for (String word : words) {
            dict.add(word);
        }
        dict.sort((a,b) -> {
                if (a.length() < b.length()) { return -1; }
                else if (a.length() == b.length()) { return 0; }
                else { return 1; }
            });

        Map<Character, Integer> target = toBitMap(licensePlate.toLowerCase());
        //System.out.println("target = "+target);
        List<Map<Character, Integer>> bits = dict.stream().map(w -> toBitMap(w)).collect(Collectors.toList());
        for (int i = 0; i < bits.size(); i++) {
            Map<Character, Integer> bitmap = bits.get(i);
            //System.out.println("bitmap = "+bitmap);
            if(superSet(bitmap, target)) {
                return dict.get(i);
            }
        }
        return null;
    }

    private boolean superSet(Map<Character, Integer> bitmap, Map<Character, Integer> target) {
        for(Character ch : target.keySet()) {
            if (bitmap.get(ch) == null || bitmap.get(ch) < target.get(ch)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> toBitMap(String w) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : w.toCharArray()) {
            if (ch < 'a' || ch > 'z') { continue; }
            int count = 1;
            if (map.containsKey(ch)) {
                count += map.get(ch);
            }
            map.put(ch, count);
        }

        return map;
    }
}
