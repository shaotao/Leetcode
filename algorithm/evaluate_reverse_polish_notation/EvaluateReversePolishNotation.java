import java.io.*;
import java.util.*;


class EvaluateReversePolishNotation
{
    public static void main(String[] args)
    {
	System.out.println("=== Evaluate Reverse Polish Notation ===");

	String[] tokens = {"4", "13", "5", "/", "+"};
	
	Solution solution = new Solution();
	
	int result = solution.evalRPN(tokens);
	
	System.out.print("input = ");
	for(int i = 0; i < tokens.length; i++)
	{
	    System.out.print(tokens[i]+" ");
	}
	System.out.println();

	System.out.println("output = "+result);
    }
}


class Solution
{
    public int evalRPN(String[] tokens)
    {
	int result = 0;
	
	Stack<Integer> stack = new Stack<Integer>();
	
	for(int i = 0; i < tokens.length; i++)
	{
	    String token = tokens[i];
	    
	    if( token.equals("+") || token.equals("-") ||
	        token.equals("*") || token.equals("/") )
	    {
		// get two elements from stack
		int b = stack.pop();
		int a = stack.pop();

		// compute value
		if(token.equals("+"))
		{
		    result = a+b;
		}
		else if(token.equals("-"))
		{
		    result = a-b;
		}
		else if(token.equals("*"))
		{
		    result = a*b;
		}
		else
		{
		    result = a/b;
		}

		// push back to stack
		stack.push(result);
	    }
	    else
	    {
		int num = Integer.parseInt(token);
		stack.push(num);
	    }
	}
	
	return stack.pop();
    }
}
