import java.io.*;
import java.util.*;


class BaseballGame
{
    public static void main(String[] args)
    {
	System.out.println("=== Baseball Game ===");
	Solution solution = new Solution();
        String[][] array_ops = {{"5", "2", "C", "D", "+"},
                                {"5", "-2", "4", "C", "D", "9", "+", "+"}};
        for (String[] ops: array_ops) {
            System.out.println("ops = "+Arrays.toString(ops));
            System.out.println("points = "+solution.calPoints(ops));
        }
    }
}


class Solution
{
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) { return 0; }
        ArrayList<Integer> list = new ArrayList<>();

        for (String op : ops) {
            switch (op) {
            case "C":
                list.remove((int)(list.size()-1));
                break;
            case "D":
                list.add(2*list.get(list.size()-1));
                break;
            case "+":
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
                break;
            default:
                Integer val = new Integer(op);
                list.add(val);
                break;
            }
        }   

        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
