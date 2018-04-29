import java.io.*;
import java.util.*;


class GoatLatin
{
    public static void main(String[] args)
    {
        System.out.println("=== Goat Latin ===");
        Solution solution = new Solution();
        String[] input = {"I speak Goat Latin", "The quick brown fox jumped over the lazy dog"};

        for (String S : input) {
            System.out.println("S = "+S);
            System.out.println("Goat Latin = "+solution.toGoatLatin(S));
        }
    }
}


class Solution
{
    private static final HashSet<String> set = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));
    
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String[] items = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String head = words[i].substring(0, 1);
            StringBuffer buf = new StringBuffer();
            if ( set.contains(head)) {
                buf.append(words[i]);
            } else {
                buf.append(words[i].substring(1));
                buf.append(head);
            }
            buf.append("ma");

            // append a+
            for(int j = 0; j < i+1; j++) {
                buf.append("a");
            }

            items[i] = buf.toString();
        }

        return String.join(" ", items);
    }
}
