import java.io.*;
import java.util.*;


class Interval
{
    int start;
    int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
}


public class InsertInterval
{
    public static void main(String[] args)
    {
        System.out.println("=== Insert Interval ===");
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 9);
        Interval new_i = new Interval(2, 5);
        
        intervals.add(i1);
        intervals.add(i2);
        
        Solution solution = new Solution();
        ArrayList<Interval> result = solution.insert(intervals, new_i);
        
        System.out.print("intervals: ");
        for(int i = 0; i < result.size(); i++)
        {
            Interval val = result.get(i);
            System.out.print("["+val.start+", "+val.end+"] ");
        }
        System.out.println("");
    }
}


class Solution
{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        double left_index = 0.5;
        double right_index = 0.5;
        boolean left_done = false;
        boolean right_done = false;

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i = 0; i < intervals.size(); i++)
        {
            Interval val = intervals.get(i);
            
            if(left_done == true && right_done == true) { break; }

            if(left_done == false)
            {
                if(newInterval.start >= val.start && newInterval.start <= val.end)
                {
                    left_index = i+1;
                    newInterval.start = val.start;
                    left_done = true;
                }
                else if(newInterval.start < val.start)
                {
                    left_index += i;
                    left_done = true;
                }
            }

            if(right_done == false)
            {
                if(newInterval.end >= val.start && newInterval.end <= val.end)
                {
                    right_index = i+1;
                    newInterval.end = val.end;
                    right_done = true;
                }
                else if(newInterval.end < val.start)
                {
                    right_index += i;
                    right_done = true;
                }
            }            
        }

        if(left_done == false)
        {
            left_index = intervals.size()+0.5;
        }
        
        if(right_done == false)
        {
            right_index = intervals.size()+0.5;
        }
            

        //System.out.println("left = "+left_index+", right_index = "+right_index);
        //System.out.println("start = "+newInterval.start+", end = "+newInterval.end);

        boolean added = false;
        
        for(int i = 0; i < intervals.size(); i++)
        {
            if(added == false && left_index < (i+1))
            {
                result.add(newInterval);
                added = true;
            }
            
            if((i+1) >= left_index && (i+1) <= right_index)
            {
                continue;
            }
            else
            {
                result.add(intervals.get(i));
            }
        }

        if(added == false)
        {            
            result.add(newInterval);
        }
        
        return result;
    }
}
