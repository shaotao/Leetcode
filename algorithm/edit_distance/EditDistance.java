import java.io.*;
import java.util.*;


class EditDistance
{
    public static void main(String[] args)
    {
        System.out.println("=== Edit Distance ===");
        Solution solution = new Solution();
        
        //String word1 = "hello";
        //String word2 = "world";

        String word1 = "dinitrophenylhydrazine";
        String word2 = "acetylphenylhydrazine";

        //String word1 = "";
        //String word2 = "a";

        int result = solution.minDistance(word1, word2);
        
        System.out.println("word1 = "+word1);
        System.out.println("word2 = "+word2);
        
        System.out.println("min distance = "+result);
    }
}


class Solution
{
    public int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();

        int[][] d = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++)
        {
            d[i][0] = i;
        }

        for(int j = 0; j <= n; j++)
        {
            d[0][j] = j;
        }

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    d[i][j] = d[i-1][j-1];
                }
                else
                {
                    int num1 = 1 + d[i-1][j];
                    int num2 = 1 + d[i][j-1];
                    int num3 = 1 + d[i-1][j-1];
                    
                    d[i][j] = Math.min(num1, num2);
                    d[i][j] = Math.min(d[i][j], num3);
                }
            }
        }

        return d[m][n];
    }

    public int minDistance2(String word1, String word2)
    {
        System.out.println(word1+" : "+word2);

        // result to convert word1 to word2
        int result = 0;
        
        // check the condition of word1 and word2
        if(word2.length() == 0)
        {
            // word2 is empty, we can only delete
            result = word1.length();
        }
        else if(word1.length() == 0)
        {
            // word1 is empty, we can only insert.
            result = word2.length();
        }
        else
        {
            // both word1 and word2 are not empty, insert, delete or replace

            if(word1.charAt(0) == word2.charAt(0))
            {
                // the first letter of word1 and word2 are equal
                return minDistance(word1.substring(1), word2.substring(1));
            }
            else
            {
                // the first letter of word1 and word2 are not equal
                // 1. insert
                int num1 = 1 + minDistance(word1, word2.substring(1));
                
                // 2. delete
                int num2 = 1 + minDistance(word1.substring(1), word2);
                
                // 3. replace
                int num3 = 1 + minDistance(word1.substring(1), word2.substring(1));
                result = Math.min(num1, num2);
                result = Math.min(result, num3);                
            }
        }
                
        return result;
    }
}

