### Thinking
**Solution - BFS w/ Bitmask**
> Quite similar to the LC 847  
> Using OOP would be much more clear and concise. In this question, I first use `char[6] keys` instead of `bitmask keys`.
> However, the `hashCode()` would take more time to compute array compared with just int.
- Logic:
  - bitmask: `ith` bit set means the `ith` key is obtained
  - `keys | (1 << (nc - 'a'))` set the `ith` bit to `1`, obtained
  - `(nkeys & (1 << (nc - 'A'))) == 0` means the `ith` key is not obtained
  - `(cur.keys == ((1 << keysCnt) - 1))` means all the keys have been obtained
  - Again, the `moves` state is not necessary to compute the `seen` state
    - only takes `x & y & bitmask (fetched keys)`