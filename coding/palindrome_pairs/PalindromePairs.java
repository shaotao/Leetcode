import java.io.*;
import java.util.*;


class PalindromePairs
{
    public static void main(String[] args)
    {
	System.out.println("=== Palindrome Pairs ===");
	Solution solution = new Solution();

        String[][] array_words = {{"bat", "tab", "cat"},
                              {"abcd", "dcba", "lls", "s", "sssll"}};
        for(String[] words: array_words) {
            List<List<Integer>> ret = solution.palindromePairs(words);

            for(List<Integer> pair:ret) {
                System.out.print("("+pair.get(0)+","+pair.get(1)+") ");
            }
            System.out.println();
        }
    }
}


class Solution
{
    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();

        if(words == null) { return ret; }
        
        int num_words = words.length;
        for(int i = 0; i < num_words; i++) {
            for(int j = i+1; j < num_words; j++) {
                String s1 = words[i]+words[j];
                String s2 = words[j]+words[i];

                if(s1.charAt(0) == s1.charAt(s1.length()-1) && isPalindrome(s1)) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i); temp.add(j);
                    ret.add(temp);
                }
                if(s2.charAt(s2.length()-1) == s2.charAt(0) && isPalindrome(s2)) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(j); temp.add(i);
                    ret.add(temp);
                }
            }
        }
        
        return ret;
    }

    private boolean isPalindrome(String s) {
        boolean isPalindrome = true;

        if(s == null) { return false; }

        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                isPalindrome = false;
                break;
            }
        }
        
        return isPalindrome;
    }
}
