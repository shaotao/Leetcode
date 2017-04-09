import java.io.*;
import java.util.*;


class ValidSudoku
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();

	char[][] board = {{'5','1','9','7','4','8','6','3','2'},
			  {'7','8','3','6','5','2','4','1','9'},
			  {'4','2','6','1','3','9','8','7','5'},
			  {'3','5','7','9','8','6','2','4','1'},
			  {'2','6','4','3','1','7','5','9','8'},
			  {'1','9','8','5','2','4','3','6','7'},
			  {'9','7','5','8','6','3','1','2','4'},
			  {'8','3','2','4','9','1','7','5','6'},
			  {'6','4','1','2','7','5','9','8','3'}};

	boolean ret = solution.isValidSudoku(board);
	
	System.out.println("ret = "+ret);
    }
}

class Solution
{
    public Solution()
    {	
    }


    public boolean isValidSudoku(char[][] board)
    {
	// check row by row
	for(int row = 0; row < 9; row++)
	{
	    ArrayList<Character> list = new ArrayList<Character>();
	    for(int col = 0; col < 9; col++)
	    {
		char ch = board[row][col];
		list.add(new Character(ch));
	    }
	    boolean ret = check_list(list);
	    if(ret == false)
	    {
		return false;
	    }
	}

	// check col by col
	for(int col = 0; col < 9; col++)
	{
	    ArrayList<Character> list = new ArrayList<Character>();
	    for(int row = 0; row < 9; row++)
	    {
		char ch = board[row][col];
		list.add(new Character(ch));
	    }
	    boolean ret = check_list(list);
	    if(ret == false)
	    {
		return false;
	    }
	}

	// check block by block
	for(int block_row = 0; block_row <= 6; block_row += 3)
	{
	    for(int block_col = 0; block_col <= 6; block_col += 3)
	    {
		ArrayList<Character> list = new ArrayList<Character>();
		for(int row = block_row; row < block_row+3; row++)
		{
		    for(int col = block_col; col < block_col+3; col++)
		    {
			char ch = board[row][col];
			list.add(new Character(ch));
		    }
		}

		boolean ret = check_list(list);
		if(ret == false)
		{
		    return false;
		}		
	    }
	}

	// if all tests are passed, return true
	return true;
    }

    // check if there are duplicate 1-9 in the list
    // a valid list should have 9 entries some . and 1-9 only once at most
    public boolean check_list(ArrayList<Character> list)
    {
	Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
	for(int i = 0; i < list.size(); i++)
	{
	    Character ch = list.get(i);
	    
	    if(ch.charValue() == '.')
	    {
		continue;
	    }

	    if(table.containsKey(ch))
	    {
		return false;
	    }
	    
	    table.put(ch, new Integer(1));
	}

	return true;
    }
}