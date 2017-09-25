import java.io.*;
import java.util.*;


class ValidPalindromeII
{
    public static void main(String[] args)
    {
	System.out.println("=== Valid Palindrome II ===");
	Solution solution = new Solution();
        String[] input = {"aba", "abca", "deee", "cbbcc", "tcaac"};
        for (String s : input) {
            System.out.println("s = "+s+", valid palindrome = "+solution.validPalindrome(s));
        }
    }
}


class Solution
{
    public boolean validPalindrome(String s) {
        if (s == null) { return false; }
        if (s.length() <= 2) { return true; }
        if (check(s)) { return true; }

        // even
        int mid = (s.length()-1)/2;
        if (s.length()%2 == 1) {
            // ood
            return scan(s, mid-1, mid+1, s.length()-1, 0) || scan(s, mid-1, mid, s.length()-1, 1) || scan(s, mid, mid+1, s.length()-1, -1);
        } else {
            return scan(s, mid-1, mid+1, s.length()-1, 1) || scan(s, mid, mid+2, s.length()-1, -1);
        }
    }

    public boolean scan(String s, int left, int right, int maxIdx, int skip) {
        Stack<Character> stack = new Stack<>();
        boolean skipped = false;
        if(skip == 0) {
            for(int i = 0; i <= left; i++) {
                stack.push(s.charAt(i));
            }
            for(int i = right; i <= maxIdx; i++) {
                if(stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        } else if(skip == -1) {
            for (int i = maxIdx; i >= right; i--) {
                stack.push(s.charAt(i));
            }

            for(int i = left; i >= 0; i--) {
                if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    if(skipped) {
                        return false;
                    } else {
                        skipped = true;
                        continue;
                    }
                }
            }
            return stack.isEmpty();
        } else if(skip == 1) {
            for(int i = 0; i <= left; i++) {
                stack.push(s.charAt(i));
            }

            for(int i = right; i <= maxIdx; i++) {
                if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    if(skipped) {
                        return false;
                    } else {
                        skipped = true;
                        continue;
                    }
                }
            }
            return stack.isEmpty();
        } else {
            System.out.println("invalid skip value = "+skip);
            return false;
        }
    }

    public boolean check(String s) {
        if (s == null) { return false; }
        if (s.length() == 0) { return true; }

        int mid = (s.length()-1)/2;
        for (int i = 0; i <= mid; i++) {
            char left = s.charAt(i);
            char right = s.charAt(s.length()-1-i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
