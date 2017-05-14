import java.io.*;
import java.util.*;


class AssignCookies
{
    public static void main(String[] args)
    {
	System.out.println("=== Assign Cookies ===");
	Solution solution = new Solution();

        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println("g = "+Arrays.toString(g)+", s = "+Arrays.toString(s)+", content children = "+solution.findContentChildren(g, s));

        g = new int[]{1,2};
        s = new int[]{1,2,3};
        System.out.println("g = "+Arrays.toString(g)+", s = "+Arrays.toString(s)+", content children = "+solution.findContentChildren(g, s));

        g = new int[]{10,9,8,7};
        s = new int[]{5,6,7,8};
        System.out.println("g = "+Arrays.toString(g)+", s = "+Arrays.toString(s)+", content children = "+solution.findContentChildren(g, s));

    }
}


class Solution
{
    public int findContentChildren(int[] g, int[] s) {
        int ret = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int pg = 0;
        int ps = 0;

        while(pg < g.length && ps < s.length) {
            if(s[ps] >= g[pg]) {
                pg++;
                ps++;
                ret++;
            } else {
                ps++;
            }
        }
        
        return ret;
    }
}
