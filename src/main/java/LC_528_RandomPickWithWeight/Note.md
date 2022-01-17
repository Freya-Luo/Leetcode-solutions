### Thinking
**Solution - Prefix Sum + Binary Search**
- Example to illustrate
```aidl
[1,2,3,4,3]
=> preSum = [1, 3, 6, 10, 13], totalSum = 13

- for i=0, range is {0,0} <=> index=0, range is <1
- i=1, range of indices of the new array is {1,2} <=> index=1, range is <3
- i=2, range={3,5} <=> index=2, range is <6
- i=3, range ={6,9} <=> index=3, range is <10
- i=4, range = {10,12} <=> index=4, range is <13

// Then we can use BS to find the index
=> the first ele that is >= to the target
```