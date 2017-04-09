import java.io.*;
import java.util.*;


class SelfCrossing
{
    public static void main(String[] args)
    {
	System.out.println("=== Self Crossing ===");
	Solution solution = new Solution();

        int[][] array = {{2, 1, 1, 2},
                         {1, 2, 3, 4},
                         {1, 1, 1, 1},
                         {1,1,2,1,1}};
        for(int[] x: array) {
            System.out.println("Given x = "+Arrays.toString(x));
            System.out.println("self crossing? "+solution.isSelfCrossing(x));
        }
    }
}

class Edge
{
    int dir;
    int x1;
    int y1;
    int x2;
    int y2;

    public Edge(int dir, int x1, int y1, int x2, int y2) {
        this.dir = dir;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString() {
        return "dir = "+dir+", ("+x1+","+y1+","+x2+","+y2+")";
    }
    
    public boolean cross(Edge other) {
        if(this.dir == other.dir) {
            // parallel
            if(this.dir == 0) {
                // vertical
                if(this.x1 != other.x1) { return false; }

                return !(((other.y1 < this.y1 && other.y1 < this.y2 &&
                           other.y2 < this.y1 && other.y2 < this.y2)) ||
                         ((other.y1 > this.y1 && other.y1 > this.y2 &&
                           other.y2 > this.y1 && other.y2 > this.y2)));
            } else {
                // horizontal
                if(this.y1 != other.y1) { return false; }
                
                return !(((other.x1 < this.x1 && other.x1 < this.x2 &&
                           other.x2 < this.x1 && other.x2 < this.x2)) ||
                         ((other.x1 > this.x1 && other.x1 > this.x2 &&
                           other.x2 > this.x1 && other.x2 > this.x2)));
            }
        } else {
            // not parallel
            if(this.dir == 0) {
                return !((other.x1 > this.x1 && other.x2 > this.x1) ||
                         (other.x1 < this.x1 && other.x2 < this.x1) ||
                         (this.y1 > other.y1 && this.y2 > other.y1) ||
                         (this.y1 < other.y1 && this.y2 < other.y1));
            } else {
                return !((other.y1 > this.y1 && other.y2 > this.y1) ||
                         (other.y1 < this.y1 && other.y2 < this.y1) ||
                         (this.x1 > other.x1 && this.x2 > other.x1) ||
                         (this.x1 < other.x1 && this.x2 < other.x1));
            }
        }
    }
}

class Solution
{
    public boolean isSelfCrossing(int[] x) {

        // check the current edge with the previous 5 edges
        // 6 edges in total, check with i-3 and i-5
        Edge[] edges = new Edge[6];

        // scan the points to insert edge.
        int prev_x = 0;
        int prev_y = 0;
        int curr_x = 0;
        int curr_y = 0;
        int dir = 0;
        int idx_edge = 0;
        for(int i = 0; i < x.length; i++) {
            int idx = i%4;
            
            if(idx == 0) {
                curr_x = prev_x;
                curr_y = prev_y + x[i];
            } else if (idx == 1) {
                curr_x = prev_x - x[i];
                curr_y = prev_y;
            } else if (idx == 2) {
                curr_x = prev_x;
                curr_y = prev_y - x[i];
            } else {
                curr_x = prev_x + x[i];
                curr_y = prev_y;
            }

            // create an edge, insert to edges
            Edge e = new Edge(dir, prev_x, prev_y, curr_x, curr_y);
            edges[idx_edge] = e;

            // check if there is any crossing with idx_edge - 3 and -5
            for(int j = 3; j <= 5; j++) {

                if((i+1) <= j) { break; }
                
                int prev_idx = idx_edge - j;
                if(prev_idx < 0) { prev_idx += 6; }
                Edge prev = edges[prev_idx];

                if(e.cross(prev)) { return true; }
            }
            
            prev_x = curr_x;
            prev_y = curr_y;
            dir = (dir+1)%2;
            idx_edge = (idx_edge+1)%6;
        }
        
        return false;
    }
}
