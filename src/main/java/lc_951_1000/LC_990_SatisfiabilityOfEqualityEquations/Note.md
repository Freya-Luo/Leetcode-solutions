### Thinking
- Note:
  - the most clear and concise way of detecting conflicts would be 
     - 1st, union all the chars if `==`
     - 2nd, check if any `!=` relation violates the existing disjoint sets
  > Detecting along the way would be doable, but that will increase the code complexity and more cases needed to be considered;  
  > While the tim complexity is not affected too much. 