import java.io.*;
import java.util.*;


class FriendCircles
{
    public static void main(String[] args)
    {
	System.out.println("=== Friend Circles ===");
	Solution solution = new Solution();
        int[][] M1 = {{1,1,0},
                     {1,1,0},
                     {0,0,1}};
        int[][] M2 = {{1,1,0},
                     {1,1,1},
                     {0,1,1}};

        int[][] M3 = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                      {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                      {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                      {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                      {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                      {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                      {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                      {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                      {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                      {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};

        int[][] M4 = {{1,0,0,1},
                      {0,1,1,0},
                      {0,1,1,1},
                      {1,0,1,1}};

        int[][] M5 = {{1,1,1},
                      {1,1,1},
                      {1,1,1}};

        int[][] M6 = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                      {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                      {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                      {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                      {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                      {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                      {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                      {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                      {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                      {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                      {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                      {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        System.out.println("circle number = "+solution.findCircleNum(M1));
        System.out.println("circle number = "+solution.findCircleNum(M2));
        System.out.println("circle number = "+solution.findCircleNum(M3));
        System.out.println("circle number = "+solution.findCircleNum(M4));
        System.out.println("circle number = "+solution.findCircleNum(M5));
        System.out.println("circle number = "+solution.findCircleNum(M6));
    }
}


class Solution
{
    public int findCircleNum(int[][] M) {
        int count = 0;
        if(M == null || M.length == 0) { return 0; }
        int size = M.length;
        int[] roots = new int[size];
        for(int i = 0; i < size; i++) {
            roots[i] = -1;
        }
        
        for(int i = 0; i < size; i++) {
            flood(i, i, M, roots);
        }

        // check roots array
        HashSet<Integer> set = new HashSet<>();
        for(int root : roots) {
            set.add(root);
        }

        return set.size();
    }

    private void flood(int root, int source, int[][] M, int[] roots) {
        if(roots[source] >= 0) { return; }
        roots[source] = root;
        for(int i = 0; i < M.length; i++) {
            if(source == i) { continue; }
            if(M[source][i] == 1) {
                flood(root, i, M, roots);
            }
        }
    }
}
