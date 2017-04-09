import java.io.*;
import java.util.*;


class CoinChange
{
    public static void main(String[] args)
    {
	System.out.println("=== Coin Change ===");
	Solution solution = new Solution();

        int[][] array_coins = {{1,2,5}, {2}, {431,62,88,428}, {1}};
        int[] array_amount = {11, 3, 9084, 0};

        int size = array_coins.length;
        
        for (int i = 0; i < size; i++) {
            int[] coins = array_coins[i];
            int amount = array_amount[i];

            System.out.println(">>> example "+(i+1));
            System.out.println("coins: "+Arrays.toString(coins));
            System.out.println("amount = "+amount);

            System.out.println("min # of coins = "+solution.coinChange(coins, amount));
        }
    }
}


class Solution
{
    public int coinChange(int[] coins, int amount)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, 0);
        if(coins == null || coins.length == 0 || amount < 0) { return -1; }

        // put individual coins to map
        for (int coin: coins) { map.put(coin, 1); }

        // start to build up map
        for (int num = 1; num <= amount; num++) {
            int min = -1;
            // do the split
            for(int coin: coins) {
                if(map.get(num-coin) == null) {
                    continue;
                }

                int tmp = map.get(num-coin) + 1;
                if(min == -1 || min > tmp) { min = tmp; }
            }

            if(min != -1) {
                map.put(num, min);
            }
        }

        Integer ret = map.get(amount);
        return (ret == null)?-1:ret;
    }
}
