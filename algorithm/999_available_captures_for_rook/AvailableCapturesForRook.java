import java.io.*;
import java.util.*;


class AvailableCapturesForRook
{
    public static void main(String[] args)
    {
        System.out.println("=== Available Captures for Rook ===");
        Solution solution = new Solution();
        char[][][] boards = {{{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}},
                            {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}},
                            {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}};
        for (char[][] board : boards) {
            System.out.println("board = "+Arrays.deepToString(board));
            System.out.println("captures = "+solution.numRookCaptures(board));
        }
    }
}


class Solution
{
    public int numRookCaptures(char[][] board) {
        int ret = 0;
        int rx = -1;
        int ry = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] =='R') {
                    rx = i;
                    ry = j;
                }
            }
        }

        // search left
        for (int j = ry; j >= 0; j--) {
            if (board[rx][j] == 'B') {
                break;
            } else if (board[rx][j] == 'p') {
                ret++;
                break;
            }
        }

        // search right
        for (int j = ry; j < 8; j++) {
            if (board[rx][j] == 'B') {
                break;
            } else if (board[rx][j] == 'p') {
                ret++;
                break;
            }
        }

        // search up
        for (int i = rx; i >= 0; i--) {
            if (board[i][ry] == 'B') {
                break;
            } else if (board[i][ry] == 'p') {
                ret++;
                break;
            }
        }
        
        // search down
        for (int i = rx; i < 8; i++) {
            if (board[i][ry] == 'B') {
                break;
            } else if (board[i][ry] == 'p') {
                ret++;
                break;
            }
        }

        return ret;
    }
}
