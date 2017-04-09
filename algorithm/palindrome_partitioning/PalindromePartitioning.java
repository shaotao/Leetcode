import java.io.*;
import java.util.*;


class PalindromePartitioning
{
    public static void main(String[] args)
    {
        System.out.println("=== Palindrome Partitioning ===");
        Solution solution = new Solution();
        //String s = "aab";
        String s = "bb";
        
        ArrayList<ArrayList<String>> result = solution.partition(s);
        
        System.out.println("s = "+s);
        System.out.println("# of palindromes = "+result.size());
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(i+") ");
            for(int j = 0; j < result.get(i).size(); j++)
            {
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}


class Solution
{
    public ArrayList<ArrayList<String>> partition(String s)
    {
        ArrayList<ArrayList<String>> ret;

        if(s == null || s.length() == 0) { return new ArrayList<ArrayList<String>>(); }

        // compute the matrx to store palindrome status from m to n
        int length = s.length();
        boolean[][] matrix = new boolean[length][length];

        for(int i = 0; i < length; i++)
        {
            for(int j = i; j < length; j++)
            {
                matrix[i][j] = isPalindrome(s, i, j);
            }
        }
        
        // now we have the matrix, try to create the palindrome
        ret = find_palindromes(matrix, s, 0, s.length()-1);
        
        return ret;
    }

    public boolean isPalindrome(String s, int start_idx, int end_idx)
    {
        if(s == null || start_idx < 0 || end_idx < 0 || end_idx < start_idx ||
           start_idx >= s.length() || end_idx >= s.length())
        {
            return false;
        }

        for(int i = start_idx; i <= (start_idx+end_idx)/2; i++)
        {
            if(s.charAt(i) != s.charAt(end_idx-(i-start_idx)))
            {
                return false;
            }
        }

        return true;
    }
    
    public ArrayList<ArrayList<String>> find_palindromes(boolean[][] matrix, String s, int start_idx, int end_idx)
    {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        
        for(int i = start_idx; i <= end_idx; i++)
        {
            if(matrix[start_idx][i] == false) { continue; }
            
            ArrayList<ArrayList<String>> tmp = find_palindromes(matrix, s, i+1, end_idx);
            
            String head = s.substring(start_idx, i+1);

            if(tmp.size() > 0)
            {
                for(int j = 0; j < tmp.size(); j++)
                {
                    ArrayList<String> list = tmp.get(j);
                    list.add(0, head);
                    ret.add(list);
                }
            }
            else
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(head);
                ret.add(list);
            }
        }

        return ret;
    }
}
