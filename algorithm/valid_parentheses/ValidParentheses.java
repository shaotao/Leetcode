import java.io.*;
import java.util.*;


class ValidParentheses
{
    public static void main(String args[])
    {
	Solution solution = new Solution();
	
	String s = "([]){[]}{()}";
	
	boolean result = solution.isValid(s);

	System.out.println("s = "+s);
	System.out.println("valid = "+result);
    }
}

class Solution
{
    public Solution()
    {
    }

    public boolean isValid(String s)
    {
	Stack<Character> stack = new Stack<Character>();

	for(int i = 0; i < s.length(); i++)
	{
	    char ch = s.charAt(i);

	    Character top = null;
	    if(stack.empty() == false)
	    {
		top = stack.peek();
	    }
	    
	    if(ch == '{' || ch == '[' || ch == '(')
	    {
		stack.push(new Character(ch));
	    }
	    else if(ch == '}')
	    {
		if(top == null || top.charValue() != '{')
		{
		    return false;
		}
		else
		{
		    stack.pop();
		}
	    }
	    else if(ch == ']')
	    {
		if(top == null || top.charValue() != '[')
		{
		    return false;
		}
		else
		{
		    stack.pop();
		}
	    }
	    else if(ch == ')')
	    {
		if(top == null || top.charValue() != '(')
		{
		    return false;
		}
		else
		{
		    stack.pop();
		}
	    }
	}

	return (stack.empty() == true);
    }
}