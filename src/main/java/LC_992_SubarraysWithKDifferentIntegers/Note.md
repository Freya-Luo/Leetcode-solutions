### Thinking
- WHY typical Sliding Window does **NOT** work?
  - main idea behind - convert nested loop into one loop, so O(n<sup>2</sup>) to O(n)
  - Use Condition
    - asks to find the **max (or min)** value for a function that calculates the answer repeatedly for a **set of ranges**
> This question needs to find the **no.of subsests**, **not** just the <u>max subarray length</u>

- Convert to Sliding Window problem ?
  - Yes, use `AtMost(arr, k) - AtMost(arr, k - 1)`
- Why `subs += (end - beg + 1)` ? 
```java
// Explanation from LC discussion - priyankarking's post
suppose initial window [a] then subarrays that ends with this element are [a]--> 1
now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
[b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3

You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting of duplicate subarrays that we already considered previously.
And surprisingly the number of sub-arrays with this new element in it is equal to the length of current window.
```