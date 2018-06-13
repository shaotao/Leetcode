import java.io.*;
import java.util.*;


class FindAndReplaceInString
{
    public static void main(String[] args)
    {
        System.out.println("=== Find And Replace in String ===");
        Solution solution = new Solution();
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println("ret = "+solution.findReplaceString(S, indexes, sources, targets));

        S = "abcd";
        indexes = new int[]{0,2};
        sources = new String[]{"ab", "ec"};
        targets = new String[]{"eee", "ffff"};        
        System.out.println("ret = "+solution.findReplaceString(S, indexes, sources, targets));

        S = "vmokgggqzp";
        indexes = new int[]{3,5,1};
        sources = new String[]{"kg", "ggq", "mo"};
        targets = new String[]{"s", "so", "bfr"};
        System.out.println("ret = "+solution.findReplaceString(S, indexes, sources, targets));
        
    }
}


class Solution
{
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < indexes.length; i++) {
            for (int j = i+1; j < indexes.length; j++) {
                if (indexes[i] > indexes[j]) {
                    int tmp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = tmp;

                    String tmpS = sources[i];
                    sources[i] = sources[j];
                    sources[j] = tmpS;

                    String tmpT = targets[i];
                    targets[i] = targets[j];
                    targets[j] = tmpT;
                }
            }
        }

        int end = S.length();
        for (int i = indexes.length-1; i >= 0; i--) {
            //System.out.println("idx = "+indexes[i]);
            //System.out.println("end = "+end);
            String seg = S.substring(indexes[i], end);
            if (seg.startsWith(sources[i])) {
                seg = seg.replaceFirst(sources[i], targets[i]);
            }
            buf.insert(0, seg);
            end = indexes[i];
        }
        buf.insert(0, S.substring(0, end));
        
        return buf.toString();
    }
}
