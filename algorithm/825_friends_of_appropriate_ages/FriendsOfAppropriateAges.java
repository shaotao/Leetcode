import java.io.*;
import java.util.*;


class FriendsOfAppropriateAges
{
    public static void main(String[] args)
    {
        System.out.println("=== Friends of Appropriate Ages ===");
        Solution solution = new Solution();
        int[][] input = {{16, 16}, {16, 17, 18}, {20, 30, 100, 110, 120}};
        for (int[] ages : input) {
            System.out.println("ages = "+Arrays.toString(ages));
            System.out.println("# friend requests = "+solution.numFriendRequests(ages));
        }
    }
}


class Solution
{
    public boolean valid(int A, int B) {
        if ( B <= (A*0.5 + 7) ||
             B > A ||
             (B > 100 && A < 100)) {
            return false;
        }
        return true;
    }
    
    public int numFriendRequests(int[] ages) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for (int age: ages) {
            int count = 1;
            if (map.containsKey(age)) {
                count += map.get(age);
            } else {
                list.add(age);
            }
            map.put(age, count);
        }

        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            int ageI = list.get(i);
            int countI = map.get(ageI);
            for (int j = i; j < list.size(); j++) {
                int ageJ = list.get(j);
                int countJ = map.get(ageJ);

                if (valid(ageJ, ageI)) {
                    if (ageI != ageJ) {
                        total += countI * countJ;
                    } else {
                        total += countJ*(countJ-1);
                    }
                }
            }
        }
        
        return total;
    }
}
