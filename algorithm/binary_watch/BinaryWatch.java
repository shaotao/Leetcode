import java.io.*;
import java.util.*;


class BinaryWatch
{
    public static void main(String[] args)
    {
	System.out.println("=== Binary Watch ===");
	Solution solution = new Solution();

        int n = 1;
        System.out.println("time = "+solution.readBinaryWatch(n));
    }
}


class Solution
{
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        if(num < 0 || num > 8) {
            return list;
        }

        // 4 bits for hour, 6 bits for minute
        // hour max 3 bits, minutes max 5 bits
        int[] bits = new int[10];
        for(int i = 0; i < bits.length; i++) { bits[i] = 0; }
        trace(num, 0, 9, bits, list);
        
        return list;
    }

    public void trace(int num, int left, int right, int[] bits, List<String> list) {
        if(num < 0) { return; }

        if(num > 0) {
            for(int i = left; i <= right; i++) {
                bits[i] = 1;
                trace(num-1, i+1, right, bits, list);
                bits[i] = 0;
            }
        } else {
            // check bits
            //System.out.println("bits = "+Arrays.toString(bits));
            String ret = bitsToTime(bits);
            if(ret != null) {
                list.add(ret);
            }
        }
    }

    public String bitsToTime(int[] bits) {
        int hour = 0;
        int minute = 0;
        for(int i = 3; i >= 0; i--) {
            hour += bits[i]*(1<<(3-i));
        }

        for(int i = 9; i >= 4; i--) {
            minute += bits[i]*(1<<(9-i));
        }

        if(hour <= 11 && minute <=59) {
            return String.format("%d:%02d", hour, minute);
        }

        return null;
    }
}
