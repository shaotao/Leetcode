import java.io.*;
import java.util.*;


class RangeSumQueryMutable
{
    public static void main(String[] args)
    {
        System.out.println("=== Range Sum Query - Mutable ===");
        int[] nums = {1, 3, 5};
        NumArray narray = new NumArray(nums);

        System.out.println("sumRange(0, 2) = "+narray.sumRange(0, 2));
        System.out.println("update(1, 2) = ");
        narray.update(1, 2);
        System.out.println("sumRange(0, 2) = "+narray.sumRange(0, 2));
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

    public void update(int i, int val)
    {
        int origin_num = vals[i];
        if(i > 0) { origin_num = vals[i] - vals[i-1]; }
        for(int idx = i; idx < size; idx++) {
            vals[idx] += (val - origin_num);
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
