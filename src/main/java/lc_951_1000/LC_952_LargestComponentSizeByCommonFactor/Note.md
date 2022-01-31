### Thinking
###### Note
> I first get O(N^2) TLE, where all pairs' GCF of nodes are calculated;  
Then the idea goes into a new direction => connect numbers into sets led by their **common `factors`**, instead of `numbers`


> Union Find: If M operations, either `Union` or `Find`, are applied to N elements, the total run time is O(M⋅log
∗ N), the iterated logarithm.

**Solution -- UF w/ all factors**
- `Union(num, factor)`
- Logic:
  - put each number to a series of groups led by **each of its factors**
    - NOTE: start from `cf=2`, and all the way up tp `sqrt(num)`
    - connect both `union(num, cf)` & `union(num, num/cf)`
  - loop through each number and find the group it belongs to by `find(num)`, update `maxSize`  

**Solution -- UF w/ only prime factor**
- Logic: 
   - rule out the non-essential factors
   - HOW & WHY?
     - **Prime Factors** of a number can **represent all** of its factors
       - an int can be characterized by a series of prime factors
     - **FACT:** `every positive integer has a unique prime factorization`
   - SO, using groups led by **its prime factors**