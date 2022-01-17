package lc_1451_1500.LC_1481_LeastNumberOfUniqueIntegerAfterKRemovals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // O(NlogN) - PQ
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : arr) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(counter.size(), Comparator.comparing(counter::get));
        pq.addAll(counter.keySet());

        while (k > 0) {
            // int curCount = counter.get(pq.peek());
            // if (curCount <= k) {
            //     k -= curCount;
            //     pq.poll();
            // } else {
            //     k -= curCount;
            // }
            k -= counter.get(pq.poll());
        }
        // return pq.size();
        return k < 0 ? pq.size() + 1 : pq.size();
    }

    // O(N) - Bucket Sort, using index as the count indicator
    public int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : arr) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // index: occurrence of a number -- order nums by using index as the indicator
        int[] numOccByIdx = new int[arr.length + 1];
        for(int val : counter.values()) {
            numOccByIdx[val]++;
        }

        // idx: next num index && the count of that num
        // numOccByIdx[idx]: how many differ nums having "idx" occurrences
        // remainNum: remained differ number (includeing duplicates)
        int idx = 1, remainNum = counter.size();
        while(k >  0) {
            if (k - idx * numOccByIdx[idx] >= 0) {
                k -= idx * numOccByIdx[idx];
                remainNum -= numOccByIdx[idx];
                idx++;
            }  else {
                return remainNum - k / idx;
            }
        }
        return remainNum;
    }
}