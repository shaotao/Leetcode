import java.io.*;
import java.util.*;


class UniqueMorseCodeWords
{
    public static void main(String[] args)
    {
        System.out.println("=== Unique Morse Code Words ===");
        Solution solution = new Solution();
        String[] words = {"gin", "zen", "gig", "msg"}; 
        System.out.println("words = "+Arrays.toString(words));
        System.out.println("number of morse transformations = "+solution.uniqueMorseRepresentations(words));
    }
}


class Solution
{
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            set.add(toMorse(word));
        }
        return set.size();
    }

    public String toMorse(String word) {
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuffer buf = new StringBuffer();
        for (char ch : word.toCharArray()) {
            int idx = (int)ch - (int)'a';
            buf.append(table[idx]);
        }

        return buf.toString();
    }
}
