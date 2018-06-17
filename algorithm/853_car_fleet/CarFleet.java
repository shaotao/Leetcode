import java.io.*;
import java.util.*;


class CarFleet
{
    public static void main(String[] args)
    {
        System.out.println("=== Car Fleet ===");
        Solution solution = new Solution();
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        System.out.println("target = "+target);
        System.out.println("position = "+Arrays.toString(position));
        System.out.println("speed = "+Arrays.toString(speed));
        int numFleet = solution.carFleet(target, position, speed);
        System.out.println("num of fleed = "+solution.carFleet(target, position, speed));
    }
}


class Solution
{
    public int carFleet(int target, int[] position, int[] speed) {
        int ret = 0;

        if (position.length == 0) {
            return 0;
        }
        
        Map<Integer, Double> timemap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            timemap.put(position[i], 1.0*(target-position[i])/speed[i]);
        }

        Arrays.sort(position);
        double[] time = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            time[i] = timemap.get(position[i]);
        }

        double ahead = time[time.length-1];
        ret = 1;
        for (int i = time.length-1; i >= 0; i--) {
            if (time[i] > ahead) {
                ret++;
                ahead = time[i];
            }
        }
        
        return ret;
    }
}
