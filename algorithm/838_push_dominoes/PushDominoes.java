import java.io.*;
import java.util.*;


class PushDominoes
{
    public static void main(String[] args)
    {
        System.out.println("=== Push Dominoes ===");
        Solution solution = new Solution();
        String[] input = {".L.R...LR..L..",
                          "RR.L"};
        for (String dominoes : input) {
            System.out.println("dominoes = "+dominoes);
            System.out.println("ret = "+solution.pushDominoes(dominoes));
        }
    }
}


class Solution
{
    public String pushDominoes(String dominoes) {
        StringBuffer buf = new StringBuffer();
        int[] right = new int[dominoes.length()];
        int[] left = new int[dominoes.length()];

        int RIdxOnLeft = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                right[i] = 0;
                RIdxOnLeft = i;
            } else if (dominoes.charAt(i) == 'L') {
                right[i] = -1;
                RIdxOnLeft = -1;
            } else {
                right[i] = (RIdxOnLeft >=0)?(i - RIdxOnLeft):-1;
            }
        }

        int LIdxOnRight = -1;
        for (int i = dominoes.length()-1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                left[i] = 0;
                LIdxOnRight = i;
            } else if (dominoes.charAt(i) == 'R') {
                left[i] = -1;
                LIdxOnRight = -1;
            } else {
                left[i] = (LIdxOnRight >=0)?(LIdxOnRight-i):-1;      
            }
        }

        for (int i = 0; i < dominoes.length(); i++) {
            if (left[i] == right[i]) {
                buf.append('.');
            } else if (left[i] < 0 && right[i] >= 0) {
                buf.append('R');
            } else if (left[i] >= 0 && right[i] < 0) {
                buf.append('L');
            } else {
                buf.append(left[i]<right[i]?'L':'R');
            }
        }

        return buf.toString();
    }
}
