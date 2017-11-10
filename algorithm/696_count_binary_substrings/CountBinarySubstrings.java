import java.io.*;
import java.util.*;


class CountBinarySubstrings
{
    public static void main(String[] args)
    {
        System.out.println("=== Count Binary Substrings ===");
        Solution solution = new Solution();
        String[] input ={"00110011", "10101", "000111000"};
        Arrays.asList(input).stream().forEach(s -> System.out.println(s+": "+solution.countBinarySubstrings(s)));
    }
}


class Solution
{
    public int countBinarySubstrings(String s) {
        int count = 0;
        List<Integer> splits = new ArrayList<>();
        
        // find the split locations
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) {
                splits.add(i);
            }
        }

        // for each split
        // 10 positive, 01 negative
        for (int i : splits) {
            char lead = s.charAt(i);

            int left = i; int right = i+1;
            for (int j = 0; j <= i; j++) {
                left = i-j;
                right = (i+1)+j;
                if(right >= s.length() || s.charAt(left) != lead || s.charAt(right) == lead) {
                    break;
                }

                count++;
            }
        }
        
        return count;
    }
}
