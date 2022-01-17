package lc_1251_1300.LC_1268_SearchSuggestionsSystem;

import java.util.ArrayList;
import java.util.List;

class Solution_Trie {
    
    /**
     * Time: O(n * m + k^2), m: average len of product, n: products.length, k : searchWord.length
     * Space: O(26 * N), where N is the number of nodes in Trie
     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    private TrieNode root = new TrieNode();
    
    private void insertWord (String s) {
        TrieNode cur = root;
        
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    private void dfs(List<String> res, TrieNode cur, String pre) {
        if(res.size() == 3) return;
        
        if (cur.isWord) {
            res.add(pre);
        }
        
        for (int i = 0; i < 26; i++) {
            TrieNode child = cur.children[i];
            if (child != null) {
                dfs(res, child, pre + (char)(i + 'a'));
            }
        }
    }
    
    private List<String> getWordsWithPrefix(String pre) {
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        
        for (char c : pre.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
               return res;
            }
            cur = cur.children[c - 'a'];
        }
        
        dfs(res, cur, pre);
        return res;
    }
  
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for(String product : products) {
            insertWord(product);
        }
        // O(k^2)
        for(int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            
            List<String> allWords = getWordsWithPrefix(prefix);
            
            res.add(allWords);
        }
        return res;
    }
}