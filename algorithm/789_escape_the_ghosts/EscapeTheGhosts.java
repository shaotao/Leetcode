import java.io.*;
import java.util.*;


class EscapeTheGhosts
{
    public static void main(String[] args)
    {
        System.out.println("=== Escape The Ghosts ===");
        Solution solution = new Solution();
        int[][][] input_ghosts = { {{1,0}, {0,3}},
                                   {{1,0}},
                                   {{2,0}},
                                   {{1,9}, {2,-5}, {3,8}, {9,8}, {-1,3}} };
        int[][] targets = {{0,1}, {2,0}, {1,0}, {8,-10}};

        for (int i = 0; i < targets.length; i++) {
            int[][] ghosts = input_ghosts[i];
            int[] target = targets[i];
            System.out.println("ghosts = "+Arrays.deepToString(ghosts));
            System.out.println("target = "+Arrays.toString(target));
            System.out.println("escape = "+solution.escapeGhosts(ghosts, target));
        }
    }
}


class Solution
{
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min = -1;
        for(int[] ghost : ghosts) {
            int dist = (int)(Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]));
            min = (min==-1 || min > dist)?dist:min;
        }
        return min>(Math.abs(target[0])+Math.abs(target[1]));
    }
}
