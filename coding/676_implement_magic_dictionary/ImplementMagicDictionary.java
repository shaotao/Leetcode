import java.io.*;
import java.util.*;


class ImplementMagicDictionary
{
    public static void main(String[] args)
    {
        System.out.println("=== Implement Magic Dictionary ===");
        MagicDictionary dict = new MagicDictionary();
        String[] words = {"hello", "hallo", "leetcode"};
        dict.buildDict(words);

        //String[] input = {"hello", "hhllo", "hell", "leetcoded"};
        String[] input = {"hello"};
        for (String word : input) {
            System.out.println("search "+word+": "+dict.search(word));
        }
    }
}


class Item {
    char ch;
    // true if there is a word that ends here
    boolean end;
    Map<Character, Item> branches;

    public Item(char ch) {
        this.ch = ch;
        branches = new HashMap<Character, Item>();
    }

    public void print() {
        System.out.println("["+this+"]"+ch+(end?"*":"")+":"+branches);
        for(Character key : branches.keySet()) {
            Item i = branches.get(key);
            i.print();
        }
    }

    public void markEnd() {
        this.end = true;
    }

    // insert word to one of the branches
    public void insertWord(int idx, String word) {
        if(word == null || idx >= word.length()) {
            return;
        }
        
        char ch = word.charAt(idx);
        Item tmp = branches.get(ch);
        if (tmp == null) {
            tmp = new Item(ch);
            branches.put(ch, tmp);
        }
        
        if (idx == word.length()-1) {
            tmp.markEnd();
        } else {
            tmp.insertWord(idx+1, word);
        }
    }

    // search the word in item
    public boolean search(String word, int idx, boolean modified) {
        if(word == null || idx >= word.length()) {
            return false;
        }

        boolean found = false;
        char ch = word.charAt(idx);
        Item tmp = branches.get(ch);
        if (tmp != null) {
            System.out.println("1. idx="+idx);
            if (idx == word.length()-1) {
                return (modified && tmp.end);
            } else {
                for (Character key : branches.keySet()) {
                    Item item = branches.get(key);
                    if (item.search(word, idx+1, modified)) {
                        found = true;
                        break;
                    }
                }
            }
        } else if (modified == false) {
            System.out.println("2. idx="+idx);
            for (Character key : branches.keySet()) {
                Item item = branches.get(key);
                if (item.search(word, idx+1, true)) {
                    found = true;
                    break;
                }
            }
        } else {
            System.out.println("3. idx="+idx);
            found = false;
        }

        return found;
    }
}


class MagicDictionary
{
    Item root;
    public MagicDictionary() {
        this.root = new Item('\0');
    }

    public void buildDict(String[] dict) {
        for (String word : dict) {
            root.insertWord(0, word);
        }
        root.print();
    }

    public boolean search(String word) {
        return root.search(word, 0, false);
    }
}

