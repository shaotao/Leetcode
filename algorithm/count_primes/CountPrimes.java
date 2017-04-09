import java.io.*;
import java.util.*;


class CountPrimes
{
    public static void main(String[] args)
    {
        System.out.println("=== Count Primes ===");
        Solution solution = new Solution();
        //int[] nums = {5000000, 0, 2, 3, 5};
        int[] nums = {5};

        for(int n: nums) {
            int ret = solution.countPrimes(n);
            System.out.println("there are "+ret+" primes < "+n);
        }
    }
}

class Solution
{
    public int countPrimes(int n) {
        int ret = 0;

        if(n <= 2) { return 0; }
        
        boolean[] array = new boolean[n+1];
        for(int i = 0; i <= n; i++) {
            array[i] = true;
        }

        array[1] = false;
        array[2] = true;
        for(int i = 2; i <= n; i++) {
            if(array[i] == false) { continue; }

            int num = n/i;
            for(int j = 2; j <= num; j++) {
                array[i*j] = false;
            }
        }

        for(int i = 1; i < n; i++) {
            if(array[i]) { ret++; }
        }

        return ret;
    }
    
    public int countPrimes2(int n) {
        ArrayList<Integer> primes = new ArrayList<Integer>();

        if(n <= 1) { return 0; }
        
        for(int i = 2; i < n; i++) {
            boolean is_prime = true;
            for(int prime: primes) {
                if(i%prime == 0) {
                    is_prime = false;
                    break;
                }
            }
            if(is_prime) {
                primes.add(i);
            }
        }

        return primes.size();
    }
}
