import java.io.*;
import java.util.*;


class ShiftingLetters
{
    public static void main(String[] args)
    {
        System.out.println("=== Shifting Letters ===");
        Solution solution = new Solution();
        String S = "abc";
        int[] shifts = {3,5,9};
        System.out.println("S = "+S);
        System.out.println("shifts = "+Arrays.toString(shifts));
        System.out.println("ret = "+solution.shiftingLetters(S, shifts));
    }
}


class Solution
{
    private static final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < letters.length; i++) {
            map.put(letters[i], i);
        }
    }
    
    
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();

        if (shifts.length > 0) {
            shifts[shifts.length-1] = shifts[shifts.length-1]%letters.length;
        }
        for (int i = shifts.length-2; i >= 0; i--) {
            shifts[i] += shifts[i+1];
            shifts[i] = shifts[i]%letters.length;
        }
        
        for (int i = 0; i < chars.length; i++) {
            int moves = 0;
            chars[i] = letters[(map.get(chars[i]) + shifts[i])%letters.length];
        }
        
        return new String(chars);
    }
}
