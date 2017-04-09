import java.io.*;
import java.util.*;


class DetectCapital
{
    public static void main(String[] args)
    {
	System.out.println("=== Detect Capital ===");
	Solution solution = new Solution();

        String[] words = {"USA", "leetcode", "Google", "FlaG"};

        for(String word:words) {
            System.out.println(String.format("word=%s, capital=%s", word, solution.detectCapitalUse(word)));
        }
    }
}


class Solution
{
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) { return false; }

        if(word.equals(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())) {
            return true;
        }
        
        return (word.equals(word.toUpperCase()) ||
                word.equals(word.toLowerCase()));
    }
}
