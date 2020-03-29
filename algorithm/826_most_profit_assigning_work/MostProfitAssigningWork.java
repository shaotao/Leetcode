import java.io.*;
import java.util.*;


class MostProfitAssigningWork
{
    public static void main(String[] args)
    {
        System.out.println("=== Most Profit Assigning Work ===");
        Solution solution = new Solution();
        /*
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        */

        int[] difficulty = {13,37,58};
        int[] profit = {4,90,96};
        int[] worker = {34,73,45};

        System.out.println("difficulty = "+Arrays.toString(difficulty));
        System.out.println("profit = "+Arrays.toString(profit));
        System.out.println("worker = "+Arrays.toString(worker));
        System.out.println("max profit = "+solution.maxProfitAssignment(difficulty, profit, worker));
    }
}


class Solution
{
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;

        List<Integer> diffList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            int diff = difficulty[i];
            int prof = profit[i];
            if (map.containsKey(diff)) {
                prof = (prof > map.get(diff))?prof:map.get(diff);
            } else {
                diffList.add(diff);
            }
            map.put(diff, prof);
        }

        Collections.sort(diffList);
        int[] profArray = new int[diffList.size()];
        for (int i = 0; i < diffList.size(); i++) {
            profArray[i] = map.get(diffList.get(i));
        }

        int highest = profArray[0];
        for (int i = 0; i < profArray.length; i++) {
            if(profArray[i] < highest) {
                profArray[i] = highest;
            } else {
                highest = profArray[i];
            }
        }

        // use binary search to find the max diff matched by each worker
        // sum up the profit from map
        for (int workerAbility : worker) {
            int pos = findKey(diffList, 0, diffList.size()-1, workerAbility);
            if(pos >= 0) {
                maxProfit += profArray[pos];
            }
        }

        return maxProfit;
    }

    // find the index in list where list.get(idx) <= val and idx is the max
    private int findKey(List<Integer> list, int a, int b, int val) {
        if (b -a <= 1) {
            if (val < list.get(a)) { return -1; }
            else if (val >= list.get(a) && val < list.get(b)) {
                return a;
            } else {
                return b;
            }
        } else {
            int mid = (a+b)/2;
            if( val < list.get(mid)) {
                return findKey(list, a, mid, val);
            } else {
                return findKey(list, mid, b, val);
            }
        }
    }
}
