import java.io.*;
import java.util.*;


class BackspaceStringCompare
{
    public static void main(String[] args)
    {
        System.out.println("=== Backspace String Compare ===");
        Solution solution = new Solution();
        String[][] input = {{"ab#c", "ad#c"},
                          {"ab##", "c#d#"},
                          {"a##c", "#a#c"},
                          {"a#c", "b"}};
        for (String[] pair : input) {
            System.out.println(String.format("S=%s, T=%s, compare=%s",
                                             pair[0], pair[1],
                                             solution.backspaceCompare(pair[0], pair[1])));
        }
    }
}


class Solution
{
    public boolean backspaceCompare(String S, String T) {
        if ( (S == null && T != null) ||
             (S != null && T == null)) {
            return false;
        }

        if (S == null && T == null) {
            return true;
        }

        String[] array = {S, T};
        StringBuffer[] bufs = new StringBuffer[array.length];
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            bufs[i] = new StringBuffer();
            for (char ch : str.toCharArray()) {
                if (ch == '#') {
                    if (bufs[i].length() > 0) {
                        bufs[i].delete(bufs[i].length()-1, bufs[i].length());
                    }
                } else {
                    bufs[i].append(ch);
                }
            }
        }

        String first = bufs[0].toString();
        for (int i = 1; i < bufs.length; i++) {
            if (!first.equals(bufs[i].toString())) {
                return false;
            }   
        }
        
        return true;
    }
}
