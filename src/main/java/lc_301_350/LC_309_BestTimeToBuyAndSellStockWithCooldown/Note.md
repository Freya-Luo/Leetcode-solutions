### Thinking
**Solution - DP/State Machine**
- Logic:
  - use`State Machine` to help to get the logic
  - define 3 states: `READY_BUY`, `READY_SELL`, and `REST_DAY` with the following transitions
    - a) `READY_BUY` ---> buy now ---> `READY_SELL` ---> sell now ---> `REST_DAY` ---> rest ---> `READY_BUY`
    - b1) `READY_BUY` ---> continue rest & _wait for future buy_ ---> `READY_BUY`
    - b2) `REST_DAY` ---> rest ---> `REST_DAY`, similar to `READY_BUY` -> `READY_BUY`
      - SO, we can _ignore one of this transition_
    - c) `READY_SELL` ---> hold stock & _wait for future sell_ ---> `READY_SELL`
    ```markdown
      READY_BUY <- rest -- REST_DAY
           |               /
           | buy now     /  sell now
           |          /
          READY_SELL  
    ```
  - maintain 3 array, then at each `i-th` day
    - `readyBuy[i]`: today can `BUY`, before `BUY` & moving to the next state, its max value could be from
       - `cooldown[i - 1]` => value from previous cooldown day
    - `readySell[i]`: today can `SELL`, before `SELL` & moving to the next state, its max value would be from
       - `max(readyBuy[i - 1] - prices[i], readySell[i - 1])` 
         - value from previous ready-buy day (`-prices[i]` to buy the today's stock) or from previous ready-sell day
    - `cooldown[i]`: today must/can `REST`, before moving to the next state, its max value would be from
      - `max(cooldown[i - 1], readySell[i - 1] + prices[i])`
        - value from previous rest day (continue rest) or from previous ready-sell day (`+prices[i]` to sell the today's stock) 
  - finally, the max stock would be from
    - `max(readyBuy[n - 1], cooldown[n - 1]`
    - WHY?
      - these two states with not cause extra payment `no out stock`
      - `readySell` cannot be greater as the last paid stock has no way to get pay back