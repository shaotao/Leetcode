import java.io.*;
import java.util.*;


class ValidTicTacToeState
{
    public static void main(String[] args)
    {
        System.out.println("=== Valid Tic Tac Toe State ===");
        Solution solution = new Solution();
        String[][] boards = { {"O  ", "   ", "   "},
                              {"XOX", " X ", "   "},
                              {"XXX", "   ", "OOO"},
                              {"XOX", "O O", "XOX"},
                              {"XXX", "XOO", "OO "} };
        for (String[] board : boards) {
            System.out.println("board = "+Arrays.toString(board));
            System.out.println("valid = "+solution.validTicTacToe(board));
        }
    }
}


class Solution
{
    // check if the input matrix has a win
    private int checkWin(int[][] m) {
        int sum = 0;
        int winX = 0;
        int winO = 0;
        // scan by row
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += m[i][j];
            }
            if (sum == 0) { winO++; }
            else if (sum == 3) { winX++; }
            if (winX > 0 && winO > 0) { return -1; }
        }

        // scan by column
        for (int j = 0; j < 3; j++) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += m[i][j];
            }
            if (sum == 0) { winO++; }
            else if (sum == 3) { winX++; }
            if (winX > 0 && winO > 0) { return -1; }
        }
        
        // scan by diagonal
        sum = 0;
        sum = m[0][0] + m[1][1] + m[2][2];
        if (sum == 0) { winO++; }
        else if (sum == 3) { winX++; }
        if (winX > 0 && winO > 0) { return -1; }
        
        sum = 0;
        sum = m[2][0] + m[1][1] + m[0][2];
        if (sum == 0) { winO++; }
        else if (sum == 3) { winX++; }
        if (winX > 0 && winO > 0) { return -1; }
        
        if (winX > 0) { return 1; }
        else if (winO > 0) { return 0; }
        else { return 2; }
    }
    
    public boolean validTicTacToe(String[] board) {
        int[][] m = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if (ch =='X') { m[i][j] = 1; }
                else if (ch =='O') { m[i][j] = 0; }
                else { m[i][j] = 10; }
            }
        }

        // 1. count(X) should = num(O) or = count(O) + 1
        int countX = 0;
        int countO = 0;
        for (int[] row : m) {
            for (int cell : row) {
                if (cell == 1) { countX++; }
                else if (cell == 0) { countO++; }
            }
        }

        if (countX != countO && countX != (countO+1)) {
            return false;
        }

        // 2. there can't be both win(X) and win(O)
        int win = checkWin(m);
        if (win == -1) { return false; }
        if (win == 1 && countX != countO+1) { return false; }
        if (win == 0 && countX != countO) { return false; }

        return true;
    }
}
