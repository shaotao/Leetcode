import java.io.*;
import java.util.*;


class RemoveInvalidParentheses
{
    public static void main(String[] args)
    {
        System.out.println("=== Remove Invalid Parentheses ===");
        Solution solution = new Solution();

        String[] inputs = {"()())()", "(a)())()", ")("};
        for(String s : inputs) {
            List<String> list = solution.removeInvalidParentheses(s);
            System.out.print("\""+s+"\" -> [");
            for(int i = 0; i < list.size(); i++) {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
                if(i < list.size()-1) { System.out.print(", "); }
            }
            System.out.println("]");
        }
    }
}


class Solution
{
    // return all possible cases of valid parentheses after
    // removing the minimum number of invalid parentheses
    // in the minimum case, return an empty string
    public List<String> removeInvalidParentheses(String s)
    {
        ArrayList<String> list = new ArrayList<String>();

        if(s == null || s.length() == 0) {
            list.add("");
            return list;
        }
        
        for(int i = 0; i < s.length(); i++) {
            
        }
        
        return list;
    }
}

