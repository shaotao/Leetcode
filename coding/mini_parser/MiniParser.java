import java.io.*;
import java.util.*;


class MiniParser
{
    public static void main(String[] args)
    {
	System.out.println("=== Mini Parser ===");
	Solution solution = new Solution();

        String[] inputs = {"324", "[123,[456,[789]]]"};

        for(String s:inputs) {
            NestedInteger ni = solution.deserialize(s);
            System.out.println("s = \""+s+"\", NestedInteger = "+ni);
        }
    }
}

class NestedInteger {
    Integer val;
    List<NestedInteger> list;
    
    public NestedInteger() {
        val = null;
        list = new ArrayList<NestedInteger>();
    }

    public NestedInteger(int value) {
        val = value;
        list = null;
    }

    public boolean isInteger() { return (val!=null); }
    public Integer getInteger() { return val; }
    public List<NestedInteger> getList() { return list; }

    public void setInteger(int value) { val = value; }
    public void add(NestedInteger ni) {
        if(list == null) { list = new ArrayList<NestedInteger>(); }
        list.add(ni);
    }
}

class Solution
{
    public NestedInteger deserialize(String s) {
        NestedInteger ret = null;

        // state: start, int, ls, le;
        String state = null;

        
        
        return ret;
    }
}
