### Thinking 
<strong>Solution 1</strong>
  - `"XAXAXXAX"` 
    - make the second "A" counted as a uniq character
      - `"A(XA"` and `"AX(A"` - 2 ways
      - `"A)XXA"`, `"AX)XA"` and `"AXX)A"`, 3 ways
      - total 2 * 3 = 6 ways for this `A (2nd one)`
  - Reverse logic: Count for every char in S, <strong>how many ways to be found as a unique char</strong>  

<strong>Solution 2</strong>
  - we have 3 cases to be considered 
    ```java
    // c = s.charAt(i)
    Case 1. s[k : i-1] contains 0 c              ==> countUniqueChars(s[k : i]) = countUniqueChars(s[k : i-1]) + 1
    // s[k : i] has one more unique char (c itself) comparing to s[k : i-1]
    Case 2. s[k : i-1] contains 1 c              ==> countUniqueChars(s[k : i]) = countUniqueChars(s[k : i-1]) - 1
    // s[k : i] has one less unique char (c itself) comparing to s[k : i-1]
    Case 3. s[k : i-1] contains at least 2 c     ==> countUniqueChars(s[k : i]) = countUniqueChars(s[k : i-1])
    // c is not an unique char for either s[k : i-1] or s[k : i]
    ```
    - so, now we have the formula to get the sum at index i  
      - `sum of countUniqueChars() for index i
      =  sum of countUniqueChars() for index i-1  +  #(case 1)  -  #(case 2)  +  1  `
      - then, the question becomes calculate the substrings number in `case 1 & 2`
        ```java
        // Any s[0: i- 1] can be divided into these groups based on the last occurrence and 
        // the second to last occurrence of the current char
        Case 1. k in [p+1, i-1]   <==>  c appears 0 time in s[k : i-1]  
        Case 2. k in [q+1, p]     <==>  c appears 1 time in s[k : i-1]  
        Case 3. k in [0, q]       <==>  c appears at least 2 times in s[k : i-1]  
        ```