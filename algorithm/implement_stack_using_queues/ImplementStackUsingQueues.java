import java.io.*;
import java.util.*;


class ImplementStackUsingQueues
{
    public static void main(String[] args)
    {
        System.out.println("=== Implement Stack Using Queues ===");
        MyStack stack = new MyStack();

        for(int i = 0; i < 5; i++) {
            System.out.println("push "+i);
            stack.push(i);
        }

        for(int i = 0; i < 5; i++) {
            Integer top = stack.top();
            stack.pop();
            boolean empty = stack.empty();

            System.out.println("top = "+top+", empty = "+empty);
        }
    }
}

class MyStack
{
    LinkedList<Integer> list = new LinkedList<Integer>();
    LinkedList<Integer> tmp = new LinkedList<Integer>();
    
    public void push(int x) {
        tmp.add(x);
        int size = list.size();
        for(int i = 0; i < size; i++) {
            tmp.add(list.remove());
        }

        size = tmp.size();
        for(int i = 0; i < size; i++) {
            list.add(tmp.remove());
        }
    }

    public void pop() {
        list.remove();
    }

    public int top() {
        return list.peek();
    }

    public boolean empty() {
        return (list.size() == 0);
    }
}
