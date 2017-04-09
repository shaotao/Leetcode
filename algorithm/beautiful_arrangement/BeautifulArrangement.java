import java.io.*;
import java.util.*;


class BeautifulArrangement
{
    public static void main(String[] args)
    {
	System.out.println("=== Beantiful Arrangement ===");
	Solution solution = new Solution();
        int N = 2;
        System.out.println(String.format("N=%d, arrangements = %d\n", N, solution.countArrangement(N)));
    }
}


class Solution
{
    // use array
    public int countArrangement(int N) {
        int[] count = new int[1]; count[0] = 0;
        int[] array = new int[N];
        for(int i = 0; i < N; i++) { array[i] = i+1; }
        scan(1, array, count);        
        return count[0];
    }

    public void scan(int seqno, int[] array, int[] count) {
        if(seqno > array.length) { count[0]+=1; }

        for(int i = 0; i < array.length; i++) {
            int num = array[i];
            if(num != 0 && (num%seqno == 0 || seqno%num==0)) {
                array[i] = 0;
                scan(seqno+1, array, count);
                array[i] = num;
            }
        }
    }

    // use list
    public int countArrangement2(int N) {
        int[] count = new int[1]; count[0] = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++) { list.add(i); }
        scan2(1, list, count);        
        return count[0];
    }

    public void scan2(int seqno, ArrayList<Integer> list, int[] count) {
        if(list.size() == 0) { count[0]+=1; }

        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num%seqno == 0 || seqno%num==0) {
                list.remove((int)i);
                scan2(seqno+1, list, count);
                list.add(i, num);
            }
        }
    }
}
