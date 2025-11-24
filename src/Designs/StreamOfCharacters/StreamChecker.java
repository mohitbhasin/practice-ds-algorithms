class StreamChecker {
    Trie root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new Trie();
        for(String word: words) {
            addWord(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return seachSuffix();
    }

    // Adding word in reverse order.
    public void addWord(String word) {
        Trie curr = root;
        for(int i=word.length()-1; i>=0; i--) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(curr.neighbor[index]==null) {
                curr.neighbor[index]=new Trie();
            }
            curr = curr.neighbor[index];
        }
        curr.isWord=true;
    }

    public boolean seachSuffix() {
        Trie curr = root;
        int i = sb.length()-1;
        while(i>=0) {
            int index = sb.charAt(i) - 'a';
            if(curr.neighbor[index]==null) {
                return false;
            }
            if(curr.neighbor[index].isWord) {
                return true;
            }
            curr = curr.neighbor[index];
            i--;
        }
        return false;
    }
}

class Trie {
    Trie[] neighbor;
    boolean isWord;

    Trie() {
        neighbor = new Trie[26];
        isWord = false;
    }
}