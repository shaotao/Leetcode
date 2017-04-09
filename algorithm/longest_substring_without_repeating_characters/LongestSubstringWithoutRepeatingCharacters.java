import java.io.*;
import java.util.*;


class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Substring without Repeating Characters ===");
        Solution solution = new Solution();
        //String s = "abcabcbb";
        String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        System.out.println("s = \""+s+"\"");
        System.out.println("result = "+result);
    }
}


class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int result = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= s.length()-1; i++)
        {
            int j = 0;
            int end_idx = (i>0) ? list.get(i-1) : -1;
            
            for(j = i-1; j > end_idx; j--)
            {
                //System.out.println("i = "+i+", j = "+j+", char_i = "+s.charAt(i)+", char_j = "+s.charAt(j));

                if(s.charAt(i) == s.charAt(j))
                {
                    break;
                }
            }
            
            list.add(j);

            int len = i - j;
            //System.out.println("i = "+i+", j = "+j+", len = "+len);
            if(result == 0 || len > result)
            {
                result = len;
                //System.out.println("i = "+i+", j = "+j);
            }
        }
        
        return result;
    }
}
