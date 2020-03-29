import java.io.*;
import java.util.*;


public class MapSumPairs
{
    public static void main(String[] args)
    {
        System.out.println("=== Map Sum Pairs ===");
        MapSum mapsum = new MapSum();

        mapsum.insert("apple", 3);
        System.out.println("sum(ap) = "+mapsum.sum("ap"));
        System.out.println("sum(apple) = "+mapsum.sum("apple"));
        mapsum.insert("app", 2);
        System.out.println("sum(ap) = "+mapsum.sum("ap"));
    }
}


class MapSum
{
    private class Node {
        char ch;
        int count;
        Node parent;
        boolean isWord;
        Map<Character, Node> map;
        public Node(Node parent, char ch) {
            this.parent = parent;
            this.ch = ch;
            this.count = 0;
            this.isWord = false;
            this.map = new HashMap<>();
        }

        public void increaseCount(int val) {
            //System.out.println("node = "+this+", char = "+ch+", increase by "+val);
            this.count += val;
            if (parent != null) {
                parent.increaseCount(val);
            }
        }

        public void add(String key, int count) {
            if (key == null || key.length() == 0) {
                if (isWord) {
                    increaseCount(count - this.count);
                    this.count = count;
                } else {
                    increaseCount(count);
                }

                this.isWord = true;
                return;
            }

            char nextChar = key.charAt(0);
            Node child = map.get(nextChar);
            if(child == null) {
                child = new Node(this, nextChar);
                map.put(nextChar, child);
            }
            child.add(key.substring(1), count);
            
        }

        public int get(String key) {
            if (key == null || key.length() == 0) {
                return this.count;
            }

            char nextChar = key.charAt(0);
            Node child = map.get(nextChar);
            if (child == null) { return 0; }
            return child.get(key.substring(1));
        }
    }

    Node root = null;
    public MapSum() {
        root = new Node(null, '\0');
    }

    public void insert(String key, int val) {
        root.add(key, val);
    }

    public int sum(String prefix) {
        return root.get(prefix);
    }
}
