package lc_2000_.LC_2034_StockPriceFluctuation;

import java.util.TreeMap;

// Time O(logN) for each operation
// Space O(N)
class StockPrice {

    private TreeMap<Integer, Integer> time2Stock;
    private TreeMap<Integer, Integer> prices; // may have different timestamps have the same price

    public StockPrice() {
        this.time2Stock = new TreeMap<>();
        this.prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        Integer prePrice = time2Stock.get(timestamp);

        if (prePrice != null) {
            prices.put(prePrice, prices.get(prePrice) - 1);
            if (prices.get(prePrice) == 0) {
                prices.remove(prePrice);
            }
        }

        time2Stock.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return time2Stock.get(time2Stock.lastKey());
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}