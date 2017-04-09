import java.io.*;
import java.util.*;


class FindMedianFromDataStream
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Median from Data Stream ===");
        MedianFinder finder = new MedianFinder();
        for(int i = 1; i <= 3; i++) {
            System.out.println("add "+i);
            finder.addNum(i);
            System.out.println("Median = "+finder.findMedian());
        }
    }
}

class MedianFinder
{
    ArrayList<Integer> list = null;
    
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        // insert the new number to the list using binary search
        if(list.size() == 0) { list.add(num); }
        else if(list.size() == 1) {
            if(num > list.get(0)) { list.add(num); }
            else { list.add(0, num); }
        } else {
            int left = 0;
            int right = list.size()-1;

            while(left <= right) {
                if(right - left <= 1) {
                    if(num < list.get(left)) {
                        list.add(left, num);
                    } else if (num > list.get(right)) {
                        list.add(num);
                    } else {
                        list.add(right, num);
                    }
                    break;
                } else {
                    int middle = (left+right)/2;
                    if(num <= list.get(middle)) {
                        right = middle;
                    } else {
                        left = middle;
                    }
                }
            }
        }
    }

    public double findMedian() {
        double ret = 0;

        if(list.size() == 0) {
            System.out.println("MedianFinder.findMedian() error: list is empty!");
            return -1;
        } else if(list.size()%2 == 0) {
            int right = list.size()/2;
            int left = right - 1;
            ret = (list.get(left)+list.get(right))/2.0;
        } else{
            int middle = list.size()/2;
            ret = list.get(middle);
        }
        
        return ret;
    }
}
