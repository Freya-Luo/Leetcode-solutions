### Thinking
**Solution - DP**
 - using 2 arrays/ <u>2 variables (O(1))</u> `lenToBePos` & `lenToBeNeg` -- **[Multiplicative Result]**
   - keep track of max length - make product be `positive / negative` at index `i`
 - Logic:
   - if `nums[i] == 0`, everything goes from start
   - if `nums[i] < 0`
     - `lenToBePos[i]`: to make product be positive, need to check last `lenToBeNeg[i - 1]`
        - if `0`, then just 0
        - else, max len should be `lenToBeNeg[i - 1] + 1`
     - `lenToBeNeg[i]`: to make product be negative, need to check last `lenToBePos[i - 1]`
       - either 0 or > 0 does ont matter, just `lenToBePos[i - 1] + 1`
         - `As we know, the current num is < 0`
   - if `nums[i] > 0`
       - `lenToBePos[i]`: to make product be positive, need to check last `lenToBePos[i - 1]`
         - either 0 or > 0 does ont matter, just `lenToBePos[i - 1] + 1`
           - `As we know, the current num is > 0`
       - `lenToBeNeg[i]`: to make product be negative, just following last `lenToBeNeg[i - 1]`
         - if `0`, then just 0
         - else, max len should be `lenToBeNeg[i - 1] + 1`