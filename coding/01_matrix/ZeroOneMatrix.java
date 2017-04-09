import java.io.*;
import java.util.*;


class ZeroOneMatrix
{
    public static void main(String[] args)
    {
	System.out.println("=== 01 Matrix ===");
	Solution solution = new Solution();

        // int[][] array = {{0,0,0},
        //                  {0,1,0},
        //                  {1,1,1}};
        int[][] array = {{0,1,0},
                         {0,1,0},
                         {0,1,0}};
        List<List<Integer>> matrix = Solution.makeList(array);

        List<List<Integer>> ret = solution.updateMatrix(matrix);
        System.out.println("ret = "+ret);
    }

}


class Solution
{
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return matrix;
        }

        List<Integer> zeroes = new ArrayList<Integer>();
        int num_rows = matrix.size();
        int num_cols = matrix.get(0).size();
        int[][] array = new int[num_rows][num_cols];
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                array[i][j] = matrix.get(i).get(j);
                if(array[i][j] == 0) { zeroes.add(i*num_cols + j); }
            }
        }

        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                if(array[i][j] == 0) { continue; }

                int min_dist = -1;
                for(Integer p : zeroes) {
                    int x = p/num_cols;
                    int y = p%num_cols;

                    int dist = ((x>i)?(x-i):(i-x)) + ((y>j)?(y-j):(j-y));
                    //System.out.println("i="+i+", j="+j+", dist = "+dist);
                    if(min_dist == -1 || min_dist > dist) { min_dist = dist; }
                }
                array[i][j] = min_dist;
            }
        }

        List<List<Integer>> ret = makeList(array);
        return ret;
    }

    public List<List<Integer>> updateMatrix2(List<List<Integer>> matrix) {
        if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return matrix;
        }

        List<Integer> zeroes = new ArrayList<Integer>();
        int num_rows = matrix.size();
        int num_cols = matrix.get(0).size();
        int[][] array = new int[num_rows][num_cols];
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                array[i][j] = matrix.get(i).get(j);
                if(array[i][j] == 0) { zeroes.add(i*num_cols + j); }
            }
        }

        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                if(array[i][j] == 0) { continue; }

                int min_dist = -1;
                for(Integer p : zeroes) {
                    int x = p/num_cols;
                    int y = p%num_cols;

                    int dist = ((x>i)?(x-i):(i-x)) + ((y>j)?(y-j):(j-y));
                    //System.out.println("i="+i+", j="+j+", dist = "+dist);
                    if(min_dist == -1 || min_dist > dist) { min_dist = dist; }
                }
                array[i][j] = min_dist;
            }
        }

        List<List<Integer>> ret = makeList(array);
        return ret;
    }

    public static List<List<Integer>> makeList(int[][] array) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i = 0; i < array.length; i++) {
            List<Integer> l = new ArrayList<Integer>();
            for(int j = 0; j < array[i].length; j++) {
                l.add(array[i][j]);
            }
            list.add(l);
        }
        return list;
    }
}
