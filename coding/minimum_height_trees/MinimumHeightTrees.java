import java.io.*;
import java.util.*;

class MinimumHeightTrees
{
    public static void main(String[] args)
    {
        System.out.println("=== Minimum Height Trees ===");
        int n = 6;
        int[][] edges = {{0, 3},
                         {1, 3},
                         {2, 3},
                         {4, 3},
                         {5, 4}};

        Solution solution = new Solution();
        List<Integer> ret = solution.findMinHeightTrees(n, edges);

        System.out.print("min height trees: ");
        for (int i : ret) {
            System.out.println(Arrays.toString(ret.toArray()));
        }
    }
}


class Solution
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = ((i==j)?0:-1);
            }
        }

        for(int[] edge:edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        // build a path between each pair of points
        boolean updated = true;
        while(updated) {
            updated = false;
            // for each intermediate point - row
            for(int i = 0; i < n; i++) {
                // scan pair of nodes
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == -1) {
                        continue;
                    }
                    for(int k = j+1; k < n; k++) {
                        if(matrix[i][k] != -1 && matrix[j][k] == -1) {
                            matrix[j][k] = matrix[i][j] + matrix[i][k];
                            matrix[k][j] = matrix[j][k];
                            updated = true;
                        }
                    }
                }
            }
        }

        // scan for the roots with minimum of the maximum value per row.
        // for each row, find its max, get the rows ids with he minimum max
        // values, those are the roots
        int max = 0;
        for (int i = 0; i < n; i++) {
            int row_max = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > row_max) { row_max = matrix[i][j]; }
            }

            if (i == 0) {
                max = row_max;
                ret.add(i);
            } else if (row_max == max) {
                ret.add(i);
            } else if (row_max < max) {
                max = row_max;
                ret.clear();
                ret.add(i);
            }
        }
        
        
        return ret;
    }
}
