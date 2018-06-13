import java.io.*;
import java.util.*;


class MaximizeDistanceToClosestPerson
{
    public static void main(String[] args)
    {
        System.out.println("=== Maximize Distance to Closest Person ===");
        Solution solution = new Solution();
        int[][] input = {{1,0,0,0,1,0,1}, {1,0,0,0}};
        for (int[] seats : input) {
            System.out.println("seats = "+Arrays.toString(seats));
            System.out.println("max dist = "+solution.maxDistToClosest(seats));
        }
    }
}


class Solution
{
    public int maxDistToClosest(int[] seats) {
        int ret = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
        }

        int head = list.get(0) - 0;
        int tail = seats.length-1 - list.get(list.size()-1);
        int maxGap = 0;
        for (int i = 1; i < list.size(); i++) {
            int gap = list.get(i) - list.get(i-1);
            maxGap = (maxGap > gap)?maxGap:gap;
        }
        int middle = maxGap/2;

        ret = (ret >= head)?ret:head;
        ret = (ret >= tail)?ret:tail;
        ret = (ret >= middle)?ret:middle;
        
        return ret;
    }
}
