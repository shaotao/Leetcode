import java.io.*;
import java.util.*;


public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack = null;
    Iterator<NestedInteger> iter = null;

    ArrayList<Integer> list = null;
    int idx = 0;

    // convert the nested list to a flat list
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        
        Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
        Iterator<NestedInteger> iter = nestedList.iterator();
        NestedInteger n = null;
        if(iter.hasNext()) { n = iter.next(); }
        else { return; }

        while(n != null) {
            if(n.isInteger()) {
                list.add(n.getInteger());
            } else {
                stack.push(iter);
                iter = n.getList().iterator();
            }

            // move n to the next item
            if(iter.hasNext()) {
                n = iter.next();
            } else {
                n = null;
                while(stack.size() > 0) {
                    iter = stack.pop();
                    if(iter.hasNext()) {
                        n = iter.next();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Integer next() {
        Integer ret = null;
        if(idx >= 0 && idx < list.size()) {
            ret = list.get(idx);
            idx++;
        }

        return ret;
    }

    @Override
    public boolean hasNext() {
        return (idx >= 0 && idx < list.size());
    }
}
