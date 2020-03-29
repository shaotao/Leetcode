import java.io.*;
import java.util.*;


class SearchRange
{
    public static void main(String[] args)
    {
	System.out.println("=== SearchRange ===");
	
	Solution solution = new Solution();

	int[] A = {5,7,7,8,8,10};
	int target = 8;

	int[] result = solution.searchRange(A, target);
	

	System.out.println("array = "+array_to_string(A));
	System.out.println("target = "+target);
	System.out.println("result = "+result[0] +", "+result[1]);
    }

    public static String array_to_string(int[] A)
    {
	StringBuffer buf = new StringBuffer("");
	
	for(int i = 0; i < A.length; i++) {
	    buf.append(A[i]+" ");
	}

	return buf.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public int[] searchRange(int[] A, int target)
    {
	int[] error_result = {-1, -1};

	int left = -1;
	int right = -1;

	int start_idx = 0;
	int end_idx = A.length-1;

	int mid_idx = bin_search(A, start_idx, end_idx, target);
	//System.out.println("mid = "+mid_idx);

	if(mid_idx < 0) {
	    return error_result;
	}

	left = mid_idx;
	right = mid_idx;
	
	// search left most
	int mid = mid_idx;
	while(mid >= 0) {
	    left = mid;
	    mid = bin_search(A, start_idx, mid-1, target);
	}


	// search right most
	mid = mid_idx;
	while(mid >= 0) {
	    right = mid;
	    mid = bin_search(A, mid+1, end_idx, target);
	}
	

	int[] result = {left, right};
	return result;
    }


    public int bin_search(int[] A, int start_idx, int end_idx, int target)
    {
	if(start_idx < 0 || start_idx >= A.length ||
	   end_idx < 0 || end_idx >= A.length ||
	   end_idx < start_idx) {
	    return -1;
	}
	
	if(end_idx - start_idx < 2){

	    if(A[start_idx] == target) {
		return start_idx;
	    }
	    else if(A[end_idx] == target) {
		return end_idx;
	    }
	    else {
		return -1;
	    }		
	}
	else {

	    int mid_idx = (end_idx + start_idx)/2;
	    
	    //System.out.println("mid_idx = "+mid_idx);
	    //System.out.println("A[mid_idx] = "+A[mid_idx]);

	    if(A[mid_idx] == target) {
		return mid_idx;
	    }
	    else if(A[mid_idx] < target) {
		return bin_search(A, mid_idx+1, end_idx, target);
	    }
	    else {
		return bin_search(A, start_idx, mid_idx-1, target);
	    }
	}
    }
}
