import java.io.*;
import java.util.*;


class KthSymbolInGrammar
{
    public static void main(String[] args)
    {
        System.out.println("=== K-th Symbol in Grammar ===");
        Solution solution = new Solution();

        int[] inputs = {1,1,
                          2,1,
                          2,2,
                          4,5};
        for (int i = 0; i < inputs.length; i+=2) {
            int N = inputs[i];
            int K = inputs[i+1];
            System.out.println("N = "+N+", K = "+K+", Symbol = "+solution.kthGrammar(N, K));
        }
    }
}


class Solution
{
    public int kthGrammar(int N, int K) {
        int flip = 1;

        K = K-1;
        while(N > 1) {
            if(K >= (1<<(N-2))) {
                K = K - (1<<(N-2));
                flip *= -1;
            }
            N--;
        }
        
        return (flip==1)?0:1;
    }
}
