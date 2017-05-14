import java.io.*;
import java.util.*;


class NumberOfSegmentsInAString
{
    public static void main(String[] args)
    {
	System.out.println("=== Number of Segments in a String ===");
	Solution solution = new Solution();

        String s = "Hello, my name is John";
        System.out.println("s = \""+s+"\", number of segments = "+solution.countSegments(s));
    }
}


class Solution
{
    public int countSegments(String s) {
        if(s == null) { return 0; }

        int ret = 0;
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                ret += (count>0)?1:0;
                count = 0;
            } else {
                count++;
            }
        }

        ret += (count>0)?1:0;
        
        return ret;
    }
}
