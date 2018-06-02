import java.io.*;
import java.util.*;


class KeysAndRooms
{
    public static void main(String[] args)
    {
        System.out.println("=== Keys and Rooms ===");
        Solution solution = new Solution();
        /*
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1); l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(3); l2.add(0); l2.add(1);
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        l3.add(2);
        ArrayList<Integer> l4 = new ArrayList<Integer>();
        l4.add(0);
        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);
        */
        int[][] input = {{6,7,8},{5,4,9},{},{8},{4},{},{1,9,2,3},{7},{6,5},{2,3,1}};
        List<List<Integer>> rooms = createRooms(input);
        System.out.println("rooms = "+rooms);
        System.out.println("can enter all: "+solution.canVisitAllRooms(rooms));
    }

    private static List<List<Integer>> createRooms(int[][] input) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        for (int[] array : input) {
            List<Integer> list = new ArrayList<>();
            for (int i: array) {
                list.add(i);
            }
            rooms.add(list);
        }
        return rooms;
    }
}


class Solution
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<Integer>();
        List<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(0);

        int i = 0;
        while (i < toVisit.size()) {
            int idx = toVisit.get(i);
            visited.add(idx);

            for (Integer next : rooms.get(idx)) {
                if (!visited.contains(next)) {
                    //System.out.println("toVisit = "+toVisit);
                    //System.out.println("add next: "+next);
                    toVisit.add(next);
                }
            }
            
            i++;
        }
        
        //System.out.println("toVisit = "+toVisit.size());
        //System.out.println("visited = "+visited.size());
        //System.out.println("rooms = "+rooms.size());
        return visited.size() == rooms.size();        
    }
}
