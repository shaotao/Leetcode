import java.io.*;
import java.util.*;


class IsSubsequence
{
    public static void main(String[] args)
    {
	System.out.println("=== Is Subsequence ===");
	Solution solution = new Solution();

        String[] input = {"abc", "ahbgdc", "axc", "ahbgdc", "acb", "ahbgdc"};

        for(int i = 0; i < input.length/2; i++) {
            String s = input[2*i]; String t = input[2*i+1];
            System.out.println("s = "+s+", t = "+t+", isSequence = "+solution.isSubsequence(s, t));
        }
    }
}


class Solution
{
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) { return false; }

        HashMap<Character, ArrayList<Integer>> map_t = new HashMap<Character, ArrayList<Integer>>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!map_t.containsKey(ch)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map_t.put(ch, list);
            } else {
                map_t.get(ch).add(i);
            }
        }

        int bar = -1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ArrayList<Integer> list = map_t.get(ch);
            if(list == null) { return false; }
            boolean pass = false;
            for(Integer k: list) {
                if(k > bar) { pass = true; bar = k; break; }
            }

            if(pass == false) { return false; }
        }
        
        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        if(s == null || t == null) { return false; }

        HashMap<Character, ArrayList<Integer>> map_t = new HashMap<Character, ArrayList<Integer>>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!map_t.containsKey(ch)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map_t.put(ch, list);
            } else {
                map_t.get(ch).add(i);
            }
        }

        int bar = -1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ArrayList<Integer> list = map_t.get(ch);
            if(list == null) { return false; }
            int larger = findLarger(list, bar);

            if(larger == -1) { return false; }
            else { bar = larger; }
        }
        
        return true;
    }
    
    // find the smaller number larger than k in sorted list
    // assume that all numbers in list are >= 0
    int findLarger(ArrayList<Integer> list, int k) {
        int ret = -1;
        if(list == null || list.size() == 0) { return -1; }
        int left = 0;
        int right = list.size()-1;

        while(left <= right) {
            if(right - left <= 1) {
                if(list.get(left) > k) { return list.get(left); }
                else if(list.get(right) > k) { return list.get(right); }
                else { return -1; }
            } else {
                int mid = (left+right)/2;
                if(list.get(left) > k) { return left; }
                else if(list.get(mid) > k) { right = mid; }
                else { left = mid; }
            }
        }

        return -1;
    }
}
