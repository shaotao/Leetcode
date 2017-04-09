import java.io.*;
import java.util.*;


class SubstringWithConcatenationOfAllWords
{
    public static void main(String[] args)
    {
        System.out.println("=== Substring with Concatenation of All Words ===");
        Solution solution = new Solution();
        
        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        
        ArrayList<Integer> result = solution.findSubstring(S, L);

        System.out.println("S = \""+S+"\"");
        System.out.print("L = ");
        for(int i = 0; i < L.length; i++)
        {
            System.out.print(L[i]+" ");
        }
        System.out.println();
        System.out.print("result: ");
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
}


class Solution
{
    public ArrayList<Integer> findSubstring(String S, String[] L)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(S.length() <= 0 || L.length <= 0) { return result; }
        
        // get the sum of the length of all words in L
        int target_length = L.length * L[0].length();
        
        if(S.length() < target_length) { return result; }
        
        // load L into a word_map
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++)
        {
            if(map.containsKey(L[i]))
            {
                int val = map.get(L[i]);
                map.put(L[i], val+1);
            }
            else
            {
                map.put(L[i], 1);
            }
        }

        // try each possible starting position
        for(int i = 0; i <= S.length() - target_length; i++)
        {
            boolean miss = false;

            // scan the string segment for words
            // create a temp_map and compare to map
            HashMap<String, Integer> temp_map = new HashMap<String, Integer>();

            // scan the words
            for(int j = i; j <= i+(L.length-1)*L[0].length(); j+= L[0].length())
            {
                // word is S.substring(j, j+L[0].length)
                String word = S.substring(j, j+L[0].length());

                if(!map.containsKey(word)) 
                {
                    miss = true;
                    break; 
                }

                if(temp_map.containsKey(word))
                {
                    int val = temp_map.get(word);
                    temp_map.put(word, val+1);
                }
                else
                {
                    temp_map.put(word, 1);
                }
            }
            
            if(miss == true) { continue; }
            
            // ok, all words in temp_map are found in map
            // now we compare temp_map and map
            // if equal, insert i to result or else do nothing
            if(temp_map.size() != map.size()) { continue; }
            
            // search word by word
            miss = false;
            Iterator<String> iter = temp_map.keySet().iterator();
            while(iter.hasNext())
            {
                String word = iter.next();
                
                if( !map.containsKey(word) ||
                    map.get(word) != temp_map.get(word))
                {
                    miss = true;
                    break;
                }
            }

            if(miss == false) { result.add(i); }
        }

        return result;
    }
}
