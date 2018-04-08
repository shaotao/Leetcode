import java.io.*;
import java.util.*;


class LargestTriangleArea
{
    public static void main(String[] args)
    {
        System.out.println("=== Largest Triangle Area ===");
        Solution solution = new Solution();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println("largest triangle area = "+solution.largestTriangleArea(points));
    }
}


class Solution
{
    private double length(int x1, int y1, int x2, int y2) {
        double length = 0;
        length = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return length;
    }

    private double area(double ab, double ac, double bc) {
        double s = (ab + ac +bc)/2;
        return Math.sqrt(s*(s-ab)*(s-ac)*(s-bc));
    }
    public double largestTriangleArea(int[][] points) {
        int numPoints = points.length;
        double max = 0;
        for (int i = 0; i < numPoints; i++) {
            int xa = points[i][0];
            int ya = points[i][1];
            for (int j = i+1; j < numPoints; j++) {
                int xb = points[j][0];
                int yb = points[j][1];
                double ab = length(xa, ya, xb, yb);
                for (int k = j+1; k < numPoints; k++) {
                    int xc = points[k][0];
                    int yc = points[k][1];
                    double ac = length(xa, ya, xc, yc);
                    double bc = length(xb, yb, xc, yc);
                    double area = area(ab, ac, bc);
                    if (area > max) {
                        /*
                        System.out.println("a = ("+xa+", "+ya+")");
                        System.out.println("b = ("+xb+", "+yb+")");
                        System.out.println("c = ("+xc+", "+yc+")");
                        System.out.println("area = "+area);
                        System.out.println("max = "+max);
                        */
                        max = area;
                    }
                }
            }
        }
        return max;
    }
}
