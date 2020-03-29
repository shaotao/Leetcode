import java.io.*;
import java.util.*;


class OnlineElection
{
    public static void main(String[] args)
    {
        System.out.println("=== Online Election ===");
        /*
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        int[] ts = {3,12,25,15,24,8};
        */
        int[] persons = {0,0,0,0,1};
        int[] times = {0,6,39,52,75};
        int[] ts = {45,49,59,68,42,37,99,26,78,43};
        TopVotedCandidate tvc = new TopVotedCandidate(persons, times);

        System.out.println("persons = "+Arrays.toString(persons));
        System.out.println("times = "+Arrays.toString(times));
        for (int t : ts) {
            System.out.println("t = "+t+", top = "+tvc.q(t));
        }
    }
}


class TopVotedCandidate
{
    List<Slot> list;
    Map<Integer, Integer> map;
    
    class Slot
    {
        // inclusive
        int left;
        // exclusive
        int right;
        
        int top;
        
        public Slot(int left, int right, int top) {
            this.left = left;
            this.right = right;
            this.top = top;
        }
        
        public String toString() {
            return "["+left+","+right+":"+top+"]";
        }
    }
    
    public TopVotedCandidate(int[] persons, int[] times)
    {
        list = new ArrayList<>();
        map = new HashMap<>();
        int topCount = 0;
        int top = -1;
        
        int len = persons.length;
        for (int i = 0; i < len; i++) {
            int count = map.containsKey(persons[i])?(map.get(persons[i])+1):1;
            map.put(persons[i], count);
            if (count >= topCount) {
                topCount = count;
                top = persons[i];
            }
                
            int left = times[i];
            int right = (i+1 < len)?times[i+1]:-1;

            Slot s = new Slot(left, right, top);
            list.add(s);
        }

        System.out.println("list = "+list);
    }

    private Slot binSearch(List<Slot> list, int start, int end, int t) {
        //System.out.println("start = "+start+", end = "+end);
        if (start < 0 || end < 0 || start >= list.size() || end >= list.size()
            || start > end) {
            return null;
        }

        if (end - start <= 1) {
            Slot s1 = list.get(start);
            Slot s2 = list.get(end);
            if ( t >= s1.left && (t < s1.right || s1.right == -1)) {
                return s1;
            } else {
                return s2;
            }
        } else {
            int mid = (end + start)/2;
            Slot s = list.get(mid);
            if (t < s.left) {
                return binSearch(list, start, mid, t);
            } else if (t >= s.right) {
                return binSearch(list, mid, end, t);
            } else {
                return s;
            }
        }
    }
    
    public int q(int t) {
        Slot slot = binSearch(list, 0, list.size()-1, t);
        return slot.top;
    }
}

