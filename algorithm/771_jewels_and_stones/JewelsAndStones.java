import java.io.*;
import java.util.*;


class JewelsAndStones
{
    public static void main(String[] args)
    {
        System.out.println("=== Jewels And Stones ===");
        Solution solution = new Solution();
        String[] J_array = {"aA", "z"};
        String[] S_array = {"aAAbbbb", "ZZ"};
        for(int i = 0; i < J_array.length; i++) {
            System.out.println("J = "+J_array[i]+", S = "+S_array[i]+", number of jewels = "+solution.numJewelsInStones(J_array[i], S_array[i]));
        }
    }
}


class Solution
{
    public int numJewelsInStones(String J, String S) {
        int num = 0;

        if(J == null || S == null) { return 0; }
        HashSet<Character> jset = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            jset.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i++) {
            if(jset.contains(S.charAt(i))) {
                num++;
            }
        }

        return num;
    }
}
