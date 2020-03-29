import java.io.*;
import java.util.*;


class HIndex2
{
    public static void main(String[] args)
    {
        System.out.println("=== H-Index II ===");
        Solution solution = new Solution();
        int[][] arrays = {{0,1,3,5,6},
                          {1}};
        for(int[] citations: arrays) {
            int h = solution.hIndex(citations);
            print_citations(citations);
            System.out.println("h-index2 = "+h);
        }
    }

    public static void print_citations(int[] citations) {
        if(citations == null) {
            System.out.println("citations is null!");
        }
        System.out.print("citations: ");
        for(int citation: citations) {
            System.out.print(citation+",");
        }
        System.out.println();
    }
}

class Solution
{
    public int hIndex(int[] citations)
    {
        if(citations == null) {
            return 0;
        }
        
        int size = citations.length;

        int i = size;
        while(i >= 1) {
            if(citations[i-1] < (size-i+1)) { break; }
            i--;
        }
        
        return (size-i);
    }
}
