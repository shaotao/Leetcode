import java.io.*;
import java.util.*;


class ReverseVowelsOfAString
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Vowels of a String ===");
	Solution solution = new Solution();
        String s = "hello";

        System.out.println("s = "+s+", reverseVowels(s) = "+solution.reverseVowels(s));
    }
}


class Solution
{
    public String reverseVowels(String s) {
        if(s == null) { return null; }

        StringBuffer buf = new StringBuffer(s);
        ArrayList<Integer> idx_list = new ArrayList<Integer>();
        ArrayList<Character> char_list = new ArrayList<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == 'a' || a== 'e' || a=='i' || a=='o' || a=='u'||
               a == 'A' || a=='E' || a=='I' || a=='O'|| a=='U') {
                idx_list.add(i);
                char_list.add(a);
            }
        }

        int size = idx_list.size();
        for(int i = 0; i < size; i++) {
            buf.setCharAt(idx_list.get(i), char_list.get(size-1-i));
        }

        return buf.toString();
    }
}
