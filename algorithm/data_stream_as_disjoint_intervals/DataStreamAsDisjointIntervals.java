import java.io.*;
import java.util.*;

class DataStreamAsDisjointIntervals
{
    public static void main(String[] args)
    {
	System.out.println("=== Data Stream As Disjoint Intervals ===");
        SummaryRanges obj = new SummaryRanges();
        int[] nums = {1,3,7,2,6,9,4,10,5};
        for (int num: nums) {
            obj.addNum(num);
            List<Interval> intervals = obj.getIntervals();
            System.out.println("add "+num+", intervals = "+intervals);
        }
    }
}

class Interval
{
    int start;
    int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
    public String toString() { return "["+start+","+end+"]"; }
}

class SummaryRanges
{
    ArrayList<Interval> intervals = null;
    public SummaryRanges() {
        intervals = new ArrayList<Interval>();
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void addNum(int val) {
        // if an interval contains the val, do nothing
        // else if an interval is next to val, expand the interval
        //    if two intervals overlap after val is added, merge interval
        // else, add a new interval
        
        // no interval in list
        if(intervals.size() == 0) {
            Interval interval = new Interval(val, val);
            intervals.add(interval);
            return;
        }

        // there is one interval in list
        if (intervals.size() == 1) {
            if(val < intervals.get(0).start-1) {
                Interval interval = new Interval(val, val);
                intervals.add(0, interval);
            } else if(val == intervals.get(0).start-1) {
                intervals.get(0).start = val;
            } else if (val == intervals.get(0).end+1) {
                intervals.get(0).end = val;
            } else if (val > intervals.get(0).end+1) {
                Interval interval = new Interval(val, val);
                intervals.add(interval);
            }
            return;
        }

        // there are >= 2 intervals in list
        int left = 0;
        int right = intervals.size()-1;

        while(left <= right) {
            Interval l = intervals.get(left);
            Interval r = intervals.get(right);
            if(right - left == 1) {
                // check if right and left interval has a gap of 1
                if(r.start - l.end == 2) {
                    // 5 conditions
                    if(val < l.start-1) {
                        Interval interval = new Interval(val, val);
                        intervals.add(0, interval);
                    } else if(val == l.start-1) {
                        l.start = val;
                    } else if(val == l.end+1) {
                        l.end = r.end;
                        intervals.remove(right);
                    } else if(val == r.end+1) {
                        r.end = val;
                    } else if(val > r.end+1) {
                        Interval interval = new Interval(val, val);
                        intervals.add(interval);
                    }
                } else {
                    // 7 conditions
                    if(val < l.start-1) {
                        Interval interval = new Interval(val, val);
                        intervals.add(0, interval);
                    } else if(val == l.start-1) {
                        l.start = val;
                    } else if(val == l.end+1) {
                        l.end = val;
                    } else if(val > l.end+1 && val < r.start-1) {
                        Interval interval = new Interval(val, val);
                        intervals.add(right, interval);
                    } else if(val == r.start-1) {
                        r.start = val;
                    } else if(val == r.end+1) {
                        r.end = val;
                    } else if(val > r.end+1) {
                        Interval interval = new Interval(val, val);
                        intervals.add(right+1, interval);
                    }
                }
                
                return;
            } else {
                int mid = (left+right)/2;
                Interval m = intervals.get(mid);
                if(val > m.end) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
    }
}
