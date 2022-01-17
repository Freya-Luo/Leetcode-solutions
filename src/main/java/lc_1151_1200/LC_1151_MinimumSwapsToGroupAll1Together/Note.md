### Thinking
**Solution - Sliding Window**
- Key: swapping `==` num of `0's` in the current window
  - calculate the total number of `1` in `arr`
  - keep the `size` of window at least the size of `totalNumOfOne`
    - Either maintain the least num of `0` in the window
    - Or maintain the max num of `1` in the window