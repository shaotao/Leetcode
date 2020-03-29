import java.io.*;
import java.util.*;


class TestMinStack
{
    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
        int[] nums = {5, 2, 4, 1, 3};

        for(int i = 0; i < nums.length; i++)
        {
            stack.push(nums[i]);
        }

        System.out.println("After inserting nums: ");
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]+", ");
        }
        System.out.println();
        System.out.println("top = "+stack.top());
        System.out.println("min = "+stack.getMin());
        
        stack.pop();
        stack.pop();

        System.out.println("after 2 pops:");
        System.out.println("top = "+stack.top());
        System.out.println("min = "+stack.getMin());        
    }
}

