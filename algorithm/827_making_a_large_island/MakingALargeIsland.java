import java.io.*;
import java.util.*;


class MakingALargeIsland
{
    public static void main(String[] args)
    {
        System.out.println("=== Making A Large Island ===");
        Solution solution = new Solution();
        int[][][] array_grid = {{{1,0}, {0,1}},
                                {{1,1}, {1,0}},
                                {{1,1}, {1,1}}};
        for (int[][] grid : array_grid) {
            System.out.println("grid = "+Arrays.deepToString(grid));
            System.out.println("largest island = "+solution.largestIsland(grid));
        }
    }
}


class Solution
{
    // expr = x * 100 + y, store in a Set
    private void spread (int[][] grid, int a, int b, List<HashSet<Integer>> list) {
        int n = grid.length;
        int point = a*100 + b;
        if (grid[a][b] <= 0) {
            return;
        }
        for (Set<Integer> set : list) {
            if (set.contains(point)) {
                return;
            }
        }
        List<Integer> l = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(point);
        list.add(set);

        l.add(point);
        int i = 0;
        while ( i < l.size()) {
            int expr = l.get(i);
            int x = expr/100;
            int y = expr%100;

            // up
            if (y -1 >= 0 && grid[x][y-1] == 1) {
                if (!set.contains(expr-1)) {
                    l.add(expr-1);
                    set.add(expr-1);
                }
            }
            // down
            if (y+1 < n && grid[x][y+1] == 1) {
                if (!set.contains(expr+1)) {
                    l.add(expr+1);
                    set.add(expr+1);
                }
            }
            
            // left
            if (x-1 >= 0 && grid[x-1][y] ==1) {
                if (!set.contains(expr-100)) {
                    l.add(expr-100);
                    set.add(expr-100);
                }
            }
            
            // right
            if (x+1 < n && grid[x+1][y] == 1) {
                if (!set.contains(expr+100)) {
                    l.add(expr+100);
                    set.add(expr+100);
                }
            }
            i++;
        }

        // spread set size to all points in l
        int mark = -1*(list.size());
        for (int expr : l) {
            grid[expr/100][expr%100] = mark;
        }
    }
    
    public int largestIsland(int[][] grid) {
        int size = 0;

        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        
        // 1. build the set
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    // build the set
                    // spread out the id of the set
                    spread(grid, i, j, list);
                }
            }
        }

        for (Set<Integer> set : list) {
            size = (size>=set.size())?size:set.size();
        }
        
        //System.out.println("l.size = "+list.size());
        //System.out.println("grid = "+Arrays.deepToString(grid));
        
        // 3. find the 0 that is neighbor of largest islands
        // compute the sum and return
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
            
                Set<Integer> ids = new HashSet<Integer>();
                if (j-1 >= 0 && grid[i][j-1] < 0) {
                    ids.add(-1*grid[i][j-1] -1);
                }
                
                if (j+1 < grid.length && grid[i][j+1] < 0) {
                    ids.add(-1*grid[i][j+1] -1);
                }
                
                if (i-1 >= 0 && grid[i-1][j] < 0) {
                    ids.add(-1*grid[i-1][j] -1);
                }
                
                if (i+1 < grid.length && grid[i+1][j] < 0) {
                    ids.add(-1*grid[i+1][j] -1);
                }

                int tmp = 1;
                for (int id : ids) {
                    tmp+=list.get(id).size();
                }
                if (tmp > size) { size = tmp; }
            }
        }
        
        return size;
    }
}
