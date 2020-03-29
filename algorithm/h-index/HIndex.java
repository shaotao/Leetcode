import java.io.*;
import java.util.*;


class HIndex
{
    public static void main(String[] args)
    {
        System.out.println("=== H-Index ===");
        Solution solution = new Solution();
        int[][] arrays = {{3,0,6,1,5},
                             {1}};
        for(int[] citations: arrays) {
            int h = solution.hIndex(citations);
            print_citations(citations);
            System.out.println("h-index = "+h);
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
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                if(citations[i] < citations[j]) {
                    int tmp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = tmp;
                }
            }
        }

        int i = 0;
        while(i < size && citations[i] >= (i+1)) {
            i++;
        }
        
        return i;
    }
}
