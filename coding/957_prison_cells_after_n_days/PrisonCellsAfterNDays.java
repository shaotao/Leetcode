import java.io.*;
import java.util.*;


class PrisonCellsAfterNDays
{
    public static void main(String[] args)
    {
        System.out.println("=== Prison Cells After N Days ===");
        Solution solution = new Solution();
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        System.out.println("cells = "+Arrays.toString(cells));
        System.out.println("N = "+N);
        int[] result = solution.prisonAfterNDays(cells, N);
        System.out.println("result = "+Arrays.toString(result));
    }
}


class Solution
{
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cells0 = cells;
        int[] cells1 = new int[cells0.length];

        for (int i = 1; i <=N; i++) {
            int[] from = (i%2==1)?cells0:cells1;
            int[] to = (i%2==1)?cells1:cells0;

            for (int j = 0; j < from.length; j++) {
                if (j == 0 || j == from.length-1) {
                    to[j] = 0;
                } else {
                    to[j] = (from[j-1]==from[j+1])?1:0;
                }
            }

            //System.out.println("round = "+i);
            //System.out.println("from = "+Arrays.toString(from));
            //System.out.println("to = "+Arrays.toString(to));
        }
        
        return (N%2==0)?cells0:cells1;
    }
}
