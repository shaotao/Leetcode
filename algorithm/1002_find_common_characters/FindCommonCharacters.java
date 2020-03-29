import java.io.*;
import java.util.*;


class FindCommonCharacters
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Common Characters ===");
        Solution solution = new Solution();
        String[][] input = {{"bella", "label", "roller"},
                            {"cool", "lock", "cook"}};
        for (String[] A : input) {
            List<String> ret = solution.commonChars(A);
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("common chars = "+ret);
        }
    }
}


class Solution
{
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        int[][] matrix = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                int pos = A[i].charAt(j)-'a';
                matrix[i][pos] += 1;
            }
        }

        int[] array = new int[26];
        for (int j = 0; j < 26; j++) {
            int min = matrix[0][j];
            for (int i = 0; i < A.length; i++) {
                min = (min > matrix[i][j])?matrix[i][j]:min;
            }
            array[j] = min;
        }

        //System.out.println("matrix = "+Arrays.deepToString(matrix));
        //System.out.println("array = "+Arrays.toString(array));
        
        for (int i = 0; i < 26; i++) {
            if (array[i] == 0) { continue; }
            String s = ""+((char)('a'+i));
            for (int j = 0; j < array[i]; j++) {
                ret.add(s);
            }
        }
        
        return ret;
    }
}
