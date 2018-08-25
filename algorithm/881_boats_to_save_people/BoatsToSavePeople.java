import java.io.*;
import java.util.*;


class BoatsToSavePeople
{
    public static void main(String[] args)
    {
        System.out.println("=== Boats to Save People ===");
        Solution solution = new Solution();
        int[][] people_array = new int[][]{{1,2},
                                           {3,2,2,1},
                                           {3,5,3,4},
                                           {3,2,3,2,2}};
        int[] limit_array = {3, 3, 5, 6};
        for (int i = 0; i < people_array.length; i++) {
            int[] people = people_array[i];
            int limit = limit_array[i];
            System.out.println("people="+Arrays.toString(people)+", limit="+limit+", num of boats = "+solution.numRescueBoats(people, limit));
        }
    }
}


class Solution
{
    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0 || limit < 1) {
            return -1;
        }
        
        Arrays.sort(people);

        int i = 0;
        int j = people.length-1;
        int count = 0;
        int num = 0;
        int weight = 0;
        while(i <= j) {
            while(num < 2 && j>= 0 && weight+people[j] <= limit) {
                weight += people[j];
                num++;
                j--;
            }
            while(num < 2 && i < people.length && weight+people[i] <= limit) {
                weight += people[i];
                num++;
                i++;
            }
            weight = 0;
            num = 0;
            count++;
        }
        return count;
    }
}
