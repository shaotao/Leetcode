import java.io.*;
import java.util.*;


class GameOfLife
{
    public static void main(String[] args)
    {
        System.out.println("=== Game of Life ===");
        Solution solution = new Solution();

        int[][] board = {{1,0,1,0},
                         {0,1,1,1},
                         {1,0,0,1},
                         {0,1,0,1}};
        print_matrix(board);
        solution.gameOfLife(board);
        print_matrix(board);
    }

    public static void print_matrix(int[][] board) {
        int num_rows = board.length;
        if(num_rows == 0) { return; }
        int num_cols = board[0].length;
        if(num_cols == 0) { return; }

        System.out.println("board:");
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }
    }
}

class Solution
{
    public void gameOfLife(int[][] board)
    {
        int num_rows = board.length;
        if(num_rows == 0) { return; }
        int num_cols = board[0].length;
        if(num_cols == 0) { return; }

        int[][] temp = new int[num_rows][num_cols];

        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                int num_alive = 0;

                int status = board[i][j];
                
                for(int p_i = i-1; p_i <= i+1; p_i++) {
                    for(int p_j = j-1; p_j <= j+1; p_j++) {
                        if(p_i >= 0 && p_i < num_rows &&
                           p_j >= 0 && p_j < num_cols && (p_i != i || p_j != j)) {
                            if(board[p_i][p_j] ==1) { num_alive++; }
                        }
                    }
                }

                //System.out.println("i = "+i+", j = "+j+", num_alive = "+num_alive);
                
                if( (status == 1 && (num_alive < 2 || num_alive > 3))||
                    (status == 0 && num_alive == 3)) {
                    temp[i][j] = board[i][j]^1;
                } else {
                    temp[i][j] = board[i][j];
                }
            }
        }

        // copy temp back to board
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                board[i][j] = temp[i][j];
            }    
        }
    }
}
