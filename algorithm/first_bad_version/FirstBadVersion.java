import java.io.*;
import java.util.*;


class FirstBadVersion
{
    public static void main(String[] args) {
        System.out.println("=== First Bad Version ===");

        int n = 2126753390;
        int target = 1702766719;
        Solution solution = new Solution(target);
        
        int ret = solution.firstBadVersion(n);
        
        System.out.println("n = "+n+", target = "+target+", ret = "+ret);
    }
}

class VersionControl
{
    int target = 0;
    public VersionControl(int target) {
        this.target = target;
    }

    public boolean isBadVersion(int version) {
        return (target <= version);
    }
}

class Solution extends VersionControl
{
    public Solution(int target) {
        super(target);
    }
    
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;

        if(right < left) {
            System.out.println("Solution.firstBadVersion() error: right < left!");
            return -1;
        }

        while(left <= right) {
            //System.out.println("left = "+left+", right = "+right);
            if(left == right) {
                return ((int)left);
            } else if(right - left == 1) {
                return isBadVersion((int)left)?((int)left):((int)right);
            } else {
                int middle = (int)((left+right)/2);
                if(isBadVersion(middle)) {
                    right = middle;
                } else {
                    left = middle;
                }
            }
        }
        
        return -1;
    }
}
