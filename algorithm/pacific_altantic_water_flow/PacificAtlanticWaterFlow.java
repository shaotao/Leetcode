import java.io.*;
import java.util.*;


class PacificAtlanticWaterFlow
{
    public static void main(String[] args)
    {
	System.out.println("=== Pacific Atlantic Water Flow ===");
	Solution solution = new Solution();

        int[][] matrix = {{1,2,2,3,5},
                          {3,2,3,4,4},
                          {2,4,5,3,1},
                          {6,7,1,4,5},
                          {5,1,1,2,4}};

        List<int[]> list = solution.pacificAtlantic(matrix);
        System.out.println("matrix = "+Arrays.deepToString(matrix));

        System.out.println("list size = "+list.size());
        for(int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}

class Node
{
    int height = -1;
    boolean p = false;
    boolean a = false;
    ArrayList<Node> upstream;
    
    public Node(int height, boolean p, boolean a) {
        this.height = height;
        this.p = p;
        this.a = a;
        upstream = new ArrayList<>();
    }

    public boolean both() {
        return (p && a);
    }

    public boolean upStream(Node up) {
        return this.height <= up.height;
    }
}

class Solution
{
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<int[]>();
        ArrayList<Node> nodes = new ArrayList<>();

        if(matrix == null || matrix.length == 0) {
            return ret;
        }
        
        // m+n+2 nodes
        Node pacific = new Node(-1, true, false);
        Node atlantic = new Node(-1, false, true);

        int m = matrix.length;
        int n = matrix[0].length;
        populateEdges(matrix, nodes);

        // add edges for pacific and atlantic
        for(int j = 0; j < n; j++) {
            pacific.upstream.add(nodes.get(j));
        }

        for(int i = 1; i < m; i++) {
            pacific.upstream.add(nodes.get(i*n));
        }

        for(int j = 0; j < n; j++) {
            atlantic.upstream.add(nodes.get((m-1)*n+j));
        }

        for(int i = 1; i <= m; i++) {
            atlantic.upstream.add(nodes.get(i*n-1));
        }

        flood(pacific, 1);
        flood(atlantic, 2);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Node node = nodes.get(i*n+j);
                if(node.both()) {
                    int[] array = new int[2];
                    array[0] = i;
                    array[1] = j;
                    ret.add(array);
                }
            }
        }
        
        return ret;
    }

    public void populateEdges(int[][] matrix, ArrayList<Node> nodes) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i <m; i++) {
            for(int j = 0; j <n; j++) {
                Node node = new Node(matrix[i][j], false, false);
                nodes.add(node);                
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Node curr = nodes.get(i*n+j);
                if(i-1 >= 0) {
                    Node up = nodes.get((i-1)*n + j);
                    if(curr.upStream(up)) {
                        curr.upstream.add(up);
                    }
                }

                if(i+1 < m) {
                    Node up = nodes.get((i+1)*n + j);
                    if(curr.upStream(up)) {
                        curr.upstream.add(up);
                    }
                }

                if(j-1 >= 0) {
                    Node up = nodes.get(i*n + j-1);
                    if(curr.upStream(up)) {
                        curr.upstream.add(up);
                    }
                }

                if(j+1 < n) {
                    Node up = nodes.get(i*n + j+1);
                    if(curr.upStream(up)) {
                        curr.upstream.add(up);
                    }
                }
            }
        }
    }
    
    private void flood(Node root, int source) {
        if(source == 1) {
            if(root.p == false) { return; }
            for(Node n: root.upstream) {
                if(n.p == true) { continue; }
                n.p = true;
                flood(n, 1);
            }
        } else {
            if(root.a == false) { return; }
            for(Node n: root.upstream) {
                if(n.a == true) { continue; }
                n.a = true;
                flood(n, 2);
            }
        }
    }
}
