import java.io.*;
import java.util.*;


class DecodeString
{
    public static void main(String[] args)
    {
	System.out.println("=== Decode String ===");
	Solution solution = new Solution();

        String[] input = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
        for(String s:input) {
            System.out.println("s = "+s+", decodeString = "+solution.decodeString(s));
        }
    }
}


class Solution
{
    public String decodeString(String s)
    {
        while(s.contains("[")) {

            int left_bracket_idx = s.indexOf('[');
            int right_bracket_idx = -1;
            int count = 0;
            for(int i = left_bracket_idx; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '[') { count++; }
                else if(ch == ']') {
                    count--;
                    if(count == 0) {
                        right_bracket_idx = i;
                        break;
                    }
                }
            }

            // find the number before [
            int num_start_idx = 0;
            for(int i = left_bracket_idx-1; i >= 0; i--) {
                char ch = s.charAt(i);
                if(ch >= '0' && ch <='9') {
                    num_start_idx = i;
                } else { break; }
            }

            int repeat = Integer.parseInt(s.substring(num_start_idx, left_bracket_idx));

            String temp = s.substring(left_bracket_idx+1, right_bracket_idx);

            //System.out.println("repeat = "+repeat+", temp = "+temp);

            String middle = "";
            for(int i = 0; i < repeat; i++) {
                middle += temp;
            }

            s = s.substring(0, num_start_idx)+middle+s.substring(right_bracket_idx+1);

            //System.out.println("s = "+s);
        }

        return s;
    }
}
