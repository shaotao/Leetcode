import java.io.*;
import java.util.*;


class PeekingIterator implements Iterator<Integer>
{
    ArrayList<Integer> list = null;
    int idx = 0;
    
    public static void main(String[] args)
    {
        System.out.println("=== Peeking Iterator ===");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        PeekingIterator pi = new PeekingIterator(list.iterator());

        while(pi.hasNext()) {
            System.out.println("hasNext = "+pi.hasNext()+", peek = "+pi.peek()+", next = "+pi.next());
        }
    }

    public PeekingIterator(Iterator<Integer> iterator) {
        list = new ArrayList<Integer>();

        while(iterator != null && iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    public Integer peek() {
        return (idx >= list.size())?null:(list.get(idx));
    }

    @Override
    public Integer next() {
        Integer ret = list.get(idx);
        idx++;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (idx < list.size());
    }
}

