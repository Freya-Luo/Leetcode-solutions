### Thinking
**Solution - DP (Bottom-up)**
- Logic:
  - for each `word`, consider delete each `char` in the `word`
    - check if the substring exists in the `map` & increase the occurrence
  - put this `word` in the `counter` map
  - computing the `maxLen` during the process