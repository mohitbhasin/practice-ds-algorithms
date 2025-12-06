import java.util.*;

public class LongestCommonSuffixQueries {
    static Trie root;
    public static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        root = new Trie();
        int[] ans = new int[wordsQuery.length];
        addWords(wordsContainer);
        for(int i=0; i<wordsQuery.length; i++) {
            ans[i]=findLongestSuffixWord(wordsQuery[i], wordsContainer);
        }
        return ans;
    }
    
    // Add words in reverse order
    public static void addWords(String[] wordsContainer) {
        for(int wordIndex = 0; wordIndex<wordsContainer.length; wordIndex++) {
            Trie curr = root;
            if(curr.minWordIndex==Integer.MAX_VALUE || wordsContainer[curr.minWordIndex].length()>wordsContainer[wordIndex].length()) {
                curr.minWordIndex=wordIndex;
            }
            String word = wordsContainer[wordIndex];
            for(int i=word.length()-1; i>=0; i--) {
                int index = word.charAt(i)-'a';
                if(curr.children[index]==null) {
                    curr.children[index] = new Trie();
                }
                curr = curr.children[index];
                int minIndex = curr.minWordIndex;
                if(minIndex==Integer.MAX_VALUE || wordsContainer[minIndex].length()>word.length()) {
                    curr.minWordIndex = wordIndex;
                }
            }
            curr.isWord=true;
        }
    }
    
    public static int findLongestSuffixWord(String word, String[] wordsContainer) {
        Trie curr = root;
        for(int i=word.length()-1; i>=0; i--) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index]==null) {
                break;
            }
            curr=curr.children[index];
        }
        if(curr.minWordIndex==Integer.MAX_VALUE) {
            return -1;
        } else {
            return curr.minWordIndex;
        }
    }
}

class Trie {
    boolean isWord;
    Trie[] children;
    int minWordIndex;
    public Trie() {
        isWord = false;
        children = new Trie[26];
        minWordIndex = Integer.MAX_VALUE;
    }
}