import java.io.*;
import java.util.*;


class VerifyingAnAlienDictionary
{
    public static void main(String[] args)
    {
        System.out.println("=== Verifying An Alien Dictionary ===");
        Solution solution = new Solution();

        String[][] input = {
            {"hello", "leetcode"},
            {"word", "world", "row"},
            {"apple", "app"}
        };
        String[] orderArray = {
            "hlabcdefgijkmnopqrstuvwxyz",
            "worldabcefghijkmnpqstuvxyz",
            "abcdefghijklmnopqrstuvwxyz"
        };
        for (int i = 0; i < input.length; i++) {
            System.out.println("words = "+Arrays.toString(input[i]));
            System.out.println("order = "+orderArray[i]);
            System.out.println("isAlienSorted = "+solution.isAlienSorted(input[i], orderArray[i]));
        }
    }
}


class Solution
{
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        Boolean[] done = new Boolean[words.length];
        for (int i = 0; i < done.length; i++) {
            done[i] = false;
        }
        
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i+1);
        }

        // scan for char at 0, 1, 2 for all words
        for (int i = 0; i < 20; i++) {
            
            for (int j = 1; j < words.length; j++) {
                Integer prev = (words[j-1].length() <= i)?0:map.get(words[j-1].charAt(i));
                Integer curr = (words[j].length() <= i)?0:map.get(words[j].charAt(i));

                if (done[j] == true) {
                    continue;
                }

                //System.out.println("prev = "+prev+", curr = "+curr);
                if (prev < curr) {
                    done[j] = true;
                } else if (prev > curr) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

