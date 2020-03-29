import java.io.*;
import java.util.*;


class CherryPickup
{
    public static void main(String[] args)
    {
        System.out.println("=== Cherry Pickup ===");
        Solution solution = new Solution();
        int[][] grid = {{0, 1, -1},
                        {1, 0, -1},
                        {1, 1, 1}};
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("pick up = "+solution.cherryPickup(grid));
    }
}


class Solution
{
    public int cherryPickup(int[][] grid) {
        int ret = 0;
        if(grid.length == 0) { return 0; }
        int rows = grid.length;
        int cols = grid[0].length;

        // first, we go down right, wipe the grid as well
        //int[][] m = goDownRight2(grid);
        //ret = m[rows-1][cols-1];
        //if(ret == -1) {
        //    return 0;
        //}

        BitSet[][] m = goDownRight(grid);
        if (m[rows-1][cols-1] != null) {
            ret = m[rows-1][cols-1].cardinality();
        }

        return ret;
    }

        // scan the grid by going down right, return the status matrix m
    private BitSet[][] goDownRight(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        BitSet[][] m = new BitSet[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    m[i][j] = new BitSet();
                    m[i][j].set(i*cols+j, grid[i][j]==1);
                } else if (i == 0) {
                    if (grid[i][j] == -1) {
                        m[i][j] = null;
                    } else if (m[i][j-1] == null) {
                        m[i][j] = null;
                    } else {
                        m[i][j] = (BitSet) m[i][j-1].clone();
                        m[i][j].set(i*cols+j, grid[i][j]==1);
                    }
                } else if (j == 0) {
                    if (grid[i][j] == -1) {
                        m[i][j] = null;
                    } else if (m[i-1][j] == null) {
                        m[i][j] = null;
                    } else {
                        m[i][j] = (BitSet) m[i-1][j].clone();
                        m[i][j].set(i*cols+j, grid[i][j]==1);
                    }
                } else {
                    if (grid[i][j] == -1 || (m[i-1][j] == null && m[i][j-1] == null)) {
                        m[i][j] = null;
                    } else {
                        if (m[i-1][j] != null) {
                            m[i][j] = (BitSet) m[i-1][j].clone();
                            if (m[i][j-1] != null) {
                                m[i][j].or(m[i][j-1]);
                            }
                        } else {
                            m[i][j] = (BitSet) m[i][j-1].clone();
                            if (m[i-1][j] != null) {
                                m[i][j].or(m[i-1][j]);
                            }
                        }
                        m[i][j].set(i*cols+j, grid[i][j]==1);
                    }
                }
            }
        }

        //System.out.println("m = "+Arrays.deepToString(m));
        return m;
    }

    
    // scan the grid by going down right, return the status matrix m
    private int[][] goDownRight2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] m = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) { m[i][j] = grid[i][j]; }
                else if (i == 0) {
                    if (grid[i][j] != -1) {
                        m[i][j] = -1;
                    } else if (m[i][j-1] == -1) {
                        m[i][j] = -1;
                    } else {
                        m[i][j] = grid[i][j] + m[i][j-1];
                    }
                } else if (j == 0) {
                    if (grid[i][j] == -1) {
                        m[i][j] = -1;
                    } else if (m[i-1][j] == -1) {
                        m[i][j] = -1;
                    } else {
                        m[i][j] = grid[i][j] + m[i-1][j];
                    }
                } else {
                    if (grid[i][j] == -1 || (m[i-1][j] == -1 && m[i][j-1]==-1)) {
                        m[i][j] = -1;
                    } else {
                        m[i][j] = grid[i][j] + (m[i-1][j] > m[i][j-1]?m[i-1][j]:m[i][j-1]);
                    }
                }
            }
        }

        //System.out.println("m = "+Arrays.deepToString(m));
        return m;
    }
}
