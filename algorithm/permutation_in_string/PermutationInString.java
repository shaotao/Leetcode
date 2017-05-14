import java.io.*;
import java.util.*;


class PermutationInString
{
    public static void main(String[] args)
    {
	System.out.println("=== Permutation in String ===");
	Solution solution = new Solution();

        //String s1 = "ab";
        //String s2 = "eidbaooo";

        String s1 = "a";
        String s2 = "ab";
        
        System.out.println("s1 = \""+s1+"\"");
        System.out.println("s2 = \""+s2+"\"");
        System.out.println("s1 included in s2 = "+solution.checkInclusion(s1,s2));
    }
}


class Solution
{
    public boolean checkInclusion(String s1, String s2) {
        boolean ret = false;
        if( s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0
            || s1.length() > s2.length() ) {
            return false;
        }

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        int size = s1.length();
        for(char ch : s1.toCharArray()) {
            array1[ch-'a']++;
        }

        for(int i = 0; i < size; i++) {
            array2[s2.charAt(i)-'a']++ ;
        }

        for(int right = size-1; right < s2.length(); right++) {
            int left = right - (size-1);
            char l = s2.charAt(left);
            char r = s2.charAt(right);

            if(left > 0) {
                array2[s2.charAt(left-1)-'a']--;
                array2[r-'a']++;
            }

            //System.out.println("array2 = "+Arrays.toString(array2));
            
            if(Arrays.equals(array1, array2)) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}
