import java.io.*;
import java.util.*;


class WordPattern
{
    public static void main(String[] args)
    {
        System.out.println("=== Word Pattern ===");
        Solution solution = new Solution();

        String[][] input = {{"abba", "dog cat cat dog"},
                            {"abba", "dog cat cat fish"},
                            {"aaaa", "dog cat cat dog"},
                            {"abba", "dog dog dog dog"}};
        for(int i = 0; i < input.length; i++) {
            String pattern = input[i][0];
            String str = input[i][1];

            System.out.println("pattern = "+pattern+", str = \""+str+"\""+": "+solution.wordPattern(pattern, str));
        }
            
    }
}

class Solution
{
    public boolean wordPattern(String pattern, String str)
    {
        if(pattern == null || str == null) { return false; }
        
        int num_chars = pattern.length();

        StringTokenizer stok = new StringTokenizer(str);

        if(num_chars == 0 || stok.countTokens() == 0) { return false; }

        if(num_chars != stok.countTokens()) { return false; }

        String[] items = new String[num_chars];
        for(int i = 0; i < num_chars; i++) {
            items[i] = stok.nextToken();
        }

        for(int i = 0; i < num_chars; i++) {
            for(int j = i+1; j < num_chars; j++) {
                if(pattern.charAt(i) == pattern.charAt(j)) {
                    if(!items[i].equals(items[j])) { return false; }
                } else {
                    if(items[i].equals(items[j])) { return false; }
                }
            }
        }

        return true;
    }
}
