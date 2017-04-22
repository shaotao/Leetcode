import java.io.*;
import java.util.*;


class TwoSumII
{
    public static void main(String[] args)
    {
	System.out.println("=== Two Sum II - Input array is sorted ===");
	Solution solution = new Solution();
        int[] numbers = {2,7,11,5};
        int target = 9;

        System.out.println("numbers = "+Arrays.toString(numbers));
        System.out.println("target = "+target);
        System.out.println("index = "+Arrays.toString(solution.twoSum(numbers, target)));
    }
}


class Solution
{
    // use binary search to find the pair
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int idx_y = findPairIdx(target-x, numbers, i+1, numbers.length-1);

            if(idx_y > i) {
                indexes[0] = i+1;
                indexes[1] = idx_y+1;
                break;
            }
        }

        return indexes;
    }

    // return the index of the target number in a sorted array range
    private int findPairIdx(int pair, int[] numbers, int left, int right) {
        int ret = -1;
        if(numbers == null || left < 0 || left >= numbers.length ||
           right < 0 || right >= numbers.length || left > right) {
            return -1;
        }

        if(right - left <= 1) {
            if(pair == numbers[left]) { ret = left; }
            else if(pair == numbers[right]) { ret = right; }
            else { ret = -1; }
        } else {
            int middle = (left+right)/2;
            if(pair == numbers[middle]) { ret = middle; }
            else if(pair < numbers[middle]) {
                ret = findPairIdx(pair, numbers, left, middle);
            } else if(pair > numbers[middle]) {
                ret = findPairIdx(pair, numbers, middle, right);
            }
        }

        return ret;
    }

    // use a hashmap to check for sum
    public int[] twoSum2(int[] numbers, int target) {
        int[] indexes = new int[2];

        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 1; i <= numbers.length; i++) {
            int num = numbers[i-1];
            ArrayList<Integer> list = map.get(num);
            if(list == null) {
                list = new ArrayList<Integer>();
                map.put(num, list);
            }
            list.add(i);
        }

        boolean found = false;
        for(int x : map.keySet()) {
            if(found) { break; }
            int y = target -x;
            if(!map.containsKey(y)) { continue; }

            List<Integer> xlist = map.get(x);
            List<Integer> ylist = map.get(y);
            
            for(int idx1 : xlist) {
                if(found) { break; }
                for(int idx2 : ylist) {
                    if(idx1 < idx2) {
                        found = true;
                        indexes[0] = idx1;
                        indexes[1] = idx2;
                        break;
                    }
                }
            }
        }
        
        return indexes;
    }
}
