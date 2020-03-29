import java.io.*;
import java.util.*;


class ExpressionAddOperators
{
    public static void main(String[] args)
    {
        System.out.println("=== Expression Add Operators ===");
        /*
        String[] strs = {"123",
                         "232",
                         "00",
                         "3456237490"}; */
        String[] strs = { "1234" };
        int[] nums = { 6,
                       8,
                       0,
                       9191
        };
        
        Solution solution = new Solution();

        for(int i = 0; i < strs.length; i++) {
            List<String> list = solution.addOperators(strs[i], nums[i]);
            System.out.print("\""+strs[i]+"\", "+nums[i]+" -> [");
            for(int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
                if(j < list.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

class Solution
{
    public List<String> addOperators(String input_str, int target)
    {
        ArrayList<String> ret = new ArrayList<String>();
        
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for(int i = 0; i < input_str.length(); i++) {
            nums.add(Integer.parseInt(input_str.charAt(i)+""));
        }

        if(nums.size() == 0) { return ret; }

        // dir: 1 - down, 0 - up
        int dir = 1;
        int curr = 0;
        // op: 1 +, 2 -, 3 *
        ArrayList<Integer> op_list = new ArrayList<Integer>();
        op_list.add(1);
        
        StringBuffer buf = new StringBuffer();
        String add = "+";
        String minus = "-";
        String times = "*";
        while(curr >= 0 && curr < nums.size()) {

            //System.out.println("buf = "+buf.toString());
            //System.out.println("curr = "+curr+", dir  = "+dir+", op = "+op_list.get(curr));
            
            int num = nums.get(curr);
            
            if(dir == 1) {
                int op = op_list.get(curr);
                // down
                if(op == 1) {
                    if(curr > 0) {
                        buf.append(add);
                    }
                } else if(op == 2) {
                    if(curr > 0) {
                        buf.append(minus);
                    }
                } else if(op == 3) {
                    if(curr > 0) {
                        buf.append(times);
                    }                    
                } else {
                    if(curr > 0) {
                        buf.append("");
                    }
                }
                buf.append(num);

                if(curr == nums.size()-1) {
                    // evaluate the value, add to ret if buf.toString() has a matched value
                    String tmp = buf.toString();
                    if(evaluate(tmp) == target) { ret.add(tmp); }
                    curr--;
                    System.out.println("get here 1");
                    dir = 0;
                } else {
                    curr++;
                    op_list.add(1);
                }
            } else {
                // up
                int op = op_list.get(curr+1);
                
                if(op == 1) {
                    curr++;
                    op_list.remove(op_list.size()-1);
                    op_list.add(2);
                    dir = 1;
                } else if (op == 2) {
                    curr++;
                    op_list.remove(op_list.size()-1);
                    op_list.add(3);
                    dir = 1;
                } else if (op == 3) {
                    curr++;
                    op_list.remove(op_list.size()-1);
                    op_list.add(4);
                    dir = 1;
                } else {
                    curr--;
                    System.out.println("get here 2");
                    op_list.remove(op_list.size()-1);
                    dir = 0;
                }

                // need to fix this
                // scan backwards to find the last operator
                int last_op_idx = -1;
                for(int i = buf.length()-1; i >= 0; i--) {
                    char ch = buf.charAt(i);
                    if(ch < '0' || ch > '9') {
                        last_op_idx = i;
                        break;
                    }
                }
                if(last_op_idx >= 0) {
                    buf.delete(last_op_idx, buf.length());
                }
            }
        }

        return ret;
    }

    public int evaluate(String str) {
        int ret = 0;

        System.out.println("str = "+str);

        // scan the operators
        int idx_op = -1;

        // get the '*' done
        idx_op = find_op(str, '*');
        while(idx_op >= 0) {

            int left = -1;
            int right = -1;
            
            // find the left number
            for(int i = idx_op-1; i >= 0; i--) {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    left = i;
                } else {
                    break;
                }
            }
            
            int a = Integer.parseInt(str.substring(left, idx_op));
            
            // find the right number
            for(int i = idx_op+1; i < str.length(); i++) {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    right = i;
                } else {
                    break;
                }
            }
            int b = Integer.parseInt(str.substring(idx_op+1, right+1));
            
            //System.out.println("str = "+str+", a = "+a+", b = "+b);

            // compute the product
            int product = a*b;

            // reset str
            str = str.substring(0, left)+product+str.substring(right+1);
            
            idx_op = find_op(str, '*');
        }

        // get the '+' and '-' done
        // op, 1 for plus, 0 for minus
        ret = 0;
        int op = 1;

        // find the next numbers
        int start = 0;
        StringBuffer buf = new StringBuffer("");
        int num = 0;
        for(int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                buf.append(ch);
            } else {

                num = Integer.parseInt(buf.toString());
                
                if(op == 1) {
                    ret += num;
                } else {
                    ret -= num;
                }
                
                if(ch == '+') {
                    op = 1;
                } else {
                    op = 0;
                }
                
                buf = new StringBuffer();
                start = i+1;
            }
        }

        // take the last number
        num = Integer.parseInt(buf.toString());
        if(op == 1) {
            ret += num;
        } else {
            ret -= num;
        }

        //System.out.println("ret = "+ret);
        return ret;
    }

    public int find_op(String str, char op_ch) {
        int idx = -1;
        
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == op_ch) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
}
