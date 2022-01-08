package LC_1152_AnalyzeUserWebsiteVisitPattern;

import java.util.*;

class Solution {
    // Brute force solution
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // <username, <timestamp, website>> mapping
        Map<String, TreeMap<Integer, String>> store = new HashMap<>();
        int n = username.length;

        for(int i = 0; i < n; i++) {
            store.putIfAbsent(username[i], new TreeMap<>()); // keep the visiting order
            store.get(username[i]).put(timestamp[i], website[i]);
        }

        // <pattern, count> mapping
        Map<String, Integer> count = new HashMap<>();
        String record = "";
        int max = 0;
        // O(N * m^3), N: number of users, m: avg length of webs list for each user
        for(String user: store.keySet()) {
            List<Map.Entry<Integer, String>> webs = new ArrayList<Map.Entry<Integer, String>>(store.get(user).entrySet());

            Set<String> set = new HashSet<>();
            int m = webs.size();
            // O(m^3)
            for (int i = 0; i < m; i++) {
                String first = webs.get(i).getValue();
                for (int j = i + 1; j < m; j++) {
                    String second = webs.get(j).getValue();
                    for (int k = j + 1; k < m; k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(first + " " + second + " " + webs.get(k).getValue());
                        String pattern = sb.toString();

                        if (set.contains(pattern)) continue;

                        set.add(pattern);
                        count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                        if (count.get(pattern) > max
                                || (count.get(pattern) == max && pattern.compareTo(record) < 0)) {
                            max = count.get(pattern);
                            record = pattern;
                        }
                    }
                }
            }
        }

        String[] websites = record.split(" ");
        return Arrays.asList(websites);
    }
}