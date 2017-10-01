import java.io.*;
import java.util.*;


class NextClosestTime
{
    public static void main(String[] args)
    {
        System.out.println("=== Next Closest Time ===");
        Solution solution = new Solution();
        String[] input = {"19:34", "23:59"};
        for(String time : input) {
            System.out.println("time="+time+", next="+solution.nextClosestTime(time));
        }
    }
}


class Solution
{
    public String nextClosestTime(String time) {
        String[] fields = time.split(":");
        int[] digits = new int[4];
        Set<String> set = new HashSet<String>();
        digits[0] = Integer.parseInt(fields[0].substring(0,1));
        digits[1] = Integer.parseInt(fields[0].substring(1));
        digits[2] = Integer.parseInt(fields[1].substring(0,1));
        digits[3] = Integer.parseInt(fields[1].substring(1));
        
        getTime(set, null, digits, 1, 4);

        String minTime = null;
        int min = 0;
        // get the list of time
        for(String t : set) {
            int diff = getDiff(time, t);

            if (minTime == null) {
                minTime = t;
                min = diff;
            } else {
                if (min <= 0 && diff <= 0) {
                    if(diff > min) {
                        min = diff;
                        minTime = t;
                    }
                } else if (min <= 0 && diff > 0) {
                    min = diff;
                    minTime = t;
                } else if (min > 0 && diff <= 0) {
                    continue;
                } else {
                    if(diff < min) {
                        min = diff;
                        minTime = t;
                    }
                }
            }
        }
        
        return minTime;
    }

    private int getDiff(String t1, String t2) {
        int h1 = Integer.parseInt(t1.split(":")[0]);
        int m1 = Integer.parseInt(t1.split(":")[1]);

        int h2 = Integer.parseInt(t2.split(":")[0]);
        int m2 = Integer.parseInt(t2.split(":")[1]);

        if (h2 < h1 || (h2 == h1 && m2 <= m1)) {
            // diff is t1->24:00 + 00:00 -> t2
            return (23-h1)*60 + (60-m1) + h2*60 + m2;
        } else {
            // t2 - t1
            return (h2-h1)*60 + (m2-m1);
        }
    }

    private void getTime(Set<String> set, List<Integer> buf, int[] digits, int level, int total) {
        if(level == 1) {
            buf = new ArrayList<Integer>();
        }

        if(level > total) {
            set.add(String.format("%s%s:%s%s", buf.get(0), buf.get(1), buf.get(2), buf.get(3)));
            return;
        }
        
        for(int i = 0; i < digits.length; i++) {
            if( (level == 1 && digits[i] > 2) ||
                (level == 3 && digits[i] > 5) ||
                (level == 2 && digits[i] > 3 && buf.get(buf.size()-1)==2) ) {
                continue;
            }
            buf.add(digits[i]);
            getTime(set, buf, digits, level+1, total);
            buf.remove((int)(buf.size()-1));
        }
    }
}
