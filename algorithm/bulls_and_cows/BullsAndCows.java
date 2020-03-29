import java.io.*;
import java.util.*;

class BullsAndCows
{
    public static void main(String[] args)
    {
        System.out.println("=== Bulls and Cows ===");
        Solution solution = new Solution();

        String secret = "1807";
        String guess = "7810";

        String hint = solution.getHint(secret, guess);
        System.out.println("secret = "+secret);
        System.out.println("guess = "+guess);
        System.out.println("hint = "+hint);
    }
}


class Solution
{
    public String getHint(String secret, String guess) {
        int hit = 0;
        int miss = 0;

        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        if(secret == null || guess == null || secret.length() == 0 ||
           guess.length() == 0 || secret.length() != guess.length()) {
            hit = 0;
            miss = 0;
        } else {
            for(int i = 0; i < secret.length(); i++) {
                if(guess.charAt(i) == secret.charAt(i)) {
                    hit++;
                }

                // update map1
                char ch1 = secret.charAt(i);
                int num1 = Integer.parseInt(""+ch1);
                if(!map1.containsKey(num1)) {
                    map1.put(num1, 1);
                } else {
                    map1.put(num1, map1.get(num1)+1);
                }

                // update map2
                char ch2 = guess.charAt(i);
                int num2 = Integer.parseInt(""+ch2);
                if(!map2.containsKey(num2)) {
                    map2.put(num2, 1);
                } else {
                    map2.put(num2, map2.get(num2)+1);
                }
            }

            System.out.println("map1.size() = "+map1.size());
            System.out.println("map2.size() = "+map2.size());
            
            // compute the total number of digits that match
            int total = 0;
            for(int i = 0; i <= 9; i++) {
                if(map1.containsKey(i) && map2.containsKey(i)) {
                    total += (map1.get(i) <= map2.get(i))?map1.get(i):map2.get(i);
                }
            }

            miss = total - hit;
        }

        return hit+"A"+miss+"B";
    }
}
