import java.io.*;
import java.util.*;


class QueueReconstructionByHeight
{
    public static void main(String[] args)
    {
        System.out.println("=== Queue Reconstruction by Height ===");
        Solution solution = new Solution();

        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println("people = "+Arrays.deepToString(people));

        int[][] queue = solution.reconstructQueue(people);
        System.out.println("queue = "+Arrays.deepToString(queue));
    }
}


class Solution
{
    public int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][];

        for (int i = 0; i < people.length; i++) {
            for (int j = i+1; j < people.length; j++) {
                int[] p1 = people[i];
                int[] p2 = people[j];
                if (p1[0] > p2[0] || ((p1[0] == p2[0]) && (p1[1] > p2[1]))) {
                    int[] tmp = people[i];
                    people[i] = people[j];
                    people[j] = tmp;
                }
            }
        }

        System.out.println("people = "+Arrays.deepToString(people));

        for (int[] p : people) {
            int count = 0;
            for(int i = 0; i < queue.length; i++) {
                if (count == p[1] && queue[i] == null) {
                    queue[i] = p;
                    break;
                }
                int[] si = queue[i];
                if (si == null || si[0] >= p[0]) {
                    count++;
                }
            }
        }
        
        return queue;
    }
}
