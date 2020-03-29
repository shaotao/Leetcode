import java.io.*;
import java.util.*;


class BusRoutes
{
    public static void main(String[] args)
    {
        System.out.println("=== Bus Routes ===");
        Solution solution = new Solution();
        /*
        int[][] routes = {{1,2,7}, {3,6,7}};
        int S = 1;
        int T = 6;
        */
        int[][] routes = {{7,12}, {4,5,15}, {6}, {15,19}, {9,12,13}};
        int S = 15;
        int T = 12;
        System.out.println("routes = "+Arrays.deepToString(routes));
        System.out.println("S = "+S+", T = "+T);
        int numBuses = solution.numBusesToDestination(routes, S, T);
        System.out.println("num of buses = "+numBuses);
    }
}

class Bus
{
    int id;
    int dist;
    Set<Bus> nbrs;
    public Bus(int id) {
        this.id = id;
        this.dist = -1;
        nbrs = new HashSet<>();
    }

    public void addNbr(Bus nbr) {
        nbrs.add(nbr);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (Bus nbr : nbrs) {
            buf.append(nbr.id+", ");
        }
        return String.format("bus-"+id+") "+buf.toString());
    }
}

class Solution
{
    private void printMap(Map<Integer, Bus> busMap) {
        for (int id: busMap.keySet()) {
            System.out.println(busMap.get(id));
        }
    }

    private void printStopToBusMap(Map<Integer, Set<Bus>> map) {
        for (int id : map.keySet()) {
            Set<Bus> set = map.get(id);
            StringBuffer buf = new StringBuffer();
            for (Bus bus : set) {
                buf.append(bus.id+", ");
            }
            System.out.println("stop-"+id+": "+buf.toString());
        }
    }
    
    private Bus getBus(Map<Integer, Bus> map, int id) {
        Bus bus = map.get(id);
        if (bus == null) {
            bus = new Bus(id);
            map.put(id, bus);
        }
        return bus;
    }
    
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) { return 0; }
        Map<Integer, Bus> busMap = new HashMap<>();
        Map<Integer, Set<Bus>> stopToBusMap = new HashMap<>();
        
        for (int busId = 0; busId < routes.length; busId++) {
            Bus bus = getBus(busMap, busId);
            int[] route = routes[busId];
            for (int i = 0; i < route.length; i++) {
                int stopId = route[i];
                Set<Bus> buses = stopToBusMap.get(stopId);
                if (buses == null) {
                    buses = new HashSet<>();
                    stopToBusMap.put(stopId, buses);
                }
                buses.add(bus);
            }
        }

        //printStopToBusMap(stopToBusMap);

        for (int stopId : stopToBusMap.keySet()) {
            Set<Bus> buses = stopToBusMap.get(stopId);
            List<Bus> busList = new ArrayList<Bus>(buses);
            for (int i = 0; i < busList.size(); i++) {
                Bus bus1 = busList.get(i);
                for (int j = i+1; j < busList.size(); j++) {
                    Bus bus2 = busList.get(j);
                    bus1.addNbr(bus2);
                    bus2.addNbr(bus1);
                }
            }
        }
                
        // print the map
        //printMap(busMap);

        // find the list of starting buses and ending buses
        Set<Bus> start = stopToBusMap.get(S);
        Set<Bus> end = stopToBusMap.get(T);
        
        // breadth first search
        for (Bus bus : start) { bus.dist = 1; }
        List<Bus> list = new ArrayList<>();
        list.addAll(start);

        int i = 0;
        int minDist = -1;
        while(i < list.size()) {
            Bus n = list.get(i);
            if (end.contains(n)) {
                if(minDist == -1 || minDist > n.dist) { minDist = n.dist; }
            }

            for (Bus nbr : n.nbrs) {
                if (nbr.dist < 0) {
                    nbr.dist = n.dist+1;
                    if (end.contains(nbr)) {
                        if(minDist == -1 || minDist > nbr.dist) { minDist = nbr.dist; }                      
                    }
                    list.add(nbr);
                }
            }
            
            i++;
        }
        
        return minDist;
    }
}

