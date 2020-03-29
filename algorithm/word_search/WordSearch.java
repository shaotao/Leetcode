import java.io.*;
import java.util.*;


class WordSearch
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        char[][] board = { {'A', 'B', 'C', 'E'}, 
                           {'S', 'F', 'C', 'S'}, 
                           {'A', 'D', 'E', 'E'}
                         };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        boolean ret = solution.exist(board, word1);
        System.out.println("word1 = "+word1+", exist = "+ret);

        ret = solution.exist(board, word2);
        System.out.println("word2 = "+word2+", exist = "+ret);

        ret = solution.exist(board, word3);
        System.out.println("word3 = "+word3+", exist = "+ret);

    }
}

class Solution
{
    public Solution()
    {
    }

    public boolean exist(char[][] board, String word)
    {
        int num_rows = board.length;
        int num_cols = board[0].length;

        //System.out.println("num_rows = "+num_rows);
        //System.out.println("num_cols = "+num_cols);

        for(int idx_row = 0; idx_row < num_rows; idx_row++)
        {
            for(int idx_col = 0; idx_col < num_cols; idx_col++)
            {
                if(board[idx_row][idx_col] == word.charAt(0))
                {
                    boolean result = trace_word(board, idx_row, idx_col, num_rows, num_cols, word, 0);

                    if(result == true)
                    {
                        return result;
                    }
                }
            }
        }

        return false;
    }

    public boolean trace_word(char[][] board, int idx_row, int idx_col, int num_rows, int num_cols, String word, int idx)
    {
        if(idx >= word.length())
        {
            return true;
        }

        if(idx_row < 0 || idx_row >= num_rows || idx_col < 0 || idx_col >= num_cols)
        {
            return false;
        }

        if(board[idx_row][idx_col] != word.charAt(idx))
        {
            return false;
        }

        char org_char = board[idx_row][idx_col];

        boolean ret = false;

        board[idx_row][idx_col] = ' ';

        ret = trace_word(board, idx_row, idx_col-1, num_rows, num_cols, word, idx+1);
        if(ret == true)
        {
            board[idx_row][idx_col] = org_char;
            return true;
        }

        ret = trace_word(board, idx_row-1, idx_col, num_rows, num_cols, word, idx+1);
        if(ret == true)
        {
            board[idx_row][idx_col] = org_char;
            return true;
        }

        ret = trace_word(board, idx_row, idx_col+1, num_rows, num_cols, word, idx+1);
        if(ret == true)
        {
            board[idx_row][idx_col] = org_char;
            return true;
        }

        ret = trace_word(board, idx_row+1, idx_col, num_rows, num_cols, word, idx+1);
        if(ret == true)
        {
            board[idx_row][idx_col] = org_char;
            return true;
        }

        // if we get here, all cases are false, retore char at idx_row idx_col
        board[idx_row][idx_col] = org_char;

        return false;
    }
}
