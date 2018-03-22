import java.io.*;
import java.util.*;


class RotateString
{
    public static void main(String[] args)
    {
        System.out.println("=== Rotate String ===");
        Solution solution = new Solution();
        String[][] pairs = {{"abcde", "cdeab"},
                            {"abcde", "abced"}};
        for (String[] pair : pairs) {
            String A = pair[0];
            String B = pair[1];
            System.out.println("A="+A+", B="+B+", rorate="+solution.rotateString(A,B));
        }
    }
}


class Solution
{
    public boolean rotateString(String A, String B) {
        if((A == null && B == null) || (A.length() == 0 && B.length()==0)) {
            return true;
        } else if (A == null && B != null) {
            return false;
        } else if (A != null && B == null) {
            return false;
        } else if (A.length() != B.length()) {
            return false;
        }

        char[] a_array = A.toCharArray();
        char[] b_array = B.toCharArray();
        for (int i = 0; i < b_array.length; i++) {
            boolean match = true;
            for(int j = 0; j < b_array.length; j++) {
                if(a_array[j] != b_array[(i+j)%b_array.length]) {
                    match = false;
                    break;
                }
            }
            if(match) { return true;}
        }
        return false;
    }
}
