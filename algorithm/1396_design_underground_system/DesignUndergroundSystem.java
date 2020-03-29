import java.io.*;
import java.util.*;


class DesignUndergroundSystem
{
    public static void main(String[] args)
    {
        System.out.println("=== Design Underground System ===");
        UndergroundSystem ug = new UndergroundSystem();
        ug.checkIn(45, "Leyton", 3);
        ug.checkIn(32, "Paradise", 8);
        ug.checkIn(27, "Leyton", 10);
        ug.checkOut(45, "Waterloo", 15);
        ug.checkOut(27, "Waterloo", 20);
        ug.checkOut(32, "Cambridge", 22);
        double avg = ug.getAverageTime("Paradise", "Cambridge");
        System.out.println("average(Paradise, Cambridge) = "+avg);

        avg = ug.getAverageTime("Leyton", "Waterloo");
        System.out.println("average(Leyton, Waterloo) = "+avg);
        
        ug.checkIn(10, "Leyton", 24);
        avg = ug.getAverageTime("Leyton", "Waterloo");
        System.out.println("average(Leyton, Waterloo) = "+avg);
        
        ug.checkOut(10, "Waterloo", 38);

        avg = ug.getAverageTime("Leyton", "Waterloo");
        System.out.println("average(Leyton, Waterloo) = "+avg);
    }
}

class Entry
{
    double total;
    int num;
    double avg;

    public Entry(int t) {
        this.total = t;
        this.num = 1;
        this.avg = this.total;
    }

    public void update(int t) {
        total += t;
        num++;
        avg = total/num;
    }

    public double getAvg() {
        return this.avg;
    }
}

class Trip
{
    String startStation;
    String endStation;
    int startTime;
    int endTime;

    public Trip(String startStation, int startTime) {
        this.startStation = startStation;
        this.startTime = startTime;
    }

    public void endTrip(String endStation, int endTime) {
        this.endStation = endStation;
        this.endTime = endTime;
    }

    public String getKey() {
        return startStation+"-"+endStation;
    }

    public int getTime() {
        return this.endTime - this.startTime;
    }
}


class UndergroundSystem
{
    Map<Integer, Trip> tripMap = new HashMap<>();
    Map<String, Entry> map = new HashMap<>();
    
    public void checkIn(int id, String stationName, int t) {
        if (tripMap.containsKey(id)) {
            throw new IllegalArgumentException("person "+id+" has incompleted trips!");
        }

        Trip trip = new Trip(stationName, t);
        tripMap.put(id, trip);
    }

    public void checkOut(int id, String stationName, int t) {
        if (!tripMap.containsKey(id)) {
            throw new IllegalArgumentException("person "+id+" has not started a trip!");
        }

        Trip trip = tripMap.get(id);
        tripMap.remove(id);
        trip.endTrip(stationName, t);
        int time = trip.getTime();
        String key = trip.getKey();

        Entry entry = map.get(key);
        if (entry == null) {
            entry = new Entry(time);
            map.put(key, entry);
        } else {
            entry.update(time);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+"-"+endStation;
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("no such travel record: "+key);
        }

        Entry entry = map.get(key);
        return entry.getAvg();
    }
}
