import java.io.*;
import java.util.*;


class CustomSortString
{
    public static void main(String[] args)
    {
        System.out.println("=== Custom Sort String ===");
        Solution solution = new Solution();
        String S = "cba";
        String T = "abcd";
        System.out.println("S = "+S);
        System.out.println("T = "+T);
        System.out.println("custom sort = "+solution.customSortString(S, T));
    }
}


class Solution
{
    public String customSortString(String S, String T) {
        Map<Character, Integer> order = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            order.put(S.charAt(i), i);
        }

        // any chars not in S is considered larger
        char[] chars = T.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                char left = chars[i];
                char right = chars[j];

                if (!smaller(order, left, right)) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
        }

        return (new String(chars));
    }

    private boolean smaller(Map<Character, Integer> order,
                            char left, char right) {
        Integer order1 = order.get(left);
        Integer order2 = order.get(right);

        order1 = (order1 == null)?27:order1;
        order2 = (order2 == null)?27:order2;

        return (order1 <= order2);
    }
}
