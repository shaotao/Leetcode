import java.io.*;
import java.util.*;


class Anagrams
{
    public static void main(String[] args)
    {
        System.out.println("=== Anagrams ===");

        //String[] strs = {"ape", "pea", "tax"};

	String[] strs = {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};

        Solution solution = new Solution();

        ArrayList<String> result = solution.anagrams(strs);

        System.out.println("input: ");
        for(int i = 0; i < strs.length; i++)
        {
            System.out.print(strs[i]+", ");
        }
        System.out.println();

        System.out.println("output: ");
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i)+",");
        }
        System.out.println();
    }
}

class Solution
{
    public ArrayList<String> anagrams(String[] strs)
    {

        ArrayList<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        // for each string, compute the histogram of chars and hash of
        // histogram
        for(int idx_str = 0; idx_str < strs.length; idx_str++)
        {
            String str = strs[idx_str];
            int[] histogram = new int[26];
            for(int i = 0; i < 26; i++)
            {
                histogram[i] = 0;
            }

            for(int idx_char = 0; idx_char < str.length(); idx_char++)
            {
                int idx_his = (int)str.charAt(idx_char) - ((int)'a');
                histogram[idx_his] += 1;
            }

            // convert the histogram to string.hashCode()
            String pattern = "";
            for(int i = 0; i < histogram.length; i++)
            {
                pattern += histogram[i]+"|";
            }

            //System.out.println("pattern = "+pattern);
            //System.out.println("hash = "+pattern.hashCode());

            ArrayList<String> list = map.get(pattern.hashCode());
	    if(list == null)
	    {
		list = new ArrayList<String>();
		map.put(pattern.hashCode(), list);
	    }

	    list.add(str);

        }

	// now search the hashmap for anagrams
	// any entry with number of strings > 1
	for(ArrayList<String>list : map.values())
	{
	    if(list.size() > 1)
	    {
		result.addAll(list);
	    }
	}


        return result;
    }
}
