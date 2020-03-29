import java.io.*;
import java.util.*;


class GroupsOfSpecialEquivalentStrings
{
    public static void main(String[] args)
    {
        System.out.println("=== Groups of Special-Equivalent Strings ===");
        Solution solution = new Solution();
        String[][] input = new String[][]{{"a","b","c","a","c","c"},
                                          {"aa","bb","ab","ba"},
                                          {"abc","acb","bac","bca","cab","cba"},
                                          {"abcd","cdab","adcb","cbad"}};
        for (String[] A : input) {
            System.out.println("A = "+Arrays.toString(A));
            System.out.println("# of groups = "+solution.numSpecialEquivGroups(A));
        }
    }
}


class Solution
{
    class Group
    {
        Map<Character, Integer> mapOdd;
        Map<Character, Integer> mapEven;

        public Group() {
            mapOdd = new HashMap<Character, Integer>();
            mapEven = new HashMap<Character, Integer>();
        }

        public boolean same(Group group) {
            if (this.mapOdd.size() != group.mapOdd.size() ||
                this.mapEven.size() != group.mapEven.size()) {
                return false;
            }

            for (Character ch : mapOdd.keySet()) {
                if (!group.mapOdd.containsKey(ch) ||
                    mapOdd.get(ch) != group.mapOdd.get(ch)) {
                    return false;
                }
            }

            for (Character ch : mapEven.keySet()) {
                if (!group.mapEven.containsKey(ch) ||
                    mapEven.get(ch) != group.mapEven.get(ch)) {
                    return false;
                }
            }

            return true;
        }
    }

    private Group getGroup(String s) {
        Group g = new Group();
        for(int i = 0; i < s.length(); i+=2) {
            int count = 1;
            if (g.mapEven.containsKey(s.charAt(i))) {
                count += g.mapEven.get(s.charAt(i));
            }
            g.mapEven.put(s.charAt(i), count);
            
        }

        for (int i = 1; i < s.length(); i+=2) { 
            int count = 1;
            if (g.mapOdd.containsKey(s.charAt(i))) {
                count += g.mapOdd.get(s.charAt(i));
            }
            g.mapOdd.put(s.charAt(i), count);
        }
        return g;
    }
    
    public int numSpecialEquivGroups(String[] A) {
        int ret = 0;

        List<Group> list = new ArrayList<Group>();
        for (String s:A) {
            Group g = getGroup(s);
            boolean duplicated = false;
            for (Group i : list) {
                if (i.same(g)) {
                    duplicated = true;
                    break;
                }
            }
            if (!duplicated) {
                list.add(g);
            }
        }
        
        return list.size();
    }
}
