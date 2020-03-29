import java.io.*;
import java.util.*;


class LetterCasePermutation
{
    public static void main(String[] args)
    {
        System.out.println("=== Letter Case Permutation ===");
        Solution solution = new Solution();
        String[] input = {"a1b2", "3z4", "12345", ""};
        for (String S : input) {
            List<String> list = solution.letterCasePermutation(S);
            System.out.println("S = "+S);
            System.out.println("list = "+list);
        }
    }
}


class Solution
{
    public List<String> letterCasePermutation(String S) {
        List<String> ret= new ArrayList<>();
        if (S == null) { return ret; }
        List<StringBuffer> list = new ArrayList<>();
        StringBuffer buf = new StringBuffer();
        list.add(buf);
        loop(S, 0, list);

        list.forEach((StringBuffer b) -> ret.add(b.toString()));
        return ret;
    }

    private void loop(String S, int idx, List<StringBuffer> list) {
        if (idx >= S.length()) { return; }

        int size = list.size();
        char ch = S.charAt(idx);
        if ( ch >= 65 && ch <= 90) {
            for (int i = 0; i < size; i++) {
                StringBuffer newBuf = new StringBuffer(list.get(i));
                list.get(i).append(ch);
                newBuf.append((char)(ch+32));
                list.add(newBuf);
            }
        } else if (ch >= 97 && ch <= 122) {
            for (int i = 0; i < size; i++) {
                StringBuffer newBuf = new StringBuffer(list.get(i));
                list.get(i).append(ch);
                newBuf.append((char)(ch-32));
                list.add(newBuf);
            }
        } else {
            for (int i = 0; i < size; i++) {
                list.get(i).append(ch);
            }
        }
        
        loop(S, idx+1, list);
    }
}
