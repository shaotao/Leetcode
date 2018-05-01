import java.io.*;
import java.util.*;


class FloodFill
{
    public static void main(String[] args)
    {
        System.out.println("=== Flood Fill ===");
        Solution solution = new Solution();
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1; int sc = 1; int newColor = 2;
        System.out.println("image = "+Arrays.deepToString(image));
        System.out.println("sr="+sr+", sc"+sc+", newColor="+newColor);
        solution.floodFill(image, sr, sc, newColor);
        System.out.println("image = "+Arrays.deepToString(image));
    }
}


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int numRows = image.length;
        int numCols = image[0].length;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        int rootColor = image[sr][sc];
        int root = sr*100 + sc;
        set.add(root);
        list.add(root);

        int i = 0;
        while (i < list.size()) {
            int expr = list.get(i);
            int x = expr/100;
            int y = expr%100;

            image[x][y] = newColor;
            
            // up
            if (x-1 >= 0 && image[x-1][y] == rootColor) {
                if (!set.contains(expr-100)) {
                    set.add(expr-100);
                    list.add(expr-100);
                }
            }
            
            // down
            if (x+1 < numRows && image[x+1][y] == rootColor) {
                if (!set.contains(expr+100)) {
                    set.add(expr+100);
                    list.add(expr+100);
                }
            }
            
            // left
            if (y-1 >= 0 && image[x][y-1] == rootColor) {
                if (!set.contains(expr-1)) {
                    set.add(expr-1);
                    list.add(expr-1);
                }
            }
            
            // right
            if (y+1 < numCols && image[x][y+1] == rootColor) {
                if (!set.contains(expr+1)) {
                    set.add(expr+1);
                    list.add(expr+1);
                }
            }
            
            i++;
        }

        return image;
    }
}
