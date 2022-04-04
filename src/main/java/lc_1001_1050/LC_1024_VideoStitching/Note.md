### Thinking
**Solution**
- logic
  - first sort all the intervals based on the starting time
  - then, find the current interval `formed by start & end pointers` and try to extend this by looping all others whose `start time` falls into this range
- Example:
  ```markdown
  clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
  
  - sort: [0, 2] [1, 9] [1, 5] [4, 6] [5, 9] [8, 10]
  - (s , e)[0,0]
    - add the first one itself, so "cnt += 1"
    - find [0, 2], extend e = 2
    - find next interval whose start time is between [0, 0] 
      - none, break => need more intervals
  - (s , e)[1,2]
    - need 1 more interval, "cnt += 1"
    - find [1, 9], extend e = 9; find [1, 5], e is still 9
    - no more intervals whose start time is in [1, 2]
      - break
  - (s, e)[3, 9]
    - all the rest intervals can be tested in the (s, e)
      - only [8, 10] extends e to 10; NOW, find the "time"  just return cnt
  ```
  - idea: 
    - `[s, e]` is the interval we're searching that if any given interval's start time falls in this range
    - in every targeted interval `[s, e]`, we only need to find 1 interval that extends `end` most
