import java.io.*;
import java.util.*;


class LoudAndRich
{
    public static void main(String[] args)
    {
        System.out.println("=== Loud And Rich ===");
        Solution solution = new Solution();
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        //int[][] richer ={};
        //int[] quiet = {0};
        int[] ret = solution.loudAndRich(richer, quiet);
        System.out.println("richer = "+Arrays.deepToString(richer));
        System.out.println("quiet = "+Arrays.toString(quiet));
        System.out.println("ret = "+Arrays.toString(ret));
    }
}

class Node
{
    private int id;
    private List<Node> richer;

    public Node(int id) {
        this.id = id;
        this.richer = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }
    
    public List<Node> getRicher() {
        return richer;
    }

    public void addRicher(Node n) {
        this.richer.add(n);
    }
}


class Solution
{
    public Node getNode(Map<Integer, Node> map, int id) {
        Node n = map.get(id);
        if (n == null) {
            n = new Node(id);
            map.put(id, n);
        }

        return n;
    }

    private void findLoudest(Node root, int[] quiet, int[] ret) {
        List<Node> check = new ArrayList<>();
        check.add(root);

        int min = quiet[root.getId()];
        int minId = root.getId();
        Set<Node> added = new HashSet<>();
        added.add(root);

        for (int i = 0; i < check.size(); i++) {
            Node n = check.get(i);

            if (ret[n.getId()] >= 0) {
                if (quiet[ret[n.getId()]] < min) {
                    min = quiet[ret[n.getId()]];
                    minId = ret[n.getId()];
                }
            } else {
                List<Node> richer = n.getRicher();
                for (Node x : richer) {
                    if (!added.contains(x)) {
                        check.add(x);
                        added.add(x);
                    }
                }
                if (quiet[n.getId()] < min) {
                    min = quiet[n.getId()];
                    minId = n.getId();
                }
            }
        }

        ret[root.getId()] = minId;
    }
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ret = new int[quiet.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = -1;
        }

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            Node n = new Node(i);
            map.put(i, n);
        }

        for(int[] pair : richer) {
            Node larger = getNode(map, pair[0]);
            Node smaller = getNode(map, pair[1]);
            smaller.addRicher(larger);
        }

        for(int i = 0; i < ret.length; i++) {
            findLoudest(map.get(i), quiet, ret);
        }
        
        return ret;
    }
}
