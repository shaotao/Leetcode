import java.io.*;
import java.util.*;


class LongestPalindrome
{
    public static void main(String[] args)
    {
	System.out.println("=== Longest Palindrome ===");
	Solution solution = new Solution();

        //String s = "abccccdd";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println("s = "+s+", longest palindrome = "+solution.longestPalindrome(s));
    }
}


class Solution
{
    // all even counts + all (odd counts -1) + 1 if there is odd
    public int longestPalindrome(String s) {
        int ret = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()) {
            int count = 1;
            if(map.containsKey(ch)) {
                count += map.get(ch); 
            }
            map.put(ch, count);
        }

        int hasOdd = 0;
        for(Character ch : map.keySet()) {
            int count = map.get(ch);
            if(count%2 == 0) { ret += count; }
            else {
                hasOdd = 1;
                ret += count-1;
            }
        }
        ret += hasOdd;
        
        return ret;
    }
}
