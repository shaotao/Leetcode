import java.io.*;
import java.util.*;


class GenerateRandomPointInACircle
{
    public static void main(String[] args)
    {
        System.out.println("=== Generate Random Point in a Circle ===");
        Solution solution1 = new Solution(1, 0, 0);
        Solution solution2 = new Solution(10, 5, -7.5);
        System.out.println("rand11 = "+Arrays.toString(solution1.randPoint()));
        System.out.println("rand12 = "+Arrays.toString(solution1.randPoint()));
        System.out.println("rand13 = "+Arrays.toString(solution1.randPoint()));

        System.out.println("rand21 = "+Arrays.toString(solution2.randPoint()));
        System.out.println("rand22 = "+Arrays.toString(solution2.randPoint()));
        System.out.println("rand23 = "+Arrays.toString(solution2.randPoint()));

    }
}


class Solution
{
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;
    
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double x = 0;
        double y = 0;
        do {
            x = (2*rand.nextDouble()-1)*radius;
            y = (2*rand.nextDouble()-1)*radius;
        } while (Math.sqrt(x*x + y*y) > radius);
        
        double[] ret = new double[2];
        ret[0] = x_center + x;
        ret[1] = y_center + y;
        return ret;
    }
}
