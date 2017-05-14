import java.io.*;
import java.util.*;


class SuperWashingMachines
{
    public static void main(String[] args)
    {
	System.out.println("=== Super Washing Machines ===");
	Solution solution = new Solution();
        int[][] machines_array = {{1,0,5},
                                  {0,3,0},
                                  {0,2,0}};
        for(int i = 0; i < machines_array.length; i++) {
            int[] machines = machines_array[i];

            System.out.println("machines = "+Arrays.toString(machines)+", min moves = "+solution.findMinMoves(machines));
        }
    }
}


class Solution
{
    public int findMinMoves(int[] machines) {
        int ret = 0;
        int sum = 0;
        int avg = 0;

        if(machines == null || machines.length <= 1) { return 0; }
        int size = machines.length;
        
        for(int i = 0; i < size; i++) { sum += machines[i]; }
        if(sum%size != 0) { return -1; }
        avg = sum/size;

        int[] shifts = new int[size];
        int count = 0;
        for(int i = 0; i < size; i++) {
            shifts[i] = count - avg*i;
            count += machines[i];
        }
        
        System.out.println("shifts = "+Arrays.toString(shifts));
        
        return ret;
    }
}
