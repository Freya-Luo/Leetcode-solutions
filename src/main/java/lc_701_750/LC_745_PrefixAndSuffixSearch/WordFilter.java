package lc_701_750.LC_745_PrefixAndSuffixSearch;

/**
 * Time: O(NK^2 + QK); N: words.length, K: max length of a word; Q: number of queries
 *
 * Instead of directly inserting "book", we insert a list of words:
 * "book{book", "ook{book", "ok{book", "k{book", "{book"
 * Each char is a typical Trie Node with index field to record the largest index. Choosing "{" as a splitter is
 * because "{" in ASCII code char is the next one to "z".
 *
 * So, for each query pair, we concatenate the prefix and suffix in the form of 'suff + "{" + pref'. Once we reach
 * the end of the search query, we can directly return the index in the last Node.
 */
class WordFilter {

    class Node {
        int index;
        Node[] children = new Node[27];

        Node(int index) {
            this.index = index;
        }
    }

    private Node root = new Node(-1); // root of Trie

    private void addWord(String w, int index) {
        Node cur = root;

        for(int i = 0 ; i < w.length(); i++) {
            char c = w.charAt(i);

            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(index);
            } else {
                cur.children[c - 'a'].index = index;
            }
            cur = cur.children[c - 'a'];
        }
    }

    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
            String w = words[i] + "{" + words[i];
            for(int j = 0; j <= words[i].length(); j++) {
                addWord(w.substring(j), i);
            }
        }
    }

    public int f(String pref, String suff) {
        Node cur = root;
        String search = suff + "{" + pref;

        for(int i = 0; i < search.length(); i++) {
            char c = search.charAt(i);
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else return -1;
        }
        return cur.index;
    }
}
