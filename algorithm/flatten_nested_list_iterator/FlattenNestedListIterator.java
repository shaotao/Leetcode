import java.io.*;
import java.util.*;

class MyNestedInteger implements NestedInteger
{
    List<NestedInteger> list;
    Integer val;

    public MyNestedInteger(Integer val) {
        this.list = null;
        this.val = val;
    }

    public MyNestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }
    
    public boolean isInteger() {
        return (this.val!=null);
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

class FlattenNestedListIterator
{
    public static void main(String[] args)
    {
	System.out.println("=== Flatten Nested List Iterator ===");

        MyNestedInteger n1 = new MyNestedInteger(new Integer(1));
        MyNestedInteger n2 = new MyNestedInteger(new Integer(2));

        ArrayList<NestedInteger> l1 = new ArrayList<NestedInteger>();
        l1.add(n1);
        l1.add(n1);
        MyNestedInteger na = new MyNestedInteger(l1);

        ArrayList<NestedInteger> list = new ArrayList<NestedInteger>();
        list.add(na);
        list.add(n2);
        list.add(na);

        NestedIterator iter = new NestedIterator(list);
        print_iter(iter);

        // another test case
        list = new ArrayList<NestedInteger>();
        MyNestedInteger n4 = new MyNestedInteger(new Integer(4));
        list.add(n4);

        MyNestedInteger n6 = new MyNestedInteger(new Integer(6));
        ArrayList<NestedInteger> l6 = new ArrayList<NestedInteger>();
        l6.add(n6);
        MyNestedInteger f6 = new MyNestedInteger(l6);

        MyNestedInteger n5 = new MyNestedInteger(new Integer(5));
        ArrayList<NestedInteger> l5 = new ArrayList<NestedInteger>();
        l5.add(n5);
        l5.add(f6);

        MyNestedInteger f5 = new MyNestedInteger(l5);
        
        list.add(f5);

        iter = new NestedIterator(list);
        print_iter(iter);
    }

    public static void print_iter(NestedIterator iter) {

        System.out.print("flattened list: ");
        if(iter == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        int idx = 0;
        while(iter.hasNext()) {
            if(idx > 0) { System.out.print(","); }
            System.out.print(iter.next());
            idx++;
        }
        System.out.println("]");
    }
}
