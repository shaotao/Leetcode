import java.io.*;
import java.util.*;


class ChampagneTower
{
    public static void main(String[] args)
    {
        System.out.println("=== ChampagneTower ===");
        Solution solution = new Solution();

        //System.out.println("amount = "+solution.champagneTower(1,1,1));
        //System.out.println("amount = "+solution.champagneTower(2,1,1));
        //System.out.println("amount = "+solution.champagneTower(4,2,0));
        //System.out.println("amount = "+solution.champagneTower(4,2,1));
        //System.out.println("amount = "+solution.champagneTower(4,2,2));
        //System.out.println("amount = "+solution.champagneTower(2,2,0));
        //System.out.println("amount = "+solution.champagneTower(6,2,0));
        System.out.println("amount = "+solution.champagneTower(2,0,0));
    }
}


class Solution
{
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] a = new double[100][100];
        for(int i = 0; i <= query_row; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == 0 && j == 0) { a[i][j] = poured; }
                else {
                    double left = (j-1>=0)?0.5*(a[i-1][j-1]-1):0;
                    left = (left>0)?left:0;
                    double right = (j<=i-1)?0.5*(a[i-1][j]-1):0;
                    right = (right >0)?right:0;

                    a[i][j] = left + right;
                }
            }
        }
        
        return a[query_row][query_glass]>1?1:a[query_row][query_glass];
    }
}

