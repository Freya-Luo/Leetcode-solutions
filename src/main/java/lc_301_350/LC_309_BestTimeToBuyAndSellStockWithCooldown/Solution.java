package lc_301_350.LC_309_BestTimeToBuyAndSellStockWithCooldown;

class Solution {
    // O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] readyBuy = new int[n], readySell = new int[n], cooldown = new int[n];

        readyBuy[0] = 0;
        readySell[0] = -prices[0];
        //cooldown[0] = -1;
        cooldown[0] = -1; /** ---- my new version -- */

        for(int i = 1; i < n; i++) {
//            readyBuy[i] = Math.max(readyBuy[i - 1], cooldown[i - 1]); b1)
//            readySell[i] = Math.max(readySell[i - 1], readyBuy[i - 1] - prices[i]);
//            cooldown[i] = readySell[i - 1] + prices[i];
            /** ---- my new version -- */
            readyBuy[i] = cooldown[i - 1];
            readySell[i] = Math.max(readySell[i - 1], readyBuy[i - 1] - prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], readySell[i - 1] + prices[i]);  //b2)
        }
        return Math.max(readyBuy[n - 1], cooldown[n - 1]);
    }
}