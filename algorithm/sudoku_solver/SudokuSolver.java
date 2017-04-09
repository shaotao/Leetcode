import java.io.*;
import java.util.*;


class SudokuSolver
{
    public static void main(String[] args)
    {
        System.out.println("=== Sudoku Solver ===");
        Solution solution = new Solution();
        
        char[][] board = { {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                           {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                           {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                           {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                           {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                           {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                           {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                           {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                           {'.', '.', '.', '.', '8', '.', '.', '7', '9'} };

        solution.solveSudoku(board);
        
        System.out.println("board:");
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
}


class Solution
{
    public void solveSudoku(char[][] board)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char ch = '1'; ch <= '9'; ch++)
        {
            map.put(ch, 9);                        
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                Character key = board[i][j];
                if(key == '.') { continue; }

                int val = map.get(key);
                if(val <= 1)
                {
                    map.remove(key);
                }
                else
                {
                    map.put(key, val-1);
                }
            }
        }

        fill_board(board, map);
    }

    public ArrayList<Character> find_numbers(char[][] board, int target_i, int target_j, HashMap<Character, Integer> map)
    {
        ArrayList<Character> list = new ArrayList<Character>();
        
        // iterate over the keys in map
        Iterator<Character> iter = map.keySet().iterator();
        while(iter.hasNext())
        {
            char ch = iter.next();

            // search in the row
            boolean found = false;
            for(int col = 0; col < board[0].length; col++)
            {
                if(board[target_i][col] == ch)
                { 
                    found = true;
                    break;
                }
            }

            // search in the column
            if(found == false)
            {
                for(int row = 0; row < board.length; row++)
                {
                    if(board[row][target_j] == ch) 
                    { 
                        found = true;
                        break;
                    }
                }
            }
            
            // search within the block
            if(found == false)
            {
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        if(board[3*(target_i/3)+i][3*(target_j/3)+j] == ch)
                        { 
                            found = true;
                            break;
                        }
                    }
                    if(found) { break; }
                }
            }

            // if we get here, we can ue this ch
            if(found == false) { list.add(ch); }
        }

        return list;
    }
    
    public boolean fill_board(char[][] board, HashMap<Character, Integer> map)
    {
        if(map.isEmpty()) { return true; }
        
        // 1. find the next empty slot, 
        int target_i = -1;
        int target_j = -1;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    target_i = i;
                    target_j = j;
                }
            }
        }

        // this should not happen, if yes, the board is all filled!
        if(target_i < 0 || target_j < 0) { return true; }
                
        // 2. search for the available numbers to put in
        //    based on neighboring numbers and the available ones in map
        ArrayList<Character> list = find_numbers(board, target_i, target_j, map);
        if(list.size() == 0) { return false; }
        
        // 3. try the numbers one by one, until one return true
        for(int i = 0; i < list.size(); i++)
        {
            char ch = list.get(i);
            
            board[target_i][target_j] = ch;
            
            int val = map.get(ch);
            if(val < 2) { map.remove(ch); }
            else { map.put(ch, val-1); }
            
            // try the next one
            boolean ret = fill_board(board, map);
            if(ret == true) { return true; }
            else
            {
                board[target_i][target_j] = '.';
                val = 0;
                if(map.containsKey(ch))
                {
                    val = map.get(ch);
                }
                map.put(ch, val+1);
            }
        }

        // if we get here, we need to try another way
        return false;
    }
}
