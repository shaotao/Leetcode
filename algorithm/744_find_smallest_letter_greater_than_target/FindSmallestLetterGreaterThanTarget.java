import java.io.*;
import java.util.*;


class FindSmallestLetterGreaterThanTarget
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Smallest Letter Greater Than Target ===");
        Solution solution = new Solution();

        char[] letters = {'c', 'f', 'j'};
        char[] targets = {'a', 'c', 'd', 'g', 'j', 'k'};

        for(char target : targets) {
            System.out.println("letters = "+Arrays.toString(letters));
            System.out.println("target = "+target);
            System.out.println("next greater letter = "+solution.nextGreaterLetter(letters, target));
        }
    }
}


class Solution
{
    public char nextGreaterLetter(char[] letters, char target) {
        Map<Integer, Character> map = new HashMap<>();
        for (char letter : letters) {
            map.put((int)letter, letter);
        }

        int start = (int) target;
        System.out.println("start = "+start);
        for (int i = 1; i <= 26; i++) {
            int idx = start+i;
            if(idx > 122) { idx = 97 + (idx-122-1); }
            if (map.get(idx) != null) {
                return map.get(idx);
            }
        }
        
        return '\0';
    }
}
