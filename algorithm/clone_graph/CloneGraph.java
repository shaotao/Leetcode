import java.io.*;
import java.util.*;


class UndirectedGraphNode
{
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}


class CloneGraph
{
    public static void main(String[] args)
    {
        System.out.println("=== CloneGraph ===");
        Solution solution = new Solution();
            
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);

        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        
        n2.neighbors.add(n0);
        n2.neighbors.add(n1);
        n2.neighbors.add(n2);
        
        UndirectedGraphNode result = solution.cloneGraph(n0);
        
        print_graph(n0);
        print_graph(result);
    }
    
    public static void print_graph(UndirectedGraphNode node)
    {
        if(node == null)
        {
            System.out.println("node is null!");
            return;
        }

        // get the node list, and print the neighbor list
        ArrayList<UndirectedGraphNode> node_list = new ArrayList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> check_list = new ArrayList<UndirectedGraphNode>();
        
        check_list.add(node);
        
        // scan the checklist for new nodes
        while(check_list.size() > 0)
        {
            // get the head node of check_list and insert to node_list
            UndirectedGraphNode head = check_list.get(0);
            check_list.remove(0);
            
            node_list.add(head);
            
            // now we scan the neighbors of node, if the neighbor
            // is not in node_list, add the neighbor to check_list
            for(int idx_nbr = 0; idx_nbr < head.neighbors.size(); idx_nbr++)
            {
                UndirectedGraphNode nbr = head.neighbors.get(idx_nbr);
                
                boolean found = false;
                for(int i = 0; i < node_list.size(); i++)
                {
                    if(node_list.get(i).label == nbr.label)
                    {
                        found = true;
                        break;
                    }
                }

                for(int i = 0; i < check_list.size(); i++)
                {
                    if(check_list.get(i).label == nbr.label)
                    {
                        found = true;
                        break;
                    }
                }
                
                if(found == false)
                {
                    check_list.add(nbr);
                }
            }
        }

        // now we have node_list
        System.out.println("print graph of "+node_list.size()+" nodes: ");
        for(int i = 0; i < node_list.size(); i++)
        {
            System.out.print("node = "+node_list.get(i).label+": ");
            for(int j = 0; j < node_list.get(i).neighbors.size(); j++)
            {
                System.out.print(node_list.get(i).neighbors.get(j).label+" ");
            }
            System.out.println();
        }
    }
}

class Solution
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if(node == null)
        {
            return null;
        }
        
        ArrayList<UndirectedGraphNode> node_list = new ArrayList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> check_list = new ArrayList<UndirectedGraphNode>();
        
        check_list.add(node);
        
        // scan the checklist for new nodes
        while(check_list.size() > 0)
        {
            // get the head node of check_list and insert to node_list
            UndirectedGraphNode head = check_list.get(0);
            check_list.remove(0);
            
            node_list.add(head);
            
            // now we scan the neighbors of node, if the neighbor
            // is not in node_list, add the neighbor to check_list
            for(int idx_nbr = 0; idx_nbr < head.neighbors.size(); idx_nbr++)
            {
                UndirectedGraphNode nbr = head.neighbors.get(idx_nbr);
                
                boolean found = false;
                for(int i = 0; i < node_list.size(); i++)
                {
                    if(node_list.get(i).label == nbr.label)
                    {
                        found = true;
                        break;
                    }
                }
                
                for(int i = 0; i < check_list.size(); i++)
                {
                    if(check_list.get(i).label == nbr.label)
                    {
                        found = true;
                        break;
                    }
                }
                
                if(found == false)
                {
                    check_list.add(nbr);
                }
            }
        }
        
        // ok, now the node_list has all nodes
        // we duplcate the node_list
        ArrayList<UndirectedGraphNode> new_node_list = new ArrayList<UndirectedGraphNode>();
        
        for(int i = 0; i < node_list.size(); i++)
        {
            UndirectedGraphNode new_node = new UndirectedGraphNode(node_list.get(i).label);
            
            new_node_list.add(new_node);
        }
        
        // we have all the nodes, we populate the neighbor list
        for(int i = 0; i < node_list.size(); i++)
        {
            UndirectedGraphNode one_node = node_list.get(i);
            
            // get its neighbors
            for(int idx_nbr = 0; idx_nbr < one_node.neighbors.size(); idx_nbr++)
            {
                UndirectedGraphNode nbr = one_node.neighbors.get(idx_nbr);
                UndirectedGraphNode target = null;

                // try to find the neighbor in new_node_list
                for(int j = 0; j < new_node_list.size(); j++)
                {
                    if(new_node_list.get(j).label == nbr.label)
                    {
                        target = new_node_list.get(j);
                        break;
                    }
                }
                
                if(target != null)
                {
                    new_node_list.get(i).neighbors.add(target);
                }
            }
        }
        

        if(new_node_list.size() > 0)
        {
            return new_node_list.get(0);
        }
        else
        {
            return null;
        }
    }
}
