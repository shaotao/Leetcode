import java.io.*;
import java.util.*;


class FizzBuzz
{
    public static void main(String[] args)
    {
        System.out.println("=== Fizz Buzz===");
        Solution solution = new Solution();
        int n = 15;        
        System.out.println("FizzBuzz("+n+"): "+solution.fizzBuzz(n));
    }
}


class Solution
{
    public List<String> fizzBuzz(int n)
    {
        ArrayList<String> l = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            String s = ""; 
            if(i%3 == 0) { s = "Fizz"; } 
            if(i%5 == 0) { s += "Buzz"; }
            if(s.length() == 0) { s = ""+i; }

            l.add(s);
        }
        return l;
    }
}
