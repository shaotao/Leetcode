import java.io.*;
import java.util.*;


class SolveTheEquation
{
    public static void main(String[] args)
    {
	System.out.println("=== Solve the Equation ===");
	Solution solution = new Solution();

        String[] inputs = { "x+5-3-x=6+x-2",
                            "x=x",
                            "2x=x",
                            "2x+3x-6x=x+2",
                            "x=x+2",
                            "-x=1"};
        for(String input:inputs) {
            System.out.println(">>>");
            System.out.println("Input: "+input);
            System.out.println("Output: "+solution.solveEquation(input));
        }
    }
}


class Solution
{
    public String solveEquation(String equation) {
        String ret = null;

        String[] sides = equation.split("=");
        //System.out.println("sides = "+Arrays.toString(sides));

        int[] result = parse(sides[0]);
        
        int left_x_factor = result[0];
        int left_constant = result[1];

        result = parse(sides[1]);
        int right_x_factor = result[0];
        int right_constant = result[1];
        
        //System.out.println(left_x_factor+", "+left_constant+", "+right_x_factor+","+right_constant);

        int x_factor = left_x_factor - right_x_factor;
        int constant = right_constant - left_constant;
        if(x_factor == 0 && constant == 0) {
            ret = "Infinite solutions";
        } else if(x_factor == 0 && constant != 0) {
            ret = "No solution";
        } else {
            ret = "x="+(constant/x_factor);
        }
        
        return ret;
    }

    public int[] parse(String part) {
        int[] ret = new int[]{0,0};
        int x_factor = 0;
        int constant = 0;
        
        StringBuffer buf = new StringBuffer();
        int sign = 1;
        for(char ch : part.toCharArray()) {
            if(ch == '+' || ch == '-') {
                if(buf.length() > 0) {
                    if(buf.charAt(buf.length()-1) == 'x') {
                        if(buf.length() > 1) {
                            x_factor += sign*Integer.parseInt(buf.substring(0, buf.length()-1));
                        } else {
                            x_factor += sign;
                        }
                    } else {
                        constant += sign*Integer.parseInt(buf.toString());
                    }
                }
                sign = ch=='+'?1:-1;
                buf = new StringBuffer();
            } else {
                buf.append(ch);
            }
        }

        if(buf.charAt(buf.length()-1) == 'x') {
            if(buf.length() > 1) {
                x_factor += sign*Integer.parseInt(buf.substring(0, buf.length()-1));
            } else {
                x_factor += sign;
            }
        } else {
            constant += sign*Integer.parseInt(buf.toString());
        }

        ret[0] = x_factor;
        ret[1] = constant;
        
        return ret;
    }
}
