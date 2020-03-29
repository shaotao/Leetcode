import java.io.*;
import java.util.*;


class MinimumTimeDifference
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Time Difference ===");
	Solution solution = new Solution();

        List<String> timePoints = new ArrayList<String>();
        timePoints.add("01:01");
        timePoints.add("02:01");
        timePoints.add("03:00");
        int diff = solution.findMinDifference(timePoints);
        System.out.println("minimum difference = "+diff);
    }
}


class Solution
{
    public int findMinDifference(List<String> timePoints) {
        if(timePoints == null || timePoints.size() < 2) { return -1; }

        int full = 24*60;
        int[] slots = new int[full];
        for(int i = 0; i < slots.length; i++) { slots[i] = 0; }

        for(String p : timePoints) {
            String[] time = p.split(":");
            int idx = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            slots[idx] += 1;
            if(slots[idx] >= 2) { return 0; }
        }

        int minDiff = -1;
        // scan the slots array to find the min diff
        int i = 0;
        while(i < slots.length) {
            if(slots[i] == 0) { i++; }
            else {
                int j = (i+1)%slots.length;
                while(slots[j] == 0) {
                    j = (j+1)%slots.length;
                }

                int diff = i-j;
                if(diff < 0) { diff *= -1; }
                if(diff > (full - diff)) { diff = full-diff;}
                if(minDiff == -1 || minDiff > diff) { minDiff = diff; }
                
                if(j > i) { i = j; }
                else { break; }
            }
        }

        return minDiff;
    }
}
