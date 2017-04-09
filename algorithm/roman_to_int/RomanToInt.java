import java.io.*;
import java.util.*;


public class RomanToInt
{
    public static void main(String[] args)
    {
	System.out.println("=== Roman To Integer ===");

	//String s = "MMMDLXXXVI";
	String s = "MCCCLXVIII";
	
	Solution solution = new Solution();
	
	int result = solution.romanToInt(s);

	System.out.println("s = "+s);
	System.out.println("result = "+result);
    }
}


class Solution
{

    public Solution()
    {
    }

    public int romanToInt(String s)
    {
	int result = 0;

	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	map.put(new Character('I'), new Integer(1));
	map.put(new Character('V'), new Integer(5));
	map.put(new Character('X'), new Integer(10));
	map.put(new Character('L'), new Integer(50));
	map.put(new Character('C'), new Integer(100));
	map.put(new Character('D'), new Integer(500));
	map.put(new Character('M'), new Integer(1000));


	for(int i = 0; i < s.length(); i++)
	{
	    char ch = s.charAt(i);
	    
	    int value = 0;

	    if(i < s.length()-1 &&
	       map.get(new Character(ch)) < map.get(new Character(s.charAt(i+1))))
	    {
		value = map.get(new Character(s.charAt(i+1))) - map.get(new Character(ch));
		i += 1;
	    }
	    else
	    {
		value = map.get(new Character(ch));
	    }

	    result += value;
	}

	return result;
    }
}
