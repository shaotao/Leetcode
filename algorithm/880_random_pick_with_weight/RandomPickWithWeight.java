import java.io.*;
import java.util.*;


class RandomPickWithWeight
{
    public static void main(String[] args)
    {
        System.out.println("=== Random Pick with Weight ===");
        int[] w = {1,3};
        Solution solution = new Solution(w);
        System.out.println("w = "+Arrays.toString(w));
        for (int i = 0; i < 100; i++) {
            System.out.println("idx = "+solution.pickIndex());
        }
    }
}


class Solution
{
    Random rand = new Random();
    Slot[] slots;
    class Slot {
        double left;
        double right;
        public Slot(double left, double right) {
            this.left = left;
            this.right = right;
        }

        public int check(double r) {
            if (r < this.left) {
                return -1;
            } else if (r >= this.left && r < this.right) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    public Solution(int[] w) {
        double sum = 0;
        for (int i : w) { sum += i; }
        slots = new Slot[w.length];
        double prev = 0;
        for (int i = 0; i < w.length; i++) {
            double right = prev + w[i]/sum;
            slots[i] = new Slot(prev, right);
            prev = right;
        }
    }

    private int find(double r, Slot[] slots, int left, int right) {
        if (right - left < 2) {
            return (slots[left].check(r)==0)?left:right;
        }
        int mid = (right+left)/2;
        int status = slots[mid].check(r);
        if (status < 0) {
            return find(r, slots, left, mid);
        } else if (status == 0) {
            return mid;
        } else {
            return find(r, slots, mid, right);
        }
    }

    public int pickIndex() {
        double r = rand.nextDouble();
        int idx = find(r, slots, 0, slots.length-1);
        return idx;
    }
}
