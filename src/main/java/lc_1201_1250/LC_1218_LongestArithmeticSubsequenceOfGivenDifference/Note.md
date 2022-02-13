### Thinking
**Solution**
- Logic:
  - Map `dp` represents `<number, length of AS ending at this number>`
  - That is:
    - at each int `num` in the array we can consider it as the end of AP
    - check and update AP length => `(length of AP ending at (num - diff)) + 1`