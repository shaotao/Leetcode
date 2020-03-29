import java.io.*;
import java.util.*;


class UTF8Validation
{
    public static void main(String[] args)
    {
	System.out.println("=== UTF-8 Validation ===");
	Solution solution = new Solution();
        int[][] input = {{197, 130, 1}, {235, 140, 4}, {237}};

        for(int[] data: input) {
            System.out.print("data = "+Arrays.toString(data));
            System.out.println(", valid utf-8 = "+solution.validUtf8(data));
        }
    }
}


class Solution
{
    public boolean validUtf8(int[] data) {
        int head1 = 128;
        int head2 = 192;
        int head3 = 224;
        int head4 = 240;
        int head5 = 248;

        int left = 0;
        for(int i = 0; i < data.length; i++) {
            int n = data[i];

            if(left > 0) {
                // expect trailing bytes starting with 10
                if((n^head1) > 64) { return false; }
                else { left--; }
            } else {
                if((n^head5) < 8) {
                    return false;
                } else if ((n^head4) < 16) {
                    left = 3;
                } else if ((n^head3) < 32) {
                    left = 2;
                } else if((n^head2) < 64) {
                    left = 1;
                } else if ((n^head1) >= 128) {
                    left = 0;
                } else {
                    return false;
                }
            }

            //System.out.println("n = "+n+", left = "+left);
        }
        
        return (left == 0);
    }
}
