import java.io.*;
import java.util.*;


class DifferentWaysToAddParentheses
{
    public static void main(String[] args)
    {
        System.out.println("=== Different Ways to Add Parentheses ===");
        Solution solution = new Solution();
        String[] inputs = {"2-1-1", "2*3-4*5"};

        for(String input: inputs) {
            List<Integer> list = solution.diffWaysToCompute(input);
            System.out.print("input = \""+input+"\", output = [");
            
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if(i < list.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}


class Solution
{
    public List<Integer> diffWaysToCompute(String input) {
        input = input.trim();
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        // if input is null or empty, return empty list
        if(input == null || input.length() == 0) { return list; }

        // ok, input is not null or empty
        // find operator one by one, split the list
        // get left and right lists, combine using operator
        // return the list
        // if there is not operator, cast the input as integer
        // and return it in a list
        boolean split = false;
        int sign = 0;
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == '+') {
                split = true;
                sign = 1;
                List<Integer> left_list = diffWaysToCompute(input.substring(0, i));
                List<Integer> right_list = diffWaysToCompute(input.substring(i+1));

                for(Integer a:left_list) {
                    for(Integer b:right_list) {
                        list.add(a+b);
                    }
                }
            } else if(ch == '-') {
                split = true;
                sign = 2;
                List<Integer> left_list = diffWaysToCompute(input.substring(0, i));
                List<Integer> right_list = diffWaysToCompute(input.substring(i+1));

                for(Integer a:left_list) {
                    for(Integer b:right_list) {
                        list.add(a-b);
                    }
                }
            } else if (ch == '*') {
                split = true;
                sign = 3;
                List<Integer> left_list = diffWaysToCompute(input.substring(0, i));
                List<Integer> right_list = diffWaysToCompute(input.substring(i+1));

                for(Integer a:left_list) {
                    for(Integer b:right_list) {
                        list.add(a*b);
                    }
                }
            }
        }

        if(!split) {
            list.add(Integer.parseInt(input));
        }
        
        return list;
    }
}
