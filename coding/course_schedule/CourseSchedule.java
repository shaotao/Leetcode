import java.io.*;
import java.util.*;


class CourseSchedule
{
    public static void main(String[] args)
    {
        System.out.println("=== Course Schedule ===");
        Solution solution = new Solution();
        int[] numCourses = {2, 2, 8};
        int[][][] input = {
            {{1,0}},
            {{1,0}, {0,1}},
            {{1,0}, {2,6}, {1,7}, {6,4}, {7,0}, {0,5}}
        };

        boolean ret = false;
        for(int i = 0; i < input.length; i++) {
            ret = solution.canFinish(numCourses[i], input[i]);
            System.out.print((i+1)+") list = ");
            printArray(input[i]);
            System.out.println("can finish: "+ret);
        }
    }

    public static void printArray(int[][] array) {
        for(int[] edge: array) {
            System.out.print("("+edge[0]+", "+edge[1]+"), ");
        }
        System.out.println();
    }
}

class Solution
{
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0 || prerequisites == null) { return false; }

        // dependence matrix
        boolean[][] dep = new boolean[numCourses][numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int j = 0; j < numCourses; j++) {
                dep[i][j] = false;
            }
        }

        // populate the connectivity matrix
        for(int[] edge: prerequisites) {
            int from_id = edge[0];
            int to_id = edge[1];

            dep[from_id][to_id] = true;
        }

        // use the dependence to check for loops
        // first we need to detect the list of root nodes
        ArrayList<Integer> roots = new ArrayList<Integer>();
        for(int row = 0; row < numCourses; row++) {
            boolean isRoot = true;
            for(int col = 0; col < numCourses; col++) {
                if(dep[row][col]) { isRoot = false; break; }
            }
            if(isRoot) { roots.add(row); }
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> step = new HashMap<Integer, Integer>();

        boolean noLoop = true;
        for(Integer root: roots) {
            boolean ret = noLoop(numCourses, dep, root, map, step);
            if(ret == false) {
                noLoop = false;
                break;
            }
        }

        //System.out.println("noLoop = "+noLoop);
        //System.out.println("step.size() = "+step.size());
        
        return (noLoop && step.size() == numCourses);
    }

    public boolean noLoop(int numCourses, boolean[][] dep, int id, HashMap<Integer, Integer> map, HashMap<Integer, Integer> step) {
        if(map.get(id) != null) { return false; }
        else {
            map.put(id, id);
            step.put(id, id);
            for(int row = 0; row < numCourses; row++) {
                if(dep[row][id]) {
                    boolean ret = noLoop(numCourses, dep, row, map, step);
                    if(!ret) { return false; }
                    map.remove(row);
                }
            }
        }
        map.remove(id);
        return true;
    }

    // iterative update the dependency matrix and check for symmetric entries
    // until no more updates can be made
    // if matrix[i][j] == true and matrix[j][i] == true, loop is detected!
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0 || prerequisites == null) { return false; }

        // dependence matrix
        boolean[][] dep = new boolean[numCourses][numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int j = 0; j < numCourses; j++) {
                dep[i][j] = false;
            }
        }

        // populate the connectivity matrix
        for(int[] edge: prerequisites) {
            int from_id = edge[0];
            int to_id = edge[1];

            dep[from_id][to_id] = true;
        }

        // now we use the dependence matrix to detect loops
        boolean updated = true;
        while(updated == true) {
            updated = false;

            for(int i = 0; i < numCourses; i++) {
                for(int j = 0; j < numCourses; j++) {
                    if(dep[i][j] == true) {
                        for(int row = 0; row < numCourses; row++) {
                            if(dep[row][i] == true && dep[row][j] != true) {
                                dep[row][j] = true;
                                updated = true;
                                if(dep[j][row] == true) { return false; }
                            }
                        }
                    }
                }
            }
        }

        // check if we have dep[i][j] = dep[j][i], -> loop
        for(int i = 0; i < numCourses; i++) {
            for(int j = i+1; j < numCourses; j++) {
                if(dep[i][j] == true && dep[j][i] == true) { return false; }
            }
        }
        
        return true;
    }
}
