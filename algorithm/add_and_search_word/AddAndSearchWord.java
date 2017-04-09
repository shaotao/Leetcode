import java.io.*;
import java.util.*;


class AddAndSearchWord
{
    public static void main(String[] args)
    {
        System.out.println("=== Add and Search Word ===");
        WordDictionary dict = new WordDictionary();
        /*
        String[] words = {"bad", "dad", "mad"};
        String[] lookups = {"pad", "bad", ".ad", "b..", ".", "..", "...", "...."};
        
        for(String word: words) {
            System.out.println("add "+word);
            dict.addWord(word);
        }

        for(String lookup: lookups) {
            System.out.print("search "+lookup+": "+dict.search(lookup)+"\n");
        }
        */

        
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");
        System.out.println(dict.search("a"));
        System.out.println(dict.search("at"));
        dict.addWord("bat");
        System.out.println(dict.search(".at"));
        System.out.println(dict.search("an."));
        System.out.println(dict.search("a.d."));
        System.out.println(dict.search("b."));
        System.out.println(dict.search("."));
    }
}

class TrieNode
{
    char ch;
    boolean isWord = false;
    HashMap<Character, TrieNode> map;

    public TrieNode(char ch) {
        this.ch = ch;
        map = new HashMap<Character, TrieNode>();
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public void addWord(String word) {
        if(word == null || word.length() == 0) {
            return;
        }

        char target_ch = word.charAt(0);
        TrieNode node = map.get(target_ch);
        if(node == null) {
            node = new TrieNode(target_ch);
            map.put(target_ch, node);
        }

        if(word.length() == 1) {
            node.setWord();
        } else {
            node.addWord(word.substring(1));
        }
    }

    public boolean search(String word) {

        if(word == null || word.length() == 0) { return false; }

        char target_ch = word.charAt(0);
        if(target_ch != '.') {
            TrieNode node = map.get(target_ch);
            if(node == null) { return false; }
            if(word.length() == 1) {
                return node.isWord();
            } else {
                return node.search(word.substring(1));
            }
        } else {

            String rest = word.substring(1);
            for(Character ch: map.keySet()) {
                TrieNode node = map.get(ch);
                if(word.length() == 1) {
                    return node.isWord();
                } else {
                    boolean ret = node.search(rest);
                    if(ret) { return true; }
                }
            }

            return false;
        }
    }
}

class WordDictionary
{
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        root.addWord(word);        
    }

    public boolean search(String word) {
        return root.search(word);
    }
}
