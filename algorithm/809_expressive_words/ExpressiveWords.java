import java.io.*;
import java.util.*;


class ExpressiveWords
{
    public static void main(String[] args)
    {
        System.out.println("=== Expressive Words ===");
        Solution solution = new Solution();
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        
        System.out.println("S = "+S);
        System.out.println("words = "+Arrays.toString(words));
        System.out.println("# of expressive words = "+solution.expressiveWords(S, words));
    }
}


class Solution
{
    class Pair {
        char ch;
        int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public void addCount() { this.count++; }
        public char getCh() { return this.ch; }
        public int getCount() { return this.count; }
    }
    
    public int expressiveWords(String S, String[] words) {
        List<Pair> sList = toPairList(S);
        int count = (int) Arrays.asList(words).stream().filter(word -> canExpand(sList, word)).count();
        return count;
    }

    private List<Pair> toPairList(String str) {
        List<Pair> list = new ArrayList<>();
        Pair pair = null;
        for (char ch : str.toCharArray()) {
            if (pair != null && pair.getCh() == ch) {
                pair.addCount();
            } else {
                pair = new Pair(ch, 1);
                list.add(pair);
            }
        }
        return list;
    }

    private boolean canExpand(List<Pair> sList, String word) {
        if ( (sList.size() == 0 && word.length() > 0) || (sList.size() > 0 && word.length() == 0)) {
            return false;
        }

        if (sList.size() == 0 && word.length() == 0) { return true; }
        List<Pair> wordList = toPairList(word);

        if (wordList.size() != sList.size()) { return false; }
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            Pair wordPair = wordList.get(i);
            Pair sPair = sList.get(i);
            if ( wordPair.getCount() > sPair.getCount() ||
                 (wordPair.getCount() < sPair.getCount() &&
                  sPair.getCount() < 3)) {
                return false;
            }
        }
        
        return true;
    }
}
