import java.io.*;
import java.util.*;


class BasicCalculator
{
    public static void main(String[] args)
    {
        System.out.println("=== Basic Calculator ===");
        Solution solution = new Solution();
        String[] inputs = { "1 + 1",
                            " 2-1 + 2 ",
                            "(1+(4+5+2)-3)+(6+8)",
                            "2-(5-6)",
                            "(5-(1+(5)))" };

        for(String input:inputs) {
            int ret = solution.calculate(input);
            System.out.println("input = \""+input+"\", result = "+ret);
        }
    }
}

class Solution
{
    public int calculate(String s)
    {
        int ret = 0;

        if(s == null || s.length() == 0) { return 0; }
        
        boolean with_parentheses = true;
        while(with_parentheses) {
            with_parentheses = false;
            StringBuffer buf = new StringBuffer();
            StringBuffer next = new StringBuffer();
            int length = s.length();
            for(int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if(ch == '(' || ch == ')') { with_parentheses = true; }

                if(ch == '(') {
                    // put buf contents to next
                    next.append(buf);

                    // reset buf
                    buf = new StringBuffer();

                    // append the '('
                    buf.append(ch);
                } else if (ch == ')') {
                    buf.append(ch);
                    if(buf.charAt(0) == '(') {
                        int val = compute(buf.substring(1, buf.length()-1));
                        
                        // append the value to next
                        if(val < 0 && next.length() > 0) {
                            int last_idx = next.length()-1;
                            if(next.charAt(last_idx) == '+') {
                                next.setCharAt(last_idx, '-');
                            } else if(next.charAt(last_idx) == '-') {
                                next.setCharAt(last_idx, '+');
                            }
                            next.append(-1*val);
                        } else {
                            next.append(val);
                        }
                        // reset buf
                        buf = new StringBuffer();
                    } else {
                        next.append(buf);
                        buf = new StringBuffer();
                    }
                } else if (ch != ' ') {
                    buf.append(ch);
                }
            }

            if(buf.length() > 0) { next.append(buf); }

            s = next.toString();
            //System.out.println("s = "+s);
        }

        if(!with_parentheses) {
            // do final round of computation
            ret = compute(s);
        } else {
            System.out.println("Solution.calculate() error: here, with_parentheses should be false!");
        }

        return ret;
    }


    public int compute(String s)
    {
        //System.out.println("s = "+s);
        // compute value with parentheses in buf
        int val = 0;
        boolean add = true;
        StringBuffer num_buf = new StringBuffer();
        for(int j = 0; j < s.length(); j++) {
            char num_ch = s.charAt(j);
            if(num_ch == '+') {
                int num = Integer.parseInt(num_buf.toString());
                if(add) {
                    val += num;
                } else {
                    val -= num;
                }
                num_buf = new StringBuffer();
                add = true;
            } else if(num_ch == '-') {
                //System.out.println("num_buf = "+num_buf);
                int num = 0;
                if(num_buf.length() > 0) {
                    num = Integer.parseInt(num_buf.toString());
                }
                if(add) {
                    val += num;
                } else {
                    val -= num;
                }
                num_buf = new StringBuffer();
                add = false;
            } else {                            
                num_buf.append(num_ch);
                //System.out.println("num_buf = "+num_buf);
            }
            
            if(j == s.length()-1) {
                int num = Integer.parseInt(num_buf.toString());
                if(add) { val += num; }
                else { val -= num; }
            }
        }
        
        return val;
    }
}
