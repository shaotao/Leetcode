import java.io.*;
import java.util.*;


class ImplementQueueUsingStacks
{
    public static void main(String[] args)
    {
        System.out.println("=== Implement Queue using Stacks ===");
        MyQueue queue = new MyQueue();

        for(int i = 0; i < 5; i++) {
            queue.push(i);
            System.out.println("push "+i);
        }

        for(int i = 0; i < 5; i++) {
            System.out.println("peek = "+queue.peek());
            queue.pop();
            System.out.println("empty = "+queue.empty());
        }
    }
}

class MyQueue
{
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();
    
    public void push(int x) {
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            tmp.push(stack.pop());
        }

        tmp.push(x);

        size = tmp.size();
        for(int i = 0; i < size; i++) {
            stack.push(tmp.pop());
        }
    }

    public void pop() {
        stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}
