import java.io.*;
import java.util.*;


class KEmptySlots
{
    public static void main(String[] args)
    {
	System.out.println("=== K Empty Slots ===");
	Solution solution = new Solution();
        int[][] arrayFlowers = {{1, 3, 2}, {1,2,3}};
        int[] arrayK= {1, 1};
        for(int i = 0; i < arrayFlowers.length; i++) {
            int[] flowers = arrayFlowers[i];
            int k = arrayK[i];
            System.out.println("flowers = "+Arrays.toString(flowers));
            System.out.println("k = "+k);
            System.out.println("output = "+solution.kEmptySlots(flowers, k));
        }
    }
}


class Solution
{
    public int kEmptySlots(int[] flowers, int k) {

        List<Integer> list = new ArrayList<>();

        // use binary search to insert to list and find the gap
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i];
            if (insert(list, 0, list.size()-1, pos, k)) {
                return (i+1);
            }
        }
        
        return -1;
    }

    // return true if the gap is found after insertion
    private boolean insert(List<Integer> list, int left, int right, int pos, int gap) {
        if (right < left) {
            list.add(left, pos);
            return false;
        }

        if (right - left <= 1) {
            int idx;
            if (pos <= list.get(left)) {
                idx = left;
                list.add(left, pos);
            } else if (pos > list.get(left) && pos <= list.get(right)) {
                idx = right;
                list.add(right, pos);
            } else {
                idx = right+1;
                list.add(right+1, pos);
            }

            // find the gap to left and right is available
            if (idx == 0) {
                // check right
                return (list.get(idx+1)- list.get(idx) == gap+1);
            } else if (idx == list.size()-1) {
                return (list.get(idx) - list.get(idx-1) == gap+1);
                // check left
            } else {
                // check left and right
                return (list.get(idx) - list.get(idx-1)==gap+1) ||
                    (list.get(idx+1) - list.get(idx) ==gap+1);
            }
        }
        
        int mid = (left+right)/2;
        if(list.get(mid) >= pos) {
            return insert(list, left, mid, pos, gap);
        } else {
            return insert(list, mid, right, pos, gap);
        }
    }
}
