import java.io.*;
import java.util.*;


class TrieNode
{
    HashMap<Character, TrieNode> map;
    boolean isWord = false;
    
    public TrieNode()
    {
        map = new HashMap<Character, TrieNode>();
    }

    public void insert(String word)
    {
        if(word == null) { return; }
        else if(word.length() == 0) {
            isWord = true;
            return;
        }

        char ch = word.charAt(0);

        TrieNode child = map.get(ch);
        if(child == null) {
            child = new TrieNode();
            map.put(ch, child);
        }

        child.insert(word.substring(1));
    }

    public boolean search(String word)
    {
        if(word == null) { return false; }
        else if(word.length() == 0) {            
            return isWord;
        }

        char ch = word.charAt(0);

        TrieNode child = map.get(ch);
        if(child == null) { return false; }

        return child.search(word.substring(1));
    }

    public boolean startsWith(String prefix)
    {
        if(prefix == null) { return false; }
        else if(prefix.length() == 0) {            
            return true;
        }

        char ch = prefix.charAt(0);

        TrieNode child = map.get(ch);
        if(child == null) { return false; }

        return child.startsWith(prefix.substring(1));        
    }
}

class Trie
{
    private TrieNode root;

    public Trie() { root = new TrieNode(); }

    public void insert(String word)
    {
        root.insert(word);
    }

    public boolean search(String word)
    {
        return root.search(word);
    }

    public boolean startsWith(String prefix)
    {
        return root.startsWith(prefix);
    }
}

class ImplementTrie
{
    public static void main(String[] args)
    {
        System.out.println("=== Implement Trie ===");
        Trie trie = new Trie();
        String[] words = {"abc", "bcd", "efg", "xyz"};
        String[] search = {"xyz", "cdf", "ef"};
        
        for(String word: words)
        {
            System.out.println("insert "+word);
            trie.insert(word);
        }

        for(String word: search)
        {
            System.out.println("start with "+word+": "+trie.startsWith(word));
            System.out.println("search "+word+": "+trie.search(word));
        }
    }
}

