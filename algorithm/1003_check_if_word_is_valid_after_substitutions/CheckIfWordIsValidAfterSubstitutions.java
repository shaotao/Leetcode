import java.io.*;
import java.util.*;


class CheckIfWordIsValidAfterSubstitutions
{
    public static void main(String[] args)
    {
        System.out.println("=== Check If Word is Valid After Substitutions ===");
        Solution solution = new Solution();
        String[] input = {"aabcbc", "abcabcababcc", "abccba", "cababc", "aabcbcabc"};
        for (String S : input) {
            System.out.println("S = "+S);
            System.out.println("isValid = "+solution.isValid(S));
        }
    }
}


class Solution
{
    public boolean isValid(String S) {
        boolean ret = false;
        if (S != null && S.length() <= 3) {
            if (S.equals("abc")) {
                return true;
            } else {
                return false;
            }
        }

        int idx = S.indexOf("abc");
        if (idx < 0) {
            return false;
        }

        //System.out.println("idx = "+idx);
        //System.out.println("S.length() = "+S.length());

        String a = S.substring(0, idx);
        String b = (idx+3 < S.length())?S.substring(idx+3, S.length()):"";

        //System.out.println("a+b="+a+b);
        
        return isValid(a+b);
    }
}
