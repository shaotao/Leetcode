import java.io.*;
import java.util.*;


class SimplifyPath
{
    public static void main(String[] args) {
	System.out.println("=== Simplify Path ===");

	Solution solution = new Solution();

	//String input = "/a/./b/..//../c/";
	//String input = "/home/of/foo/../../bar/../../is/./here/.";
	String input = "/..";

	String result = solution.simplifyPath(input);

	System.out.println("input = "+input);
	
	System.out.println("result = "+result);
    }
}


class Solution
{
    public Solution() {
    }
    
    public String simplifyPath(String path) {
	
	Stack<String> stack = new Stack<String>();

	StringTokenizer stok = new StringTokenizer(path, "/");
	
	while(stok.hasMoreTokens())
	{
	    // take the next token and place to the stack
	    String token = stok.nextToken();

	    //System.out.println("token = "+token);

	    if(token.equals("."))
	    {
		continue;
	    }
	    else if(token.equals(".."))
	    {
		if(!stack.empty()) 
		{
		    stack.pop();
		}
	    }
	    else
	    {
		stack.push(token);
	    }
	}

	// scan the stack for the path
	String result = "";

	while(!stack.empty())
	{
	    String item = stack.pop();

	    //System.out.println("item = "+item);
	    result = "/"+item+result;
	}

	if(result.equals(""))
	{
	    result = "/";
	}

	return result;
    }

}