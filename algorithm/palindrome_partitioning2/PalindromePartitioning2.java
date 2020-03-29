import java.io.*;
import java.util.*;


class PalindromePartitioning2
{
    public static void main(String[] args)
    {
        System.out.println("=== Palindrome Partitioning II ===");
        Solution solution = new Solution();
        //String s = "aab";
        //String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String s = "ababbbabbaba";
        //String s = "bb";
        //String s = "a";
        //String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        //String s = "abcdefghijklmnopqrstuvwxyz";
        String s = "cbbbcc";
        
        int result = solution.minCut(s);
        
        System.out.println("s = "+s);
        System.out.println("min cut = "+result);
    }
}


class Solution
{
    public int minCut(String s)
    {
        if(s == null || s.length() <= 1)
        {
            return 0;
        }
        
        int size = s.length();
        boolean[][] matrix = new boolean [size][size];
        
        build_matrix(matrix, s);
        
        // compute the min_cut_array
        int[] array = new int[size];
        build_array(size, matrix, array);

        return array[size-1];
    }

    public void build_matrix(boolean[][] matrix, String s)
    {
        int size = s.length();

        for(int row = size-1; row >= 0; row--)
        {
            for(int col = row; col < size; col++)
            {
                boolean ret = false;
                if(row == col) { ret = true; }
                else if(col - row == 1) { ret = (s.charAt(row) == s.charAt(col)); }
                else { ret = ( (s.charAt(row) == s.charAt(col)) && matrix[row+1][col-1] ); }
                
                matrix[row][col] = ret;
            }
        }
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
    
    public void build_array(int size, boolean[][] matrix, int[] array)
    {
        for(int i = 0; i < size; i++) 
        { 
            array[i] = 0;
            
            boolean first = true;
            for(int j = i; j >= 0; j--)
            {
                if(matrix[j][i] == true)
                {
                    if(j == 0) { array[i] = 0; }
                    else
                    {
                        if(first == true)
                        { 
                            array[i] = 1+array[j-1];
                            first = false;    
                        }
                        else
                        {
                            if(array[i] > 1+array[j-1])
                            {
                                array[i] = 1+array[j-1];
                            }
                        }
                    }
                }
            }
        }
    }
}
