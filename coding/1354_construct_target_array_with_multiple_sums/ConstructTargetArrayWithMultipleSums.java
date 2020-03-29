import java.io.*;
import java.util.*;


class ConstructTargetArrayWithMultipleSums
{
    public static void main(String[] args)
    {
        System.out.println("=== Construct Target Array with Multiple Sums ===");
        Solution solution = new Solution();

        int[][][] list_events =  { {{1,2}, {2,3}, {3,4}, {1,2}},
                                 {{1,2}, {2,3}, {3,4}},
                                 {{1,4}, {4,4}, {2,2}, {3,4}, {1,1}},
                                 {{1, 100000}},
                                 {{1,1}, {1,2}, {1,3}, {1,4}, {1,5}, {1,6}, {1,7}}
        };

        for (int[][] events : list_events) {
            int max = solution.maxEvents(events);
            System.out.println("events = "+Arrays.deepToString(events));
            System.out.println("max events = "+max);
        }
    }
}


class Solution
{

    private static final Comparator<Event> comp = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            if (e1.start == e2.start) {
                if (e1.end == e2.end) {
                    return 0;
                } else if (e1.end > e2.end) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (e1.start > e2.start) {
                return 1;
            } else {
                return -1;
            }
        }
    };
    
    public int maxEvents(int[][] events) {
        int ret = 0;
        Event curr = null;

        List<Event> elist = getEvents(events);
        System.out.println("elist = "+elist);

        for (Event e : elist) {
            if (curr == null || curr.end < e.end) {
                curr = e;
                ret++;
            }
        }
        
        
        return ret;
    }

    private List<Event> getEvents(int[][] events) {
        List<Event> list = new ArrayList<>();
        for (int[] event : events) {
            Event e = new Event(event[0], event[1]);
            list.add(e);
        }
        // sort events by start and end time
        Collections.sort(list, comp);

        return list;
    }
}



class Event
{
    long start;
    long end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return String.format("[%d, %d]", start, end);
    }
}



