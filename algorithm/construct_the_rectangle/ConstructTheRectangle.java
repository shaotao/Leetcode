import java.io.*;
import java.util.*;


class ConstructTheRectangle
{
    public static void main(String[] args)
    {
	System.out.println("=== Construct the Rectangle ===");
	Solution solution = new Solution();

        int area = 4;
        int[] ret = solution.constructRectangle(area);
        System.out.println("area = "+area);
        System.out.println("L,W = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] constructRectangle(int area) {
        int start = (int)(Math.sqrt(area));

        int ret[] = new int[2];
        for(int i = start; i <= area; i++) {
            if(area%i == 0) {
                if(i >= area/i) {
                    ret[0] = i;
                    ret[1] = area/i;
                } else {
                    ret[0] = area/i;
                    ret[1] = i;
                }
                break;
            }
        }

        return ret;
    }
}
