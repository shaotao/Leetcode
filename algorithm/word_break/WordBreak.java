import java.io.*;
import java.util.*;


class WordBreak
{
    public static void main(String[] args)
    {
	System.out.println("=== Word Break ===");
	Solution solution = new Solution();
	
	String s = "bccdbacdbdacddabbaaaadababadad";
	
	String[] words = {"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"};
	HashSet<String> dict = new HashSet<String>();
	
	for(int i = 0; i < words.length; i++) { dict.add(words[i]); }
	
	boolean result = solution.wordBreak(s, dict);

	System.out.println("s = "+s);
	System.out.print("words: ");
	for(int i = 0; i < words.length; i++)
	{
	    System.out.print(words[i]+" ");
	}
	System.out.println();

	System.out.println("result: "+result);
    }
}


class Solution
{
    public boolean wordBreak(String s, Set<String> dict)
    {
	ArrayList<String> result = new ArrayList<String>();

	// filter the characters, if any char in s can't be found in words
	// within dict, return empty result
	HashSet<Character> set = new HashSet<Character>();
	Iterator<String> iter = dict.iterator();
	while(iter.hasNext())
	{
	    String word = iter.next();
	    for(int i = 0; i < word.length(); i++)
	    {
		char ch = word.charAt(i);
		if(!set.contains(ch)) { set.add(ch); }		
	    }
	}
	
	for(int i = 0; i < s.length(); i++)
	{
	    char ch = s.charAt(i);
	    if(!set.contains(ch))
	    {
		return false;
	    }
	}

	StringBuffer temp = new StringBuffer();
	StringBuffer s_buf = new StringBuffer(s);			
	result = find_words(result, temp, s_buf, (HashSet<String>) dict);
	
	return result.size()> 0 ? true : false;
    }

    public ArrayList<String> find_words(ArrayList<String> result, StringBuffer temp, StringBuffer s, HashSet<String> dict)
    {
	if(s.length() == 0)
	{
	    result.add(temp.toString());
	    return result;
	}

	// search words in dict that appear in the front of s
	Iterator<String> iter = dict.iterator();
	
	while(iter.hasNext())
	{
	    String word = iter.next();
	    
	    if(!s.toString().startsWith(word)) { continue; }
	    
	    // ok, s starts with word, try to add word to temp
	    String extra = temp.length() == 0 ? word:" "+word;
	    temp.append(extra);
	    find_words(result, temp, s.delete(0, word.length()), dict);
	    if(result.size() > 0) { return result; }
	    
	    temp.delete(temp.length()-extra.length(), temp.length());
	    s.insert(0, word);
	}
	
	return result;
    }
}
