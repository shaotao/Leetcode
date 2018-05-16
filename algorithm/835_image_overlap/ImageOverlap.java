import java.io.*;
import java.util.*;


class ImageOverlap
{
    public static void main(String[] args)
    {
        System.out.println("=== Image Overlap ===");
        Solution solution = new Solution();

        int[][] A = {{1,1,0},
                     {0,1,0},
                     {0,1,0}};
        int[][] B = {{0,0,0},
                     {0,1,1},
                     {0,0,1}};
        System.out.println("A = "+Arrays.deepToString(A));
        System.out.println("B = "+Arrays.deepToString(B));
        System.out.println("largest overlap = "+solution.largestOverlap(A,B));
    }
}


class Solution
{
    public int largestOverlap(int[][] A, int[][] B) {
        int size = A.length;
        // convert to 1d array of int for A and B
        int[] intA = new int[size];
        int[] intB = new int[size];

        for (int i = 0; i < size; i++) {
            intA[i] = arrayToInt(A[i]);
        }

        for (int i = 0; i < size; i++) {
            intB[i] = arrayToInt(B[i]);
        }

        int max = 0;
        for (int i = 0; i < size; i++) {   
            for (int j = 0; j < size; j++) {
                int[] tA = Arrays.copyOf(intA, size);
                shift(tA, i, j);
                int ret = overlap(tA, intB);
                //System.out.println("i = "+i+", j = "+j+", overlap = "+ret);
                //System.out.println("tA = "+Arrays.toString(tA)+", intB = "+Arrays.toString(intB));
                max = (max >= ret)?max:ret;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = -1; j > -size; j--) {
                int[] tA = Arrays.copyOf(intA, intA.length);
                shift(tA, i, j);
                int ret = overlap(tA, intB);
                //System.out.println("i = "+i+", j = "+j+", overlap = "+ret);
                //System.out.println("tA = "+Arrays.toString(tA)+", intB = "+Arrays.toString(intB));
                max = (max >= ret)?max:ret;
            }
        }

        for (int i = -1; i > -size; i--) {
            for (int j = 0; j < size; j++) {
                int[] tA = Arrays.copyOf(intA, intA.length);
                shift(tA, i, j);
                int ret = overlap(tA, intB);
                //System.out.println("i = "+i+", j = "+j+", overlap = "+ret);
                //System.out.println("tA = "+Arrays.toString(tA)+", intB = "+Arrays.toString(intB));
                max = (max >= ret)?max:ret;                
            }
        }
            
        for (int i = -1; i > -size; i--) {
            for (int j = -1; j > -size; j--) {
                int[] tA = Arrays.copyOf(intA, intA.length);
                shift(tA, i, j);
                int ret = overlap(tA, intB);
                //System.out.println("i = "+i+", j = "+j+", overlap = "+ret);
                //System.out.println("tA = "+Arrays.toString(tA)+", intB = "+Arrays.toString(intB));
                max = (max >= ret)?max:ret;                
            }
        }
        
        return max;
    }

    // convert array of 0,1 to int, max length = 30
    private int arrayToInt(int[] array) {
        int val = 0;
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == 1) {
                val += (1 << (array.length-1-i));
            }
        }

        return val;
    }

    private void shift(int[] A, int dx, int dy) {

        int mask = (int)(Math.pow(2, A.length)-1);
        
        if (dx < 0) {
            for(int i = 0; i < A.length; i++) {
                if (i-dx < A.length) {
                    A[i] = A[i-dx];
                } else {
                    A[i] = 0;
                }
            }
        } else {
            for (int i = A.length-1; i >= 0; i--) {
                if (i-dx >= 0) {
                    A[i] = A[i-dx];
                } else {
                    A[i] = 0;
                }
            }
        }

        if (dy < 0) {
            for (int i = 0; i < A.length; i++) {
                A[i] = ((A[i] << (-1*dy)) & mask);
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                A[i] = (A[i] >> dy);
            }
        }
    }

    private int overlap(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int x = (A[i] & B[i]);

            for (int j = 0; j < A.length; j++) {
                count += (x & (1<<j))>0?1:0;
            }
        }

        return count;
    }
}
