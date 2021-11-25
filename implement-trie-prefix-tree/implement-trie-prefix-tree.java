class Trie {
    
    private class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    private Node root = null;
    
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a'] == null){
                Node nn = new Node();
                ptr.children[ch-'a'] = nn;
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node ptr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ptr.children[ch - 'a'] == null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
        }
        return ptr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node ptr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(ptr.children[ch-'a'] == null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */