import java.io.*;
import java.util.*;


class SwapAdjacentInLRString
{
    public static void main(String[] args)
    {
        System.out.println("=== Swap Adjacent in LR String ===");
        Solution solution = new Solution();
        //String start = "RXXLRXRXL";
        //String end= "XRLXXRRLX";

        //String start = "XXRXXLXXXX";
        //String end = "XXXXRXXLXX";

        String start = "XLXRRXXRXX";
        String end = "LXXXXXXRRR";
        System.out.println("start = "+start);
        System.out.println("end = "+end);
        System.out.println("can transform = "+solution.canTransform(start, end));
    }
}


class Solution
{
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        int len = s.length;
        if (len != e.length) { return false; }
        int idx = 0;
        while (idx < len) {
            char s_char = s[idx];
            char e_char = e[idx];
            //System.out.println("idx="+idx+", s_char = "+s_char+", e_char = "+e_char);
            if (s_char == e_char) { idx++; continue; }
            if (s_char != 'X' && e_char != 'X' && s_char != e_char) { return false; }
            if (s_char == 'L' && e_char == 'X') {
                return false;
            } else if (s_char == 'X' && e_char == 'L') {
                boolean found = false;
                for (int i = idx+1; i < len; i++) {
                    if(s[i] == 'X') { continue; }
                    else if(s[i] == 'R') { return false; }
                    else { found = true; s[i] = 'X'; break; }
                }
                if (!found) { return false; }
                idx++;
            } else if (s_char == 'X' && e_char == 'R') {
                return false;
            } else if (s_char == 'R' && e_char == 'X') {
                boolean found = false;
                for (int i = idx+1; i < len; i++) {
                    if(s[i] == 'R') { continue; }
                    else if(s[i] == 'L') { return false; }
                    else { found = true; s[i] = 'R'; break; }
                }
                if (!found) { return false; }
                idx++;
            } else {
                System.out.println("we should not get here!");
                return false;
            }
        }

        return true;
    }
}
