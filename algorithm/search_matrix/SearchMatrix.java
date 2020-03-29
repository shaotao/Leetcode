import java.io.*;
import java.util.*;


class SearchMatrix
{
    public static void main(String[] args)
    {
	System.out.println("=== Search 2D Matrix ===");

	Solution solution = new Solution();
	
	int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
	int target = 3;

	boolean result = solution.searchMatrix(matrix, target);

	System.out.println("matrix = ");
	System.out.println(matrix_to_string(matrix));

	System.out.println("target = "+target);

	System.out.println("result = "+result);
    }

    public static String matrix_to_string(int[][] matrix)
    {
	StringBuffer buf = new StringBuffer("");

	if(matrix.length == 0) {
	    return buf.toString();
	}

	for(int i = 0; i < matrix.length; i++) {

	    for(int j = 0; j < matrix[0].length; j++) {
		
		buf.append(matrix[i][j]+" ");

	    }
	    
	    buf.append("\n");
	}
	
	return buf.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
	// find the target row
	int target_row_idx = -1;
	for(int i = 0; i < matrix.length; i++) {
	    if(matrix[i][0] <= target && 
	       (i == matrix.length-1 || matrix[i+1][0] > target)) {

		target_row_idx = i;
		break;
	    }
	}

	if(target_row_idx < 0) {
	    return false;
	}

	// ok, target row found, use binary search in the row
	if(binary_search(matrix[target_row_idx], 0, matrix[0].length-1, target) >= 0) {
	    return true;
	}

	return false;
    }

    public int binary_search(int[] array, int start_idx, int end_idx, int target)
    {
	if(start_idx < 0 || start_idx >= array.length ||
	   end_idx < 0 || end_idx >= array.length ||
	   end_idx < start_idx) {
	    return -1;
	}

	if(end_idx - start_idx < 2) {
	    if(array[start_idx] == target) {
		return start_idx;
	    }
	    else if(array[end_idx] == target) {
		return end_idx;
	    }
	    else {
		return -1;
	    }
	}
	
	if(target < array[start_idx] ||
	   target > array[end_idx]) {
	    return -1;
	}

	if(target == array[start_idx]) {
	    return start_idx;
	}

	if(target == array[end_idx]) {
	    return end_idx;
	}

	int mid_idx = (start_idx + end_idx)/2;

	if(array[mid_idx] == target) {
	    return mid_idx;
	}
	else if(array[mid_idx] > target) {
	    return binary_search(array, start_idx, mid_idx-1, target);
	}
	else {
	    return binary_search(array, mid_idx+1, end_idx, target);
	}
    }
}
