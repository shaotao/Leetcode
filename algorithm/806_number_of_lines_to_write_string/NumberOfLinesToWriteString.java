import java.io.*;
import java.util.*;


class NumberOfLinesToWriteString
{
    public static void main(String[] args)
    {
        System.out.println("=== Number of Lines To Write String ===");
        Solution solution = new Solution();
        String S = "bbbcccdddaaa";
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] ret = solution.numberOfLines(widths, S);
        System.out.println("widths = "+Arrays.toString(widths));
        System.out.println("S = "+S);
        System.out.println("number of lines = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] numberOfLines(int[] widths, String S) {
        int MAX = 100;
        int[] ret = new int[2];
        int num_lines = 1;
        int count = 0;
        for (char ch : S.toCharArray()) {
            int idx = ((int)ch - (int)'a');
            int width = widths[idx];

            if (count + width <= MAX) {
                count += width;
            } else {
                num_lines++;
                count = width;
            }
        }

        ret[0] = num_lines;
        ret[1] = count;

        return ret;
    }
}
