import java.io.*;
import java.util.*;


class Balance
{
    int id = -1;
    int self_weight = 10;
    
    ArrayList<Balance> left_children;
    ArrayList<Balance> right_children;
    
    // before it is balanced
    int left_weight = -1;
    int right_weight = -1;
    
    int total_left_weight = -1;
    int total_right_weight = -1;

    // after it is balanced
    int add_left = -1;
    int add_right = -1;
    int total_weight = -1;

    public Balance(int id)
    {
        this.id = id;
    }

    public void init(int left_weight, int right_weight, ArrayList<Balance> left_children, ArrayList<Balance> right_children)
    {
        this.left_weight = left_weight;
        this.right_weight = right_weight;
        
        this.left_children = new ArrayList<Balance>(left_children);
        this.right_children = new ArrayList<Balance>(right_children);
    }
    
    public int get_total_left_weight()
    {
        total_left_weight = left_weight;
        for(Balance child: left_children) {
            total_left_weight += child.get_total_weight();
        }

        return total_left_weight;
    }
    
    public int get_total_right_weight()
    {
        total_right_weight = right_weight;
        for(Balance child: right_children) {
            total_right_weight += child.get_total_weight();
        }
        
        return total_right_weight;
    }
    
    public int get_total_weight()
    {
        if(total_weight >= 0) { return total_weight; }
        else {
            total_left_weight = get_total_left_weight();
            total_right_weight = get_total_right_weight();
            
            if(total_left_weight > total_right_weight) {
                add_left = 0;
                add_right = total_left_weight - total_right_weight;
                total_weight = 2*total_left_weight + self_weight;
            } else {
                add_left = total_right_weight - total_left_weight;
                add_right = 0;
                total_weight = 2*total_right_weight + self_weight;
            }
        }
        
        return total_weight;
    }
    
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append(id+": "+left_weight+", "+right_weight+" [");
        for(int i = 0; i < left_children.size(); i++)
        {
            buf.append(left_children.get(i).id+" ");
        }
        buf.append("] [");
        for(int i = 0; i < right_children.size(); i++)
        {
            buf.append(right_children.get(i).id+" ");
        }
        buf.append("]");
        
        return buf.toString();
    }
}


class ComputeBalance
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("=== Welcome to ComputeBalance ===");
        
        String input_filename = "input.txt";
        String output_filename = "output.txt";
        
        System.out.println("processing input...");

        ComputeBalance comp_balance = new ComputeBalance();
        comp_balance.compute(input_filename, output_filename);
        
        System.out.println("result done!");
    }

    public int compute(String input_filename, String output_filename) throws IOException
    {
        HashMap<Integer, Balance> map = new HashMap<Integer, Balance>();

        BufferedReader reader = new BufferedReader(new FileReader(input_filename));
        
        String line = reader.readLine();
        int num_balances = Integer.parseInt(line);
        
        System.out.println("num_balances = "+num_balances);

        for(int i = 0; i < num_balances; i++)
        {
            Balance balance = map.get(i);
            if(balance == null)
            {
                balance = new Balance(i);
                map.put(i, balance);
            }
            int left_weight = 0;
            int right_weight = 0;
            ArrayList<Balance> left_children = null;
            ArrayList<Balance> right_children = null;

            for(int j = 0; j < 2; j++)
            {
                StringTokenizer stok = new StringTokenizer(reader.readLine());
                int weight = Integer.parseInt(stok.nextToken());
                ArrayList<Balance> list = new ArrayList<Balance>();

                while(stok.hasMoreTokens())
                {
                    int child_id = Integer.parseInt(stok.nextToken());
                    Balance child = map.get(child_id);
                    if(child == null) 
                    { 
                        child = new Balance(child_id); 
                        map.put(child_id, child);
                    }
                    
                    list.add(child);
                }
                
                if(j%2 == 0)
                {
                    left_weight = weight;
                    left_children = list;
                }
                else
                {
                    right_weight = weight;
                    right_children = list;
                }
            }
            
            balance.init(left_weight, right_weight, left_children, right_children);
        }

        // close the file
        reader.close();

        // debug the balances
        //debug(map);

        PrintWriter writer = new PrintWriter(new FileWriter(output_filename));
        
        for(int i = 0; i < map.size(); i++)
        {
            Balance balance = map.get(i);
            balance.get_total_weight();
            writer.println(balance.id+": "+balance.add_left+" "+balance.add_right);
        }
        writer.close();

        return 0;
    }

    public void debug(HashMap<Integer, Balance> map)
    {
        if(map == null) { return; }
        
        for(int i = 0; i < map.size(); i++)
        {
            Balance balance = map.get(i);
            
            System.out.println(balance);
        }
        
        for(int i = 0; i < map.size(); i++)
        {
            Balance balance = map.get(i);
            balance.get_total_weight();
        }

        for(int i = 0; i < map.size(); i++)
        {
            Balance balance = map.get(i);
            System.out.println(balance.id+": "+balance.add_left+", "+balance.add_right);
        }
    }
}
