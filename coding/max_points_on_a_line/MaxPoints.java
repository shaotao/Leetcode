import java.io.*;
import java.util.*;


class Point
{
    int x;
    int y;
    public Point()
    {
	x = 0;
	y = 0;
    }

    public Point(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
}

class MaxPoints
{
    public static void main(String[] args)
    {
	System.out.println("=== Max Points on a Line ===");

	Solution solution = new Solution();

	Point p1 = new Point(1, 1);
	Point p2 = new Point(2, 2);
	Point p3 = new Point(3, 3);
	
	Point[] points = {p1, p2, p3};
	
	int result = solution.maxPoints(points);
	
	System.out.println("max points = "+result);
    }
}

class Line
{
    Double k = null;
    Double h = null;
    Double x = null;
    
    public Line(Double k, Double h, Double x)
    {
        this.k = k;
        this.h = h;
        this.x = x;
    }
    
    public String toString()
    {
        return this.k+","+this.h+","+this.x;
    }
}

class Solution
{
    public int maxPoints(Point[] points)
    {
	ArrayList<Line> lines = new ArrayList<Line>();
        
        if(points.length < 2) {
            return points.length;
        }
	
	for(int i = 0; i < points.length; i++)
	{
            Point p_i = points[i];
	    for(int j = i+1; j < points.length; j++)
	    {
                Point p_j = points[j];

                Line new_line = null;
                if(p_i.x == p_j.x) {
                    new_line = new Line(null, null, new Double(p_i.x));
                } else {
                    double k = (p_j.y - p_i.y)/(p_j.x - p_i.x);
                    double h = p_i.y - k*p_i.x;
                    new_line = new Line(new Double(k), new Double(h), null); 
                }
                
                lines.add(new_line);
	    } 
	}

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        // now we have all the n^2 lines, check for the max number
        for(Line line: lines)
        {
            try {
                Integer count = map.get(line.toString());
                map.put(line.toString(), count+1);
            } catch(Exception e) {
                map.put(line.toString(), 1);
            }
        }

        Set<String> set = map.keySet();
        int max = 0;
        for(String key: set) {
            int count = map.get(key);
            if(max < count) { max = count; }
        }
        
        // max is C_n_2, where n is the number of points colinear
        int result = (1+(int)Math.sqrt(1+8*max))/2;
	return result;
    }
}

