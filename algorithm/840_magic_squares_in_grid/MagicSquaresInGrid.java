import java.io.*;
import java.util.*;


class MagicSquaresInGrid
{
    public static void main(String[] args)
    {
        System.out.println("=== Magic Squares In Grid ===");
        Solution solution = new Solution();
        int[][] grid = {{4,3,8,4},
                        {9,5,1,9},
                        {2,7,6,2}};
        int num = solution.numMagicSquaresInside(grid);
        System.out.println("grid = "+Arrays.deepToString(grid));
        System.out.println("num of magic squares = "+solution.numMagicSquaresInside(grid));
    }
}


class Solution
{
    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i <= rows-3; i++) {
            for (int j = 0; j <= cols-3; j++) {
                ret += isMagicSquare(grid, i, j)?1:0;
            }
        }
        
        return ret;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {

        // check if all numbers are different
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                set.add(grid[i][j]);
            }
        }

        if(set.size() != 9) {
            return false;
        }

        int expected = grid[x][y] + grid[x][y+1] + grid[x][y+2];
        // check rows
        for(int i = 1; i < 3; i++) {
            if ((grid[x+i][y] + grid[x+i][y+1] + grid[x+i][y+2]) != expected) {
                return false;
            }
        }

        // check cols
        for(int i = 0; i < 3; i++) {
            if ((grid[x][y+i] + grid[x+1][y+i] + grid[x+2][y+i]) != expected) {
                return false;
            }
        }

        // check diagonals
        if ((grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2]) != expected) {
            return false;
        }
        
        if ((grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y]) != expected) {
            return false;
        }

        return true;
    }
}
