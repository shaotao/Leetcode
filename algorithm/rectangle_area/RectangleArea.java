import java.io.*;
import java.util.*;


class RectangleArea
{
    public static void main(String[] args)
    {
        System.out.println("=== Rectangle Area ===");
        Solution solution = new Solution();
        int ret = solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println("Area = "+ret);
    }
}

class Solution
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int ret = 0;
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);

        if(A >= G || C <= E || B >= H || D <= F) {
            ret = area1 + area2;
        }
        else {
            int left = (A>=E)?A:E;
            int right = (C<=G)?C:G;
            int bottom = (B>=F)?B:F;
            int top = (D<=H)?D:H;
            
            int common = (right - left)*(top - bottom);
            ret = area1+area2-common;
        }
        
        return ret;
    }
}
