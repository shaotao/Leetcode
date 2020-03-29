import java.io.*;
import java.util.*;


class SurroundedRegions
{
    public static void main(String[] args)
    {
        System.out.println("=== Surrounded Regions ===");
        /*
        char[][] board = { {'X', 'X', 'X', 'X'},
                           {'X', 'O', 'O', 'X'},
                           {'X', 'X', 'O', 'X'},
                           {'X', 'O', 'X', 'X'} };
        */
        char[][] board = {{'X', 'X', 'X'},
                          {'X', 'O', 'X'},
                          {'X', 'X', 'X'}};
        
        Solution solution = new Solution();

        System.out.println("before:");
        print_board(board);

        solution.solve(board);

        System.out.println("after:");
        print_board(board);
    }
    
    public static void print_board(char[][] board)
    {
        int num_rows = board.length;
        int num_cols = board.length <= 0 ? 0:board[0].length;
        
        System.out.println("board: "+num_rows+" X "+num_cols);
        for(int i = 0; i < num_rows; i++)
        {
            for(int j = 0; j < num_cols; j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}


class Solution
{
    public void solve(char[][] board)
    {
        // scan the board to find '0' along the board
        // set them to 's' and infect the neighboring '0's,
        int num_rows = board.length;
        int num_cols = board.length > 0? board[0].length: 0;

        if(num_rows == 0 || num_cols == 0) { return; }

        // scan first and last row, first and last col
        for(int j = 0; j < num_cols; j++)
        {
            if(board[0][j] == 'O') { board[0][j] = 's'; }
            if(board[num_rows-1][j] == 'O') { board[num_rows-1][j] = 's'; }
        }
        
        for(int i = 0; i < num_rows; i++)
        {
            if(board[i][0] == 'O') { board[i][0] = 's'; }
            if(board[i][num_cols-1] == 'O') { board[i][num_cols-1] = 's'; }
        }

        // if no more '0' can be converted to 's'
        // revert '0' to 'X' and 's' to '0'
        boolean updated = true;
        while(updated)
        {
            updated = false;
            
            for(int i = 1; i < num_rows-1; i++)
            {
                for(int j = 1; j < num_cols-1; j++)
                {
                    if(board[i][j] != 'O') { continue; }

                    if(board[i-1][j] == 's' || board[i+1][j] == 's' ||
                       board[i][j-1] == 's' || board[i][j+1] == 's')
                    {
                        board[i][j] = 's';
                        updated = true;
                    }
                }
            }
        }
        
        // finally, set 'O' to X and 's' to 'O'
        for(int i = 0; i < num_rows; i++)
        {
            for(int j = 0; j < num_cols; j++)
            {
                if(board[i][j] == 'O') { board[i][j] = 'X'; }
                else if(board[i][j] == 's') { board[i][j] = 'O'; }
            }
        }
        
    }
}
