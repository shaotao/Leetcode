import java.io.*;
import java.util.*;


class KeyboardRow
{
    public static void main(String[] args)
    {
	System.out.println("=== Keyboard Row ===");
	Solution solution = new Solution();

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] ret = solution.findWords(words);

        System.out.println("input = "+Arrays.toString(words));
        System.out.println("output = "+Arrays.toString(ret));
    }
}


class Solution
{
    private static final char[] array1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                                          'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    private static final char[] array2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                                          'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
    private static final char[] array3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm',
                                          'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        for(int i = 0; i < array1.length; i++) { map.put(array1[i], 1); }
        for(int i = 0; i < array2.length; i++) { map.put(array2[i], 2); }
        for(int i = 0; i < array3.length; i++) { map.put(array3[i], 3); }
    }
    
    public String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<String>();

        for(String word : words) {
            if(words.length == 0) { continue; }
            int row = 0;
            boolean good = true;
            for(int i = 0; i < word.length(); i++) {
                if(i == 0) { row = map.get(word.charAt(i)); }
                else {
                    if(row != map.get(word.charAt(i))) {
                        good = false; break;
                    }
                }
            }

            if(good) { list.add(word); }
        }

        String[] ret = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
}
