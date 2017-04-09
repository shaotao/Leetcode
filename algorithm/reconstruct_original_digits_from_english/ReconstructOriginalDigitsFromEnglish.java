import java.io.*;
import java.util.*;


public class ReconstructOriginalDigitsFromEnglish
{
    public static void main(String[] args)
    {
        System.out.println("=== Reconstruct Original Digits From English ===");
        Solution solution = new Solution();
        String[] inputs = {"owoztneoer", "fviefuro"};

        for(String input: inputs) {
            System.out.println(input+": "+solution.originalDigits(input));
        }
    }
}

class Solution
{

    String[] numbers = { "zero", "one", "two", "three", "four",
                         "five", "six", "seven", "eight", "nine" };
    HashMap<Character, Character> key_map = null;
    ArrayList<HashMap<Character, Integer>> map_list = null;
    HashMap<Character, ArrayList<Integer>> rmap = null;
    ArrayList<Character> order = null;

    public Solution() {
        key_map = new HashMap<Character, Character>();
        for(String n: numbers) {
            for(char ch: n.toCharArray()) {
                if(!key_map.containsKey(ch)) {
                    key_map.put(ch, ch);
                }
            }
        }

        map_list = new ArrayList<HashMap<Character, Integer>>();
        for(int i = 0; i < 10; i++) {
            HashMap<Character, Integer> map = stringToMap(numbers[i]);
            map_list.add(map);
        }

        rmap = new HashMap<Character, ArrayList<Integer>>();
        for(Character ch : key_map.keySet()) {
            for(int i = 0; i < 10; i++) {
                if(map_list.get(i).containsKey(ch)) {
                    if(rmap.containsKey(ch)) {
                        rmap.get(ch).add(i);
                    } else {
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(i);
                        rmap.put(ch, l);
                    }
                }
            }
        }

        // compute search oder based on rmap
        order = new ArrayList<Character>(key_map.keySet());
        for(int i = 0; i < order.size(); i++) {
            for(int j = i+1; j < order.size(); j++) {
                if(rmap.get(order.get(i)).size() > rmap.get(order.get(j)).size()) {
                    // swap i and j in order list
                    Character ci = order.get(i);
                    Character cj = order.get(j);
                    order.remove(i);
                    order.add(i, cj);
                    order.remove(j);
                    order.add(j, ci);
                }
            }
        }


        // convert each number to a list of numbers(# of occurrance of char)
        // the order is defined by order list
        ArrayList<ArrayList<Integer>> feature_list = new ArrayList<ArrayList<Integer>>();

        int i = 0;
        for(HashMap<Character, Integer> map : map_list) {
            ArrayList<Integer> feature = mapToFeature(map);

            // debug feature
            //System.out.println(i+" feature = "+feature);
            i++;
        }

    }

    public HashMap<Character, Integer> stringToMap(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()) {
            if (map.containsKey(ch)) { map.put(ch, map.get(ch)+1); } 
            else { map.put(ch, 1); }
        }

        return map;
    }

    public ArrayList<Integer> mapToFeature(HashMap<Character, Integer> map) {
        ArrayList<Integer> feature = new ArrayList<Integer>();
        for(Character ch: order) {
            if (!map.containsKey(ch)) {
                feature.add(0);
            } else {
                feature.add(map.get(ch));
            }
        }
        return feature;
    }

    public String originalDigits(String s) {
        String ret = "";

        HashMap<Character, Integer> s_map = stringToMap(s); 
        ArrayList<Integer> f = mapToFeature(s_map); 
        //System.out.println("s_feature = "+f);

        int x0 = f.get(4);
        int x1 = f.get(13) - f.get(4) - f.get(2) - f.get(1);
        int x2 = f.get(2);
        int x3 = f.get(6) - f.get(0);
        int x4 = f.get(1);
        int x5 = f.get(8) - f.get(1);
        int x6 = f.get(3);
        int x7 = f.get(7) - f.get(3);
        int x8 = f.get(0);
        int x9 = f.get(12) + f.get(1) - f.get(0) - f.get(3) - f.get(8);

        int[] v = new int[] {x0, x1, x2, x3, x4, x5, x6, x7, x8, x9};
        //System.out.println("v = "+Arrays.toString(v));
        //
        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v[i]; j++) { ret += i; }
        }

        return ret;
    }
}



/*
 *
=== Reconstruct Original Digits From English ===
order = [g, u, w, x, z, v, h, s, f, t, r, n, i, o, e]
0 feature = [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1]
1 feature = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1]
2 feature = [0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0]
3 feature = [0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 2]
4 feature = [0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0]
5 feature = [0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1]
6 feature = [0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0]
7 feature = [0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2]
8 feature = [1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1]
9 feature = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 1]
s_feature = [0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 3, 2]
v = [1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
owoztneoer: null
s_feature = [0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 1, 0, 1, 1, 1]
v = [0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
fviefuro: null


x0 = s4
x2 = s2
x4 = s1
x6 = s3
x8 = s0

x5 + x7 = s5
x3 + x8 = s6
x6 + x7 = s7
x4 + x5 = s8
x2 + x3 + x8 = s9
x0 + x3 + x4 = s10
x1 + x7 + 2*x9 = s11
x5 + x6 + x8 + x9 = s12
x0 + x1 + x2 + x4 = s13
x0 + x1 + 2*x3 + x5 + 2*x7 + x8 + x9 = s14

==================================================

x0 = s4
x1 = s13 - s4 - s2 - s1
x2 = s2
x3 = s6 - s0
x4 = s1
x5 = s8 - s1
x6 = s3
x7 = s7 - s3
x8 = s0
x9 = s12 + s1 - s0 - s3 - s8

==============================


 * 
 * */
