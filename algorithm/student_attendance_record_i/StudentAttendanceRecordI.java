import java.io.*;
import java.util.*;


class StudentAttendanceRecordI
{
    public static void main(String[] args)
    {
	System.out.println("=== Student Attendance Record I ===");
	Solution solution = new Solution();
        String[] inputs = {"PPALLP", "PPALLL"};

        for(String s: inputs) {
            System.out.println("s = "+s+", reward = "+solution.checkRecord(s));
        }
    }
}


class Solution
{
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) { return false; }

        int numA = 0;
        int countL = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'A') {
                countL = 0;
                numA++;
                if(numA > 1) { return false; }
            } else if (ch == 'L') {
                countL++;
                if(countL > 2) { return false; }
            } else {
                countL = 0;
            }
        }

        return true;
    }
}
