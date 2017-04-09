import java.io.*;
import java.util.*;


class RangeSumQueryImmutable
{
    public static void main(String[] args)
    {
        System.out.println("=== Range Sum Query - Immutable ===");
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray narray = new NumArray(nums);

        System.out.println("sumRange(0, 2) = "+narray.sumRange(0, 2));
        System.out.println("sumRange(2, 5) = "+narray.sumRange(2, 5));
        System.out.println("sumRange(0, 5) = "+narray.sumRange(0, 5));
    }
}

class NumArray
{
    int[] vals;
    int size = 0;
    public NumArray(int[] nums)
    {
        size = nums.length;
        if(size > 0) {
            vals = new int[size];
            int sum = 0;
            for(int i = 0; i < size; i++) {
                sum += nums[i];
                vals[i] = sum;
            }
        }
    }

    public int sumRange(int i, int j)
    {
        if(size == 0 || i < 0 || j < 0 || i >= size || j >= size || i > j) {
            return 0;
        }

        int left = (i == 0)?0:vals[i-1];
        int right = vals[j];

        return (right - left);
    }
}
