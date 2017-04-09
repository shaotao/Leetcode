import java.io.*;
import java.util.*;


class LicenseKeyFormatting
{
    public static void main(String[] args)
    {
	System.out.println("=== License Key Formatting ===");
	Solution solution = new Solution();

        String[] strs = {"2-4A0r7-4k", "2-4A0r7-4k"};
        int[] Ks = {4, 3};

        for(int i = 0; i < strs.length; i++) {
            String ret = solution.licenseKeyFormatting(strs[i], Ks[i]);

            System.out.println(String.format("S = %s, K = %d", strs[i], Ks[i]));
            System.out.println("license key = "+ret);
        }
    }
}


class Solution
{
    public String licenseKeyFormatting(String S, int K) {
        String s = S.toUpperCase();

        StringBuffer tmp = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '-') { continue; }
            tmp.append(ch);
        }
        s = tmp.toString();
        
        if(s.length() <= K) { return s; }

        int remain = s.length()%K;
        StringBuffer buf = new StringBuffer();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(count > 0 && count == remain) {
                buf.append("-"); 
            } else if((count -remain) >= K && (count-remain)%K == 0) {
                buf.append("-");
            }
            count++;
            
            char ch = s.charAt(i);

            buf.append(ch);
        }

        return buf.toString();
    }
}
