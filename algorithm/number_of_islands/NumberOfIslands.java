import java.io.*;
import java.util.*;


class NumberOfIslands
{
    public static void main(String[] args)
    {
        System.out.println("=== Number of Islands ===");
        Solution solution = new Solution();

        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        int ret = solution.numIslands(grid);

        System.out.println(ret);
    }
}


class Solution
{
    public int numIslands(char[][] grid)
    {
        if(grid == null || grid.length == 0) { return 0; }

        int num_rows = 0;
        if(grid != null) { num_rows = grid.length;}
        int num_cols = 0;
        if(grid[0] != null) { num_cols = grid[0].length; }
        
        int[][] map = new int[grid.length][grid[0].length];
        boolean with_island = false;
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                if(grid[i][j] == '1') {
                    map[i][j] = 1;
                    with_island = true;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        if(!with_island) { return 0; }

        // start the top left element of 1, set island element value to 2
        boolean all_colored = false;
        int color = 1;
        while(!all_colored) {
            all_colored = true;

            color++;

            // now we find the first '1', set it to next new color
            // and start to spread the color
            boolean found = false;
            for(int i = 0; i < num_rows; i++) {
                for(int j = 0; j < num_cols; j++) {
                    if(map[i][j] == 1) {
                        map[i][j] = color;
                        found = true;
                        break;
                    }
                }
                if(found) { break; }
            }

            boolean updated = true;
            while(updated) {
                updated = false;

                // scan the map, if there is a neighbor with color > 1
                // spread the color
                for(int i = 0; i < num_rows; i++) {
                    for(int j = 0; j < num_cols; j++) {
                        if(map[i][j] == 1) {
                            if(i > 0 && map[i-1][j] > 1) {
                                // top
                                map[i][j] = map[i-1][j];
                                updated = true;
                            } else if(i < num_rows-1 && map[i+1][j] > 1) {
                                // bottom
                                map[i][j] = map[i+1][j];
                                updated = true;
                            }
                            
                            if(j > 0 && map[i][j-1] > 1) {
                                // left
                                map[i][j] = map[i][j-1];
                                updated = true;
                            } else if (j < num_cols-1 && map[i][j+1] > 1) {
                                // right
                                map[i][j] = map[i][j+1];
                                updated = true;
                            }
                        }
                    }
                }
            }

            //print_map(map);
            //System.out.println("color = "+color);
            
            // scan the map, if there is still '1', set all_colored = false
            for(int i = 0; i < num_rows; i++) {
                for(int j = 0; j < num_cols; j++) {
                    if(map[i][j] == 1) {
                        all_colored = false;
                        break;
                    }
                }

                if(!all_colored) { break; }
            }
        }

        return color-1;
    }

    public void print_map(int[][] map) {
        int num_rows = map.length;
        int num_cols = map[0].length;

        System.out.println("map:");
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
