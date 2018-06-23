import java.io.*;
import java.util.*;


class AllPathsFromSourceToTarget
{
    public static void main(String[] args)
    {
        System.out.println("=== All Paths From Source to Target ===");
        Solution solution = new Solution();
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println("graph = "+Arrays.deepToString(graph));
        System.out.println("paths = "+solution.allPathsSourceTarget(graph));
    }
}


class Node
{
    int id;
    List<Node> nbrs;
    public Node(int id) {
        this.id = id;
        this.nbrs = new ArrayList<>();
    }
    public int getId() { return id; }
    public void addNbr(Node n) { nbrs.add(n); }
    public List<Node> getNbrs() { return nbrs; }
}

class Solution
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        Map<Integer, Node> nodes = getNodes(graph);
        Node src = nodes.get(0);
        Node dst = nodes.get(graph.length-1);

        List<Integer> path = new ArrayList<Integer>();

        trace(src, dst, path, ret);
        
        return ret;
    }

    private void trace(Node src, Node dst, List<Integer> path, List<List<Integer>> ret) {
        if (src == null || dst == null) { return; }

        // add src node to path
        path.add(src.getId());

        if (src.getId() == dst.getId()) {
            ret.add(new ArrayList<Integer>(path));
        } else {
            for (Node nbr : src.getNbrs()) {
                trace(nbr, dst, path, ret);
            }
        }
        
        // remove last id from path and return
        path.remove((int)(path.size()-1));
        return;
    }

    private Node getNode(Map<Integer, Node> nodes, int id) {
        Node n = nodes.get(id);
        if (n == null) {
            n = new Node(id);
            nodes.put(id, n);
        }

        return n;
    }

    private Map<Integer, Node> getNodes(int[][] graph) {
        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            int[] nbrs = graph[i];            
            Node src = getNode(nodes, i);
            for (int nbr : graph[i]) {
                Node dst = getNode(nodes, nbr);
                src.addNbr(dst);
            }
        }

        return nodes;
    }
}
