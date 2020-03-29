import java.io.*;
import java.util.*;


class ShortestDistanceToACharacter
{
    public static void main(String[] args)
    {
        System.out.println("=== Shortest Distance to a Character ===");
        Solution solution = new Solution();
        String S = "loveleetcode";
        char C = 'e';
        int[] ret = solution.shortestToChar(S, C);
        System.out.println("S = "+S);
        System.out.println("C = "+C);
        System.out.println("ret = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if( S.charAt(i) == C) {
                posList.add(i);
            }
        }

        for (int i = 0; i < ret.length; i++) {
            int min = -1;
            for (int pos : posList) {
                int dist = (int)Math.abs(pos-i);
                if (min==-1 || min > dist) {
                    min = dist;
                }
            }
            ret[i] = min;
        }
        return ret;
    }
}
