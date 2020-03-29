import java.io.*;
import java.util.*;


class Interval
{
    int start;
    int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
}


public class MergeIntervals
{
    public static void load_intervals(ArrayList<Interval> intervals) throws Exception
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        BufferedReader reader = new BufferedReader(new FileReader("b"));
        String line = null;
        while( (line = reader.readLine()) != null)
        {
            array.add(Integer.parseInt(line));
        }

        reader.close();

        if(array.size()%2 != 0)
        {
            System.out.println("array size is not even, size = "+array.size());
            return;
        }

        int start = 0;
        int end = 0;
        for(int i = 0; i < array.size(); i++)
        {
            if(i%2 ==0)
            {
                start = array.get(i);
            }
            else
            {
                end = array.get(i);
                Interval val = new Interval(start, end);
                intervals.add(val);
            }
        }                
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println("=== Merge Intervals ===");
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        load_intervals(intervals);

        Solution solution = new Solution();
        ArrayList<Interval> result = solution.merge(intervals);
        
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
    public void quick_sort(Interval[] array, int start_idx, int end_idx)
    {
        int i = start_idx;
        int j = end_idx;
        
        if(end_idx <= start_idx)
        {
            return;
        }

        Random rand = new Random();
        int pivot = array[start_idx + rand.nextInt(end_idx-start_idx+1)].start;
        
        while(i <= j)
        {
            while(i < end_idx && array[i].start < pivot)
            {
                i++;
            }
            
            while(j > start_idx && array[j].start > pivot)
            {
                j--;
            }

            if(i <= j)
            {
                Interval temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                
                if(i < end_idx)
                {
                    i++;
                }

                if(j > start_idx)
                {
                    j--;
                }
            }
            
        }
        
        quick_sort(array, start_idx, j);
        quick_sort(array, i, end_idx);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        ArrayList<Interval> result = new ArrayList<Interval>();

        if(intervals.size() == 0) { return intervals; }
        
        Interval[] array = new Interval[intervals.size()];
        
        for(int i = 0; i < intervals.size(); i++)
        {
            array[i] = intervals.get(i);
        }

        quick_sort(array, 0, array.length-1);                

        // bounds for the current interval
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            Interval val = array[i];

            if(i == 0)
            {
                start = val.start;
                end = val.end;
            }
            else
            {
                if(val.start <= end)
                {
                    // try to see if we need to expand end
                    if(val.end > end)
                    {
                        end = val.end;
                    }
                }
                else
                {
                    // put the current interval to result
                    result.add(new Interval(start, end));
                    // start a new interval
                    start = val.start;
                    end = val.end;
                }
            }
            
        }        

        // add the last leg
        result.add(new Interval(start, end));

        return result;
    }
}
