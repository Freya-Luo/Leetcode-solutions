package LC_1268_SearchSuggestionsSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_OptimizedTrie {
    
    /**
     *  Time: O(n * m + k), m: average len of product, n: products.length, k : searchWord.length
     * Space: O(26 * N + N * m), where N is the number of nodes in Trie
     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }
    
    private TrieNode root = new TrieNode();
    
    private void insertWord (String s) {
        TrieNode cur = root;
        
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.suggestions.add(s);
            Collections.sort(cur.suggestions); // O(1)
            if (cur.suggestions.size() > 3) {
                cur.suggestions.remove(cur.suggestions.size() - 1);
            }
        }
    }

  
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for(String product : products) {
            insertWord(product);
        }
      
        TrieNode cur = root;
        for (char c : searchWord.toCharArray()) { 
            if (cur != null) {
                cur = cur.children[c - 'a']; 
            }
            
            if (cur != null) {
                res.add(cur.suggestions);
            } else {
                res.add(new ArrayList<>()); 
            }
        }
        return res;
    }
}