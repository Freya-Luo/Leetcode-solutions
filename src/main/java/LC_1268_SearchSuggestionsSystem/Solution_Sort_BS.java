package LC_1268_SearchSuggestionsSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_Sort_BS {
    /**
     * Time: O(N*logN + M*logN), n: products.length; m: searchWord.length
     */
    private int ceilWordIdx(String[] products, String prefix, int beg) {
        int left = beg, right = products.length;
        // O(M*logN)
        while(left + 1 < right) {
            int mid = (right + left) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        // O(N*logN)
        Arrays.sort(products);

        int beg = -1;
        for(int k = 1; k <= searchWord.length(); k++) {
            String prefix = searchWord.substring(0, k);
            // If not find the suitable string, start will be the products.length
            // safely skip the following for loop
            int start = ceilWordIdx(products, prefix, beg);

            List<String> suggestions = new ArrayList<>();

            for(int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                }
                beg = start - 1;
            }
            res.add(suggestions);
        }
        return res;
    }
}