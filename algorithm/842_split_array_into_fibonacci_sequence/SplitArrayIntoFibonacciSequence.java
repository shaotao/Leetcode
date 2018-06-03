import java.io.*;
import java.util.*;


class SplitArrayIntoFibonacciSequence
{
    public static void main(String[] args)
    {
        System.out.println("=== Split Array Into Fibonacci Sequence ===");
        Solution solution = new Solution();
        String[] input = {"123456579",
                          "11235813",
                          "112358130",
                          "0123",
                          "1101111",
                          "5511816597",
                          "214748364721474836422147483641",
                          "74912134825162255812723932620170946950766784234934",
                          "8017845263139625601504939167222569939800814238688804524532962429184535712885446977154920361867928081"};
        for (String S : input) {
            List<Integer> ret = solution.splitIntoFibonacci(S);
            System.out.println("S = "+S);
            System.out.println("ret = "+ret);
        }
    }
}


class Solution
{
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<Integer>();

        int maxSplits = S.length()-1;

        // number of splits from 2 to maxSplits
        for (int i = 2; i <= maxSplits; i++) {
            boolean found = search(S, 0, ret, i+1, 1);
            if (found) {
                break;
            }
        }
        
        return ret;
    }

    // recursive function to split S and check condition.
    private boolean search(String S, int startIdx, List<Integer> ret, int total, int curr) {
        if (startIdx >= S.length() || curr > total) {
            return false;
        }

        if (curr == total) {
            String item = S.substring(startIdx);
            if (item.startsWith("0") && item.length() > 1) {
                return false;
            }
            try {
                ret.add(Integer.parseInt(item));
            } catch (Exception e) {
                return false;
            }
            if (valid(ret)) {
                return true;
            } else {
                ret.remove(ret.size()-1);
            }
        } else {
            for (int i = startIdx; i < S.length() && i < (startIdx+10); i++) {
                String item = S.substring(startIdx, i+1);

                if (curr > 2) {
                    if (item.length() < (""+ret.get(ret.size()-1)).length() ||
                        item.length() < (""+ret.get(ret.size()-2)).length() ||
                        (item.length() > ((""+ret.get(ret.size()-1)).length()+1) && item.length() > ((""+ret.get(ret.size()-2)).length()+1))) {
                        continue;
                    }
                }

                if (item.startsWith("0") && item.length() > 1) {
                    continue;
                }
                
                int val = -1;
                try {
                    val = Integer.valueOf(item);
                } catch (Exception e) {
                    continue;
                }
                if ((curr > 2) &&
                    (val != ret.get(ret.size()-1) + ret.get(ret.size()-2))) {
                    continue;
                }
                
                ret.add(Integer.valueOf(item));
                    
                // need more splits
                boolean found = search(S, i+1, ret, total, curr+1);
                if(found) {
                    return true;
                }
                
                ret.remove(ret.size()-1);
            }
        }

        return false;
    }

    private boolean valid(List<Integer> ret) {
        if (ret == null || ret.size() < 3) {
            return false;
        }

        for (int i = 0; i < ret.size()-2; i++) {
            if (ret.get(i) + ret.get(i+1) != ret.get(i+2)) {
                return false;
            }
        }
        return true;
    }
}
