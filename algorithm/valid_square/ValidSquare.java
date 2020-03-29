import java.io.*;
import java.util.*;


class ValidSquare
{
    public static void main(String[] args)
    {
	System.out.println("=== Valid Square ===");
	Solution solution = new Solution();

        int[][] ps = {{0,0}, {1,1}, {1,0}, {0,1}};

        System.out.println("points = "+Arrays.deepToString(ps));
        System.out.println("valid square = "+solution.validSquare(ps[0], ps[1], ps[2], ps[3]));
    }
}


class Solution
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] center = new double[2];

        // get the center point
        center[0] = (p1[0]+p2[0]+p3[0]+p4[0])/4.0;
        center[1] = (p1[1]+p2[1]+p3[1]+p4[1])/4.0;

        double[][] points = new double[4][];
        
        points[0] = new double[]{p1[0]-center[0], p1[1]-center[1]};
        points[1] = new double[]{p2[0]-center[0], p2[1]-center[1]};
        points[2] = new double[]{p3[0]-center[0], p3[1]-center[1]};
        points[3] = new double[]{p4[0]-center[0], p4[1]-center[1]};

        double[][] Ps = new double[4][];
        for(int i = 0; i < 4; i++) {
            Ps[i] = findPoint(points, i);
            if(Ps[i] == null) { return false; }
        }

        //System.out.println("Ps = "+Arrays.deepToString(Ps));

        return (Ps[0][0] == Ps[1][1] && Ps[0][1] == -1*Ps[1][0] &&
                Ps[1][0] == Ps[2][1] && Ps[1][1] == -1*Ps[2][0] &&
                Ps[2][0] == Ps[3][1] && Ps[2][1] == -1*Ps[3][0] &&
                Ps[3][0] == Ps[0][1] && Ps[3][1] == -1*Ps[0][0]);
    }

    // area = 0, 1, 2, 3
    private double[] findPoint(double[][] points, int area) {

        for(double[] point : points) {
            double x = point[0]; double y = point[1];
            if (area == 0) {
                if(x > 0 && y >= 0) { return point; }
            } else if (area == 1) {
                if(x <= 0 && y > 0) { return point; }
            } else if (area == 2) {
                if(x < 0 && y <= 0) { return point; }
            } else {
                if(x>= 0 && y < 0) { return point; }
            }
        }
        
        return null;
    }
}
