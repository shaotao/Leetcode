import java.io.*;
import java.util.*;


class LetterCombinations
{
    public static void main(String[] args)
    {
	System.out.println("=== Letter Combinations of a Phone Number ===");
	Solution solution = new Solution();
	
	String input = "2345";
	
	ArrayList<String> result = solution.letterCombinations(input);
	System.out.println("input = "+input);
	System.out.println("num of output = "+result.size());
	for(int i = 0; i < result.size(); i++)
	{
	    System.out.println(result.get(i));
	}
    }
}

// 2: abc, 3: def, 4: ghi, 5: jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz
class Solution
{
    HashMap<Character, Character[]> map;

    public Solution()
    {
	map = new HashMap<Character, Character[]>();
	map.put('2', new Character[] {'a', 'b', 'c'});
	map.put('3', new Character[] {'d', 'e', 'f'});
	map.put('4', new Character[] {'g', 'h', 'i'});
	map.put('5', new Character[] {'j', 'k', 'l'});
	map.put('6', new Character[] {'m', 'n', 'o'});
	map.put('7', new Character[] {'p', 'q', 'r', 's'});
	map.put('8', new Character[] {'t', 'u', 'v'});
	map.put('9', new Character[] {'w', 'x', 'y', 'z'});		
    }
    
    public ArrayList<String> letterCombinations(String digits)
    {
	ArrayList<String> result = new ArrayList<String>();

	for(int i = 0; i < digits.length(); i++)
	{
	    char ch = digits.charAt(i);
	    if(ch == '0' || ch == '1')
	    {
		System.out.println("invalid digits = "+digits);
		return result;
	    }
	}

	StringBuffer code = new StringBuffer();
	find_codes(digits, 0, code, result);
	
	return result;
    }
    
    public void find_codes(String digits, int idx, StringBuffer code, ArrayList<String> result)
    {
	if(idx >= digits.length()) 
	{
	    // store code to result
	    result.add(code.toString());
	    return; 
	}
	else
	{
	    Character[] array = map.get(digits.charAt(idx));
	    
	    for(int i = 0; i < array.length; i++)
	    {
		find_codes(digits, idx+1, code.append(array[i]), result);
		code.deleteCharAt(code.length()-1);
	    }
	}
    }
}
