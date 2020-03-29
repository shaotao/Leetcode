import java.io.*;
import java.util.*;


class CountAndSay
{
    public static void main(String[] args) throws Exception
    {
        int n = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("n = ");

        n = Integer.parseInt(reader.readLine());

        Solution solution = new Solution();

        String result = solution.countAndSay(n);

        System.out.println("result = "+result);
    }
}

class Solution
{
    public String countAndSay(int n)
    {
        String result = "1";

        for(int i = 1; i < n; i++)
        {
            result = count_string(result);
        }

        return result;
    }

    public String count_string(String input)
    {
        String result = "";

        char curr_char = '\n';
        int count = 0;

        for(int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);

            if(count == 0)
            {
                curr_char = ch;
                count = 1;
            }
            else if(ch != curr_char)
            {
                result += ""+count+curr_char;
                curr_char = ch;
                count = 1;
            }
            else
            {
                count += 1;
            }
        }

        if(count > 0)
        {
            result += ""+count+curr_char;
        }

        return result;
    }
}
