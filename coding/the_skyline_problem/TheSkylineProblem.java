import java.io.*;
import java.util.*;


class TheSkylineProblem
{
    public static void main(String[] args)
    {
        System.out.println("=== The Skyline Problem ===");
        Solution solution = new Solution();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        //int[][] buildings = {{0,2,3}, {2,5,3}};
        List<int[]> skyline = solution.getSkyline(buildings);
        print_buildings(buildings);
        print_skyline(skyline);
    }

    public static void print_buildings(int[][] buildings) {
        if(buildings == null) {
            System.out.println("no buildings!");
            return;
        }
        System.out.print("buildings: ");
        System.out.print("[");
        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            System.out.print("[");
            for(int j = 0; j < building.length; j++) {
                System.out.print(building[j]);
                if(j < building.length-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i < buildings.length-1) {
                System.out.print(",");
            }
        }
        System.out.println("]");        
    }
    
    public static void print_skyline(List<int[]> ret) {
        if(ret == null) {
            System.out.println("no skyline!");
            return;
        }
        System.out.print("skyline: ");
        System.out.print("[");
        for(int i = 0; i < ret.size(); i++) {
            int[] array = ret.get(i);
            System.out.print("[");
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[j]);
                if(j < array.length-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i < ret.size()-1) {
                System.out.print(",");
            }
        }
        System.out.println("]");        
    }
}

class Point
{
    int x;
    int y;
    int id;
    boolean left;
    public Point(int x, int y, int id, boolean left) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.left = left;
    }

    public void copy(Point p) {
        if(p == null) { return; }
        this.x = p.x;
        this.y = p.y;
        this.id = p.id;
        this.left = p.left;
    }
}

class Solution
{
    public List<int[]> getSkyline(int[][] buildings) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        return list;
    }
    
    public List<int[]> getSkyline2(int[][] buildings) {
        ArrayList<int[]> list = new ArrayList<int[]>();

        // get the points
        ArrayList<Point> points = new ArrayList<Point>();
        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            int left = building[0];
            int right = building[1];
            int height = building[2];

            Point left_point = new Point(left, height, i, true);
            Point right_point = new Point(right, height, i, false);
            points.add(left_point);
            points.add(right_point);
        }

        // sort points by x
        Point tmp = new Point(0, 0, 0, true);
        for(int i = 0; i < points.size(); i++) {
            for(int j = i+1; j < points.size(); j++) {
                Point pi = points.get(i);
                Point pj = points.get(j);
                if(pi.x > pj.x || (pi.x == pj.x && (pi.left == false && pj.left == true))) {
                    tmp.copy(pi);
                    pi.copy(pj);
                    pj.copy(tmp);
                }
            }
        }

        // scan points, maintain a list of covered points sorted by height
        ArrayList<Point> hit = new ArrayList<Point>();
        int curr_y = 0;
        int curr_id = -1;
        for(Point p: points) {
            if(p.left == true) {
                // start point

                // add to hit
                int idx = 0;
                for(int i = 0; i < hit.size(); i++) {
                    if(p.y > hit.get(i).y) {
                        idx = i;
                        break;
                    } else {
                        idx++;
                    }
                }
                hit.add(idx, p);

                // if p.y is higher than currnt_y, set curr_y and curr_id,
                //    and update list
                // else do nothing
                if(p.y > curr_y) {
                    curr_y = p.y;
                    curr_id = p.id;

                    int[] target = {p.x, p.y};
                    list.add(target);
                }
            } else {
                // end point

                // 1(a). if end point is the current building
                // choose next point in hit, if change in height update list
                // 1(b). else if end point is not the current building
                // do nothing
                if(curr_id == p.id) {
                    if(hit.size() == 1) {
                        // no more building, compare height
                        if(curr_y > 0) {
                            int[] target = {p.x, 0};
                            list.add(target);
                        }

                        curr_id = -1;
                        curr_y = 0;
                    } else {
                        // there are more buildings left
                        // check if the next building is lower
                        // if lower, update list
                        // or else do nothing
                        if(curr_y > hit.get(1).y) {
                            int[] target = {p.x, hit.get(1).y};
                            list.add(target);
                        }

                        curr_id = hit.get(1).id;
                        curr_y = hit.get(1).y;
                    }
                }

                // 2. remove from hit
                int idx = -1;
                for(int i = 0; i < hit.size(); i++) {
                    if(p.id == hit.get(i).id) {
                        idx = i;
                        break;
                    }
                }

                hit.remove(idx);
            }
        }
        
        return list;
    }
}
