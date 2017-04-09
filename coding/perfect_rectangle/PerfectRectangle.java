import java.io.*;
import java.util.*;


class PerfectRectangle
{
    public static void main(String[] args)
    {
	System.out.println("=== Perfect Rectangle ===");
	Solution solution = new Solution();

        int[][][] inputs = { {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}},
                             {{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}},
                             {{1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4}},
                             {{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}}
        };

        for(int[][] input:inputs) {
            boolean ret = solution.isRectangleCover(input);
            System.out.println("rectangles = "+Arrays.deepToString(input)+"\n ret = "+ret);
        }
    }
}


class Solution
{
    public boolean isRectangleCover(int[][] rectangles) {
        boolean ret = false;

        if(rectangles.length == 0) { return false; }
        
        int bl_x = rectangles[0][0];
        int bl_y = rectangles[0][1];
        int tr_x = rectangles[0][2];
        int tr_y = rectangles[0][3];

        double sum_area = 0;        
        for(int[] block: rectangles) {
            bl_x = (bl_x <= block[0])?bl_x:block[0];
            bl_y = (bl_y <= block[1])?bl_y:block[1];
            tr_x = (tr_x >= block[2])?tr_x:block[2];
            tr_y = (tr_y >= block[3])?tr_y:block[3];

            sum_area += (block[2]-block[0])*(block[3]-block[1]);
        }

        double max_area = (tr_y-bl_y)*(tr_x-bl_x);

        if(sum_area != max_area) { return false; }

        int[][] matrix = new int[tr_x - bl_x][tr_y - bl_y];
        for(int i = 0; i < tr_x - bl_x; i++) {
            for(int j = 0; j < tr_y - bl_y; j++) {
                matrix[i][j] = 0;
            }
        }

        for(int[] rectangle:rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            for(int i = 0; i < x2 - x1; i++) {
                for(int j = 0; j < y2 - y1; j++) {
                    matrix[x1-bl_x + i][y1-bl_y+j] = 1;
                }
            }
        }

        for(int i = 0; i < tr_x - bl_x; i++) {
            for(int j = 0; j < tr_y - bl_y; j++) {
                if(matrix[i][j] == 0) { return false; }
            }
        }        
        
        return true;
    }
    
    public boolean isRectangleCover2(int[][] rectangles) {
        boolean ret = false;

        if(rectangles.length == 0) { return false; }
        
        int bl_x = rectangles[0][0];
        int bl_y = rectangles[0][1];
        int tr_x = rectangles[0][2];
        int tr_y = rectangles[0][3];

        double sum_area = 0;        
        for(int[] block: rectangles) {
            bl_x = (bl_x <= block[0])?bl_x:block[0];
            bl_y = (bl_y <= block[1])?bl_y:block[1];
            tr_x = (tr_x >= block[2])?tr_x:block[2];
            tr_y = (tr_y >= block[3])?tr_y:block[3];

            sum_area += (block[2]-block[0])*(block[3]-block[1]);
        }

        double max_area = (tr_y-bl_y)*(tr_x-bl_x);

        //System.out.println(bl_x+","+bl_y+","+tr_x+","+tr_y);
        //System.out.println("max_area = "+max_area+", sum_area = "+sum_area);
        
        if(sum_area != max_area) { return false; }

        // now check for overlapping
        for(int i = 0; i < rectangles.length; i++) {
            int[] block1 = rectangles[i];
            for(int j = i+1; j < rectangles.length; j++) {
                int[] block2 = rectangles[j];

                if(overlapped(block1, block2)) { return false; }
            }
        }

        return true;
    }

    public boolean overlapped(int[] block1, int[] block2) {
        int x1 = block1[0];
        int y1 = block1[1];
        int x2 = block1[2];
        int y2 = block1[3];

        int x3 = block2[0];
        int y3 = block2[1];
        int x4 = block2[2];
        int y4 = block2[3];

        boolean x_crossed = false;
        boolean y_crossed = false;

        x_crossed = ( (x2>x3 && x2<=x4) || (x1<x4 && x2>=x4) ) ||
            ( (x4>x1 && x4<=x2) || (x3<x2 && x4>=x2) );

        y_crossed = ( (y2>y3 && y2<=y4) || (y1<y4 && y2>=y4) ) ||
            ( (y4>y1 && y4<=y2) || (y3<y2 && y4>=y2) );

        return (x_crossed && y_crossed);
    }
}
