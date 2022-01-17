### Thinking
###### Note
- quite similar to find min meeting rooms for a set of meetings with `[starti, endi]` 

**Solution - Sort + PQ (Greedy)**
- Process:
  - sort the events based on the **start** time
  - for every day `curDay`
    - **remove** all the events that has **ended**
    - **sort** all the events that happen in `curDay` based on **end** time with PQ
      - attend the events that end sooner `(Greedy)`
    - if `curDay` has events, attend one; then <u>remove attended event</u> 