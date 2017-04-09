import java.io.*;
import java.util.*;

class Element
{
    int x;
    int min;
    Element next;
    
    public Element(int x, int min)
    {
        this.x = x;
        this.min = min;
        next = null;
    }
    
    public int get_x()
    {
        return this.x;
    }
    
    public int get_min()
    {
        return this.min;
    }

    public String toString()
    {
        return "("+x+", "+min+")";
    }
}

public class MinStack
{
    Element top;

    public MinStack()
    {
        top = null;
    }

    public void push(int x)
    {
        int stack_min = (top != null)?top.get_min():x;
        int min = (x < stack_min)?x:stack_min;

        Element new_top = new Element(x, min);
        new_top.next = top;
        top = new_top;
    }
    
    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.get_x();
    }

    public int getMin() {
        return top.get_min();
    }
}
