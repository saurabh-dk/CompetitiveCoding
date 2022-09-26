class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(String s : dictionary) {
            insert(s);
        }
        
        StringBuilder res = new StringBuilder();
        
        String[] all = sentence.split(" ");
        
        for(int k = 0; k < all.length; k++) {
            String word = all[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            
            if(k != 0) res.append(" ");
            
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            
            if(curr.isEnd) {
                res.append(replacement);
            } else {
                res.append(word);
            }
        }
        return res.toString();
    }
}