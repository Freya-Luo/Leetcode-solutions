package lc_651_700.LC_721_Accounts_Merge;

import java.util.*;

class Solution {
    private HashMap<String, Integer> groups = new HashMap<>();
    private int[] rootIds;
    private int[] size;

    private int find (int x) {
        if (rootIds[x] == x) {
            return x;
        }
        return rootIds[x] = find(rootIds[x]); // path compression: O(NK*alpha(N))
    }

    private void union (int g1, int g2) {
        int x = find(g1);
        int y = find(g2);

        if (x == y) return;

        if (size[x] > size[y]) {
            rootIds[y] = x;
            size[x] += size[y];
        } else {
            rootIds[x] = y;
            size[y] += size[x];
        }
    }
    // Time: O(NKlogNK + NK*alpha(N)): N: accounts.size(), K: max length of accounts.get(i)
    // Space: O(NK)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        rootIds = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            rootIds[i] = i;
            size[i] = 1;
        }

        // union find to unify the groups
        for(int i = 0; i < n; i++) {
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);

                if (groups.containsKey(email)) {
                    union(i, groups.get(email));
                } else {
                    groups.put(email, i);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        for(String email: groups.keySet()) {
            int gId = find(groups.get(email));
            if (!map.containsKey(gId)) {
                map.put(gId, new LinkedList<>());
            }
            map.get(gId).add(email);
        }

        for(int gId : map.keySet()) {
            List<String> accountEmails = map.get(gId);
            Collections.sort(accountEmails);  // sort: O(NKlogNK)
            accountEmails.add(0, accounts.get(gId).get(0));
            res.add(accountEmails);
        }
        return res;
    }
}