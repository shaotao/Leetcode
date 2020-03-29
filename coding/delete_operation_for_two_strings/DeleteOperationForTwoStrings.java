import java.io.*;
import java.util.*;


class DeleteOperationForTwoStrings
{
    public static void main(String[] args)
    {
	System.out.println("=== Delete Operation for Two Strings ===");
	Solution solution = new Solution();

        String word1 = "sea";
        String word2 = "ate";
        System.out.println("word1 = "+word1+", word2 = "+word2+", min distance = "+solution.minDistance(word1, word2));
    }
}


class Solution
{
    public int minDistance(String word1, String word2) {
        int ret = 0;

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for(char ch : word1.toCharArray()) {
            array1[ch-'a']++;
        }

        for(char ch : word2.toCharArray()) {
            array2[ch-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            ret += (int)Math.abs(array1[i] - array2[i]);
        }
        
        return ret;
    }
}
