import java.io.*;
import java.util.*;


class CombinationSum3
{
    public static void main(String[] args)
    {
        System.out.println("=== Combination Sum III ===");
        Solution solution = new Solution();
        int k = 3;
        int n = 9;
        List<List<Integer>> list = solution.combinationSum3(k, n);

        System.out.println("k = "+k+", n = "+n);
        print_result(list);
    }

    public static void print_result(List<List<Integer>> list) {
        System.out.print("[");
        for(int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            System.out.print("[");
            for(int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j));
                if(j < l.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i < list.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");        
    }
}

class Solution
{
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

        if(n < 1 || n > 45) { return list; }

        int[] array = new int[9];
        for(int i = 0; i < 9; i++) { array[i] = 0; }

        select(k, n, array, 0, 0, 0, list);
        
        return list;
    }

    public void select(int k, int n, int[] array, int idx, int count, int sum, ArrayList<List<Integer>> list) {
        if(idx >= array.length || count >= k || sum > n) { return; }

        for(int i = idx; i < array.length; i++) {
            array[i] = 1;
            count++;
            sum += (i+1);

            boolean should_break = false;
            
            if(sum < n) {
                select(k, n, array, i+1, count, sum, list);
            } else {
                if(count == k && sum == n) {
                    ArrayList<Integer> one_result = new ArrayList<Integer>();
                    for(int j = 0; j < array.length; j++) {
                        if(array[j] == 1) {
                            one_result.add(j+1);
                        }
                    }
                    list.add(one_result);
                }
                should_break = true;
            }

            array[i] = 0;
            count--;
            sum -= (i+1);
            if(should_break) { break; }
        }
    }
}
