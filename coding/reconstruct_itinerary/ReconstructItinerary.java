import java.io.*;
import java.util.*;


class ReconstructItinerary
{
    public static void main(String[] args)
    {
	System.out.println("=== Reconstruct Itinerary ===");
	Solution solution = new Solution();

        String[][] tickets = {{"JFK", "SFO"},
                              {"JFK", "ATL"},
                              {"SFO", "ATL"},
                              {"ATL", "JFK"},
                              {"ATL", "SFO"}};

        List<String> itinerary = solution.findItinerary(tickets);

        System.out.print("itinerary: ");
        for(String airport : itinerary) {
            System.out.print(airport+", ");
        }
        System.out.println();
    }
}


class Node
{
    String name;
    ArrayList<Node> tos;

    public Node(String name) {
        this.name = name;
        this.tos = new ArrayList<Node>();
    }
}


class Solution
{
    public List<String> findItinerary(String[][] tickets) {

        ArrayList<String> ret = new ArrayList<String>();
        
        HashMap<String, Node> nodes = new HashMap<String, Node>();

        for(String[] ticket:tickets) {
            String from_str = ticket[0];
            String to_str = ticket[1];

            Node from = nodes.get(from_str);
            if(from == null) {
                from = new Node(from_str);
                nodes.put(from_str, from);
            }

            Node to = nodes.get(to_str);
            if(to == null) {
                to = new Node(to_str);
                nodes.put(to_str, to);
            }

            int idx = 0;
            for(int i = 0; i < from.tos.size(); i++) {
                Node n = from.tos.get(i);
                if(to.name.compareTo(n.name) <= 0) {
                    idx = i;
                    break;
                } else {
                    idx++;
                }
            }
            from.tos.add(idx, to);
        }

        // scan from JFK
        Node curr = nodes.get("JFK");
        ret.add(curr.name);
        while(curr.tos.size() > 0) {
            Node next = curr.tos.get(0);
            curr.tos.remove(0);
            ret.add(next.name);
            curr = next;
        }
        
        return ret;
    }
}
