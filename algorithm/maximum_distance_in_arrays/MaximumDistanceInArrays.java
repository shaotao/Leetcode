import java.io.*;
import java.util.*;


class MaximumDistanceInArrays
{
    public static void main(String[] args)
    {
	System.out.println("=== Maximum Distance in Arrays ===");
	Solution solution = new Solution();
        //List<Integer> l1 = Arrays.asList(new Integer[]{1,2,3});
        //List<Integer> l2 = Arrays.asList(new Integer[]{4,5});
        //List<Integer> l3 = Arrays.asList(new Integer[]{1,2,3});

        //Integer[][] inputs = {{1,2,3}, {4,5}, {1,2,3}};
        
        //Integer[][] inputs = {{1,5}, {3,4}};

        //Integer[][] inputs = {{-1,1}, {-3,1,4}, {-2,-1,0,2}};

        Integer[][] inputs = {{-8,-7,-7,-5,1,1,3,4},{-2},{-10,-10,-7,0,1,3},{2}};
        
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        for(Integer[] input: inputs) {
            List<Integer> list = Arrays.asList(input);
            arrays.add(list);
        }
        
        System.out.println("arrays = "+arrays);
        System.out.println("max distance = "+solution.maxDistance(arrays));
    }
}

class Point {
    int idx = -1;
    int val = -1;

    public String toString() {
        return String.format("Point(idx=%s, val=%s)", idx, val);
    }
}

class Solution
{
    public int maxDistance(List<List<Integer>> arrays) {
        int ret = 0;

        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();
        
        int num_lists = arrays.size();
        for(int i = 0; i < num_lists; i++) {
            List<Integer> list = arrays.get(i);
            int left = list.get(0);
            int right = list.get(list.size()-1);

            //System.out.println("left = "+left+", right = "+right);
            
            if(p1.idx==-1 || p1.val > left) {
                p2.idx = p1.idx; p2.val = p1.val;
                p1.idx = i; p1.val = left;
            } else if(p2.idx == -1 || p2.val > left) {
                p2.idx = i; p2.val = left;
            }

            if(p4.idx==-1 || p4.val < right) {
                p3.idx = p4.idx; p3.val = p4.val;
                p4.idx = i; p4.val = right;                
            } else if(p3.idx==-1 ||p3.val < right) {
                p3.idx = i; p3.val = right;
            }

            //System.out.println("p1="+p1);
            //System.out.println("p2="+p2);
            //System.out.println("p3="+p3);
            //System.out.println("p4="+p4);
            //System.out.println("<<<<<<<");
        }

        // check p1-p4, p1-p3, p2-p3, p2-p4
        int[] a = {0,0,0,0};
        if(p1.idx != p4.idx) {
            a[0] = (int)Math.abs(p1.val - p4.val);
        }

        if(p1.idx != p3.idx) {
            a[1] = (int)Math.abs(p1.val - p3.val);
        }

        if(p2.idx != p4.idx) {
            a[2] = (int)Math.abs(p2.val - p4.val);
        }

        if(p2.idx != p3.idx) {
            a[3] = (int)Math.abs(p2.val - p3.val);
        }

        for(int i : a) {
            ret = (ret < i)?i:ret;
        }
        
        return ret;
    }
}
