### Thinking
**Solution**
> This is question would be O(N^3 * M^3) if using brute force.  
At each row / level `i`, we can view the matrix as the Histogram in LC.84. That is, at current column index `j`, we can form 
histograms at each level and the height at `j` would be the number of consecutive `1` right above this column.