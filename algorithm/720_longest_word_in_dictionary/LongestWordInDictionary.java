import java.io.*;
import java.util.*;


class LongestWordInDictionary
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Word in Dictionary ===");
        Solution solution = new Solution();
        String[][] input = {{"w","wo","wor","worl", "world"},
                            {"a", "banana", "app", "appl", "ap", "apply", "apple"}};    
        for (String[] words : input) {
            System.out.println("words = "+Arrays.toString(words));
            System.out.println("longest word = "+solution.longestWord(words));
        }
    }
}

class Node {
    String ch;
    Map<String, Node> children;
    boolean isWord;

    public Node(String ch) {
        this.ch = ch;
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public boolean isWord() {
        return isWord;
    }

    public String getCh() {
        return ch;
    }

    public Node getChild(String label) {
        Node child = children.get(label);
        if (child == null) {
            child = new Node(label);
            this.children.put(label, child);
        }
        return child;
    }

    public void addWord(String word) {
        if (word.length() == 0) {
            this.isWord = true;
        } else {
            String label = word.substring(0, 1);
            Node child = getChild(label);
            child.addWord(word.substring(1));
        }
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(ch+":"+isWord+") "+children.keySet());
        
        return buf.toString();
    }

    public void trace() {
        System.out.println(ch+":"+isWord+")"+children.keySet());
        for (String key : children.keySet()) {
            Node child = children.get(key);
            child.trace();
        }
    }

    public void longest(List<String> longestWords, String word, int depth) {
        if (isWord) {
            if (longestWords.isEmpty() || depth == longestWords.get(0).length()
) {
                longestWords.add(word);
            } else if (depth > longestWords.get(0).length()) {
                longestWords.clear();
                longestWords.add(word);
            }
        }
        for (String key : children.keySet()) {
            Node child = children.get(key);
            if (child.isWord()) {
                child.longest(longestWords, word+child.getCh(), depth+1);
            }
        }
    }
}

class Solution
{
    public String longestWord(String[] words) {
        String ret = null;
        //System.out.println("words = "+Arrays.toString(words));

        Node root = new Node("");
        for (String word : words) {
            root.addWord(word);
        }

        List<String> longestWords = new ArrayList<>();
        root.longest(longestWords, "", 0);
        //System.out.println("longest words = "+longestWords);

        Collections.sort(longestWords);
        
        return longestWords.get(0);
    }
}
