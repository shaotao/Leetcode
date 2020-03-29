import java.io.*;
import java.util.*;


class MaximumProductOfWordLengths
{
    public static void main(String[] args)
    {
        System.out.println("=== Maximum Product Of Word Lengths ===");
        Solution solution = new Solution();

        String[][] inputs = {{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"},
                                               {"a", "ab", "abc", "d", "cd", "bcd", "abcd"},
                                               {"a", "aa", "aaa", "aaaa"}};

        for(String[] input: inputs) {
            System.out.println("input: "+Arrays.toString(input));
            System.out.println("output: "+solution.maxProduct(input));
        }
    }
}


class Solution
{
    public int maxProduct(String[] words)
    {
        if(words == null || words.length == 0) { return 0; }

        int size = words.length;
        int[] ids = new int[size];

        // create map id of each word
        // 26-bit a-z
        for(int i = 0; i < size; i++) {
            int id = 0;
            String word = words[i];
            for(int idx_ch = 0; idx_ch < word.length(); idx_ch++) {
                char ch = word.charAt(idx_ch);
                int offset = ((int)ch) - ((int)'a');
                id |= (1<<offset);
            }
            ids[i] = id;
        }

        int max = 0;
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if((ids[i] & ids[j]) > 0) { continue; }
                int num = words[i].length() * words[j].length();
                max = ((max>=num)?max:num);
            }
        }
            
        return max;
    }
}
