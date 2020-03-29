import java.io.*;
import java.util.*;


class NumberOfBoomerangs
{
    public static void main(String[] args)
    {
	System.out.println("=== Number of Boomerangs ===");
	Solution solution = new Solution();

        //int[][] input = {{0,0}, {1,0}, {2,0}};
        //int[][] input = {{1,1}};
        int[][] input = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        
        System.out.println("number of boomerangs: "+solution.numberOfBoomerangs(input));
    }
}


class Solution
{    
    public int numberOfBoomerangs(int[][] points)
    {
        int ret = 0;

        if(points == null || points.length == 0) { return 0; }

        int num_points = points.length;

        for(int i = 0; i < num_points; i++) {
            HashMap<Double, Integer> dist_map = new HashMap<Double, Integer>();
            
            for(int j = 0; j < num_points; j++) {
                if(i == j) { continue; }

                double dist = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));

                int count = 1;
                if(dist_map.containsKey((Double)dist)) {
                    count += dist_map.get((Double)dist);
                }
                dist_map.put((Double) dist, count);
            }

            for(Double key: dist_map.keySet()) {
                int num = dist_map.get(key);
                if(num == 1) { continue; }
                else {
                    ret += num*(num-1);
                }
            }            
        }
        
        return ret;
    }
}
