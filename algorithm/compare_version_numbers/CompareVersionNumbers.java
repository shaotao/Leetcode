import java.io.*;
import java.util.*;


class CompareVersionNumbers
{
    public static void main(String[] args)
    {
        System.out.println("=== Compare Version Numbers ===");
        String version1 = "0.1";
        String version2 = "1.2";
        
        Solution solution = new Solution();
        int ret = solution.compareVersion(version1, version2);
        
        System.out.println("version1 = "+version1+", version2 = "+version2+", compare = "+ret);
    }
}

class Solution
{
    public int compareVersion(String version1, String version2)
    {
        StringTokenizer stok1 = new StringTokenizer(version1, ".");
        StringTokenizer stok2 = new StringTokenizer(version2, ".");
        
        while(stok1.hasMoreTokens() || stok2.hasMoreTokens())
        {
            String x1 = (stok1.hasMoreTokens())?stok1.nextToken():null;
            String x2 = (stok2.hasMoreTokens())?stok2.nextToken():null;
            
            if(x1 == null && x2 == null) {
                return 0;
            } else if(x1 != null && x2 == null) {
                int n1 = Integer.parseInt(x1);
                if(n1 == 0) { continue; }
                else { return 1; }
            } else if(x1 == null && x2 != null) {
                int n2 = Integer.parseInt(x2);
                if(n2 == 0) { continue; }
                else { return -1; }
            } else {
                int n1 = Integer.parseInt(x1);
                int n2 = Integer.parseInt(x2);
                if (n1 > n2) {
                    return 1;
                } else if (n1 < n2) {
                    return -1;
                } else {
                    continue;
                }
            }
        }
        
        return 0;
    }
}
