import java.io.*;
import java.util.*;


class FindRightInterval
{
    public static void main(String[] args)
    {
	System.out.println("=== Find Right Interval ===");
	Solution solution = new Solution();

        int[][][] array = { {{1,2}},
                            {{3,4}, {2,3}, {1,2}},
                            {{1,4},{2,3},{3,4}},
                            {{1,2},{2,3},{0,1},{3,4}}};

        for(int i = 0; i < array.length; i++)
        {
            Interval[] input = toIntervalArray(array[i]);
            int[] ret = solution.findRightInterval(input);
            System.out.println("ret = "+Arrays.toString(ret));
        }
    }

    private static Interval[] toIntervalArray(int[][] array)
    {
        int size = array.length;
        Interval[] ret = new Interval[size];
        for(int i = 0; i < size; i++)
        {
            ret[i] = new Interval(array[i][0], array[i][1]);
        }

        return ret;
    }
}



class Interval
{
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public String toString()
    {
        return "["+start+", "+end+"]";
    }
}

class Solution
{
    // return the sorted index list
    public void sort(Interval[] intervals, int start, int end, int[] list)
    {
        int size = intervals.length;
        if(start < 0 || end < 0 || start >= end || end >= size) {
            return;
        }

        // ok, pick a pivot and scan from both sides to ensure
        // the order
        Random rand = new Random();
        int pivot_idx = start + rand.nextInt(end - start);
        Interval pivot = intervals[pivot_idx];

        // sort by start
        int i = start;
        int j = end;
        while(i < j)
        {
            // scan from front
            while(i < end && intervals[i].start < pivot.start) {
                i++;
            }

            // scan from end
            while(j > start && intervals[j].start > pivot.start) {
                j--;
            }

            if(i <= j) {
                // swap i and j
                Interval tmp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = tmp;

                int tmp_idx = list[i];
                list[i] = list[j];
                list[j] = tmp_idx;
            }

            i++;
            j--;
        }

        sort(intervals, start, j, list);
        sort(intervals, i, end, list);
    }

    private void print_intervals(Interval[] intervals)
    {
        int count = 0;
        for(Interval item: intervals) {
            System.out.print((count>0)?(", "+item.toString()):item.toString());
            count++;
        }
    }
    
    public int[] findRightInterval(Interval[] intervals)
    {
        int size = intervals.length;
        int[] ret = new int[size];
        int[] list = new int[size];
        
        for(int i = 0; i < size; i++) {
            ret[i] = -1;
            list[i] = i;
        }
        
        // sort the intervals
        sort(intervals, 0, intervals.length-1, list);

        //print_intervals(intervals);
        //System.out.println(Arrays.toString(list));

        for(int i = 0; i < size; i++) {
            Interval itv = intervals[i];

            // use binary search
            int idx = -1;
            int left = i+1;
            int right = size-1;
            
            while(right >= left) {

                if(right - left <= 1) {
                    if(intervals[left].start >= itv.end) {
                        idx = left;
                    } else if (intervals[right].start >= itv.end) {
                        idx = right;
                    } else {
                        idx = -1;
                    }
                    break;
                }
                
                int mid = (left+right)/2;
                if(intervals[mid].start > itv.end) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            if(idx >= 0) {
                ret[list[i]] = list[idx];
            }
        }
        
        return ret;
    }
}
