import java.io.*;
import java.util.*;


class UglyNumberII
{
    public static void main(String[] args)
    {
        System.out.println("=== Ugly Number II ===");
        Solution solution = new Solution();

        int num = 1500;

        for(int i = 1; i <= num; i++) {
            System.out.println(i+"th ugly number = "+solution.nthUglyNumber(i));
        }
    }
}

class Solution
{
    public int nthUglyNumber(int n)
    {
        if(n <= 0 || n > Math.pow(2, 31)) {
            System.out.println("invalid n = "+n);
            return 0;
        }

        int max = 31;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num = 0; num <= max; num++) {
            for(int i = num; i >= 0; i--) {
                for(int j = num-i; j >= 0; j--) {
                    int k = num-j-i;

                    double tmp = (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k));
                    if(tmp <= Math.pow(2, 31)) {
                        int val = (int) (tmp);
                        
                        int idx = add_to_list(list, val);

                        if(idx >= (n-1) && i == num) {
                            return list.get(n-1);
                        }
                    }
                }
            }
        }
        
        return 0;
    }

    public int add_to_list(ArrayList<Integer> tmp, int val) {
        if(tmp == null || val <= 0) { return -1; }

        //System.out.println("add "+val);
        
        boolean added = false;
        for(int i = 0; i < tmp.size(); i++) {
            if(tmp.get(i) > val) {
                tmp.add(i, val);
                added = true;
                return i;
            }
        }

        if(!added) {
            tmp.add(val);
        }

        return (tmp.size()-1);
    }
}
