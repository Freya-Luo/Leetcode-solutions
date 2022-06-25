# Leetcode-solutions

|                                      Problem                                      |                             Note                              | 
|:---------------------------------------------------------------------------------:|:-------------------------------------------------------------:|
|                              42. Trapping Rain Water                              |                MonoStack / DP(Bidir find_max)                 | 
|                               44. Wildcard Matching                               |       Backtrack / DP (add 1 more char to `*` to check)        | 
|                                 71. Simplify Path                                 |                             Stack                             |     
|                                 72. Edit Distance                                 |                DP (delete (insert) / replace )                |       
|                        84. Largest Rectangle in Histogram                         |                        DP / Mono stack                        |         
|                               85. Maximal Rectangle                               |                        DP / Mono stack                        |        
|                          96. Unique Binary Search Trees                           |                              DP                               |           
|                              97. Interleaving String                              |                  DP `s3[k] from s1[i]/s2[j]`                  |             
|                                 113. Path Sum II                                  |                       DFS(Backtracking)                       |              
|                                 127. Word Ladder                                  |                        BFS/ Bidir BFS                         |                
|                                  139. Word Break                                  |                              DP                               |                  
|                                140. Word Break II                                 |                      DFS w/ HashMap Memo                      |                  
|                             147. Insertion Sort List                              |                      Insertion List Sort                      |                    
|                     153. Find Minimum in Rotated Sorted Array                     |                         Binary Search                         |                    
|                   154. Find Minimum in Rotated Sorted Array II                    |                         Binary Search                         |                   
|                         173. Binary Search Tree Iterator                          |                         In-order BST                          |
|                                 174. Dungeon Game                                 |            DFS (top-down w/ memo) / DP (bottom-up)            |    
|                                 189. Rotate Array                                 |               reverse(0, k-1) & reverse(k, n-1)               |
|                         199. Binary Tree Right Side View                          |                              DFS                              | 
|                            239. Sliding Window Maximum                            |             Deque (Descending queue)/ Bidir loop              | 
|                            249. Group Shifted Strings                             |                          Hash String                          | 
|                               279. Perfect Squares                                |                           DP / BFS                            |    
|                        300. Longest Increasing Subsequence                        |                           DP (LIS)                            |         
|                          301. Remove Invalid Parentheses                          |                BFS (node storing whole string)                |
|                        304. Range Sum Query 2D - Immutable                        |                        DP (matrix sum)                        |                  
|                309. Best Time to Buy and Sell Stock with Cooldown                 |                      DP w/ State Machine                      |      
|                         311. Sparse Matrix Multiplication                         |                    store (row, 1's index)                     |
|                                312. Burst Balloons                                |                              DP                               |         
|                     315. Count of Smaller Numbers After Self                      |                      Merge Sort / BITree                      |    
|                     317. Shortest Distance from All Buildings                     | BFS, decrement visisted cells to represent the x-th round BFS | 
|                     329. Longest Increasing Path in a Matrix                      |                DFS w/ Memo / Topological sort                 | 
|                            332. Reconstruct Itinerary                             |                       DFS/Eulerian Path                       |   
|                               337. House Robber III                               |         DFS (int[] return w/o Memo) / (map with memo)         |      
|                            339. Nested List Weight Sum                            |                            DFS/BFS                            |             
|                          364. Nested List Weight Sum II                           |                            DFS/BFS                            |       
|                          366. Find Leaves of Binary Tree                          |                        DFS find height                        | 
|                                370. Range Addition                                |                          Prefix Sum                           |  
|                                  403. Frog Jump                                   |                    DFS/DP(HashMap, Array)                     |     
|                           410. Split Array Largest Sum                            |                      DP / Binary Search                       |   
|           426. Convert Binary Search Tree to Sorted Doubly Linked List            |                      In-order traversal                       |          
|                                 437. Path Sum III                                 |                       DFS + Prefix Sum                        |          
|                              472. Concatenated Words                              |                      Sort, then DFS / DP                      |  
|                              498. Diagonal Traverse                               |                      diag index are same                      | 
|                           523. Continuous Subarray Sum                            |                       preSum (mod math)                       | 
|                           528. Random Pick with Weight                            |                          PreSum + BS                          |          
|                           539. Minimum Time Difference                            |                       Time wrap around                        | 
|                       540. Single Element in a Sorted Array                       |                         Binary Search                         |                
|                             547. Number of Provinces                              |                   DFS base on N not (i, j)                    |              
|                  562. Longest Line of Consecutive One in Matrix                   |       3D DP `3rd dimension stores max in 4 directions`        |
|                       583. Delete Operation for Two Strings                       |                              DP                               |               
|                         636. Exclusive Time of Functions                          |                       stack (func call)                       | 
|                          669. Trim a Binary Search Tree                           |                        Post-order Trim                        |            
|                                 670. Maximum Swap                                 |         Backwards / Forwards (last occurrence index)          | 
|                   673. Number of Longest Increasing Subsequence                   |                    DP (LIS) / Brute force                     |              
|                             684. Redundant Connection                             |                          Union Find                           |              
|                           685. Redundant Connection II                            |                Union Find (2 parents & cycle)                 |               
|                            687. Longest Univalue Path                             |                   Post-order (choose path)                    |            
|                       688. Knight Probability in Chessboard                       |                       DP (2d + 1d step)                       |                
|                              695. Max Area of Island                              |                              DFS                              |             
|                              707. Design Linked List                              |                      Double Linked List                       |            
|                  708. Insert into a Sorted Circular Linked List                   |                          2 Pointers                           | 
|                                721. Accounts Merge                                |                 Union Find (union list index)                 | 
|                                  733. Flood Fill                                  |                              BFS                              |              
|                              743. Network Delay Time                              |                           Dijkstra                            |        
|                               740. Delete and Earn                                |                         DP by TreeMap                         |              
|                           746. Min Cost Climbing Stairs                           |                              DP                               |                 
|                              767. Reorganize String                               |                   Space-separated Insertion                   |          
|                       787. Cheapest Flights Within K Stops                        |                    Dijkstra / Bellman-Ford                    |               
|                          790. Domino and Tromino Tiling                           |                    DP (two filling states)                    |           
|                              791. Custom Sort String                              |                          Bucket Sort                          | 
|                  801. Minimum Swaps To Make Sequences Increasing                  |                     DP (swap[]/noswap[])                      |          
|                          802. Find Eventual Safe States                           |             DFS / Topological Sort(reverse edges)             |                                    
|                           813. Largest Sum of Averages                            |                        DP / DFS + memo                        |           
|                                  815. Bus Routes                                  |                      BFS (stop & routes)                      |               
|                                   818. Race Car                                   |                       DP / DFS w/ Memo                        |                 
|                            827. Making A Large Island                             |                     DFS (label & connect)                     |                  
|         828. Count Unique Characters of All Substrings of a Given String          |      Last & SecondToLast index - occurrence of char `c`       |  
|                            839. Similar String Groups                             |                              DFS                              |               
|                                841. Keys and Rooms                                |                              DFS                              |                   
|                       847. Shortest Path Visiting All Nodes                       |                        BFS w/ Bitmask                         |                  
|                     863. All Nodes Distance K in Binary Tree                      |                 BFS/DFS (rotate node's depth)                 |                  
|                        864. Shortest Path to Get All Keys                         |                        BFS w/ Bitmask                         |             
|                             875. Koko Eating Bananas                              |                    BS (calc for each mid)                     |M|
|                     882. Reachable Nodes In Subdivided Graph                      |      Dijkstra (count edges used times/count left moves)       |                    H                    |
|                             886. Possible Bipartition                             |                       DFS/BFS coloring                        |               
|                              901. Online Stock Span                               |                          Mono Stack                           |        
|                           907. Sum of Subarray Minimums                           |                    Monotonic Stack (Bidir)                    |  
|                    921. Minimum Add to Make Parentheses Valid                     |                        Count Imbalance                        |              
|                      926. Flip String to Monotone Increasing                      |                        Prefix Sum / DP                        |   
|                           931. Minimum Falling Path Sum                           |                              DP                               |                 
|                          937. Reorder Data in Log Files                           |                       Custom Comparator                       |
|                   952. Largest Component Size by Common Factor                    |                      UF + Prime Factors                       |                
|                            959. Regions Cut By Slashes                            |                      Scale up grid + DFS                      |               
|                          973. K Closest Points to Origin                          |                     MaxPQ / Quick Select                      |                
|                       979. Distribute Coins in Binary Tree                        |              DFS + Greedy (count balance coins)               |              
|                               980. Unique Paths III                               |                           Backtrack                           |                  
|                  987. Vertical Order Traversal of a Binary Tree                   |                    BFS/DFS + PQ/Map(sort)                     |              
|                     990. Satisfiability of Equality Equations                     |                    UF(1st `==` then `!=`)                     |           
|                     992. Subarrays with K Different Integers                      |            Sliding window(AtMost(k)- AtMost(k-1))             |            
|                               994. Rotting Oranges                                |                              BFS                              |              
|                          996. Number of Squareful Arrays                          |                           Backtrack                           |         
|                          1004. Max Consecutive Ones III                           |                        Sliding window                         |
|                               1024. Video Stitching                               |                Greedy, extend `e` in `[s, e]`                 |         
|                      1042. Flower Planting With No Adjacent                       |                     DFS/ Greedy coloring                      |             
|                   1011. Capacity To Ship Packages Within D Days                   |                    BS (calc for each mid)                     |                    
|                       1091. Shortest Path in Binary Matrix                        |                              BFS                              | 
|                          1105. Filling Bookcase Shelves                           |              DP (look for each in the pre level)              |              
|                     1135. Connecting Cities With Minimum Cost                     |                      UF(Kruskal's Algo)                       |  
|                                1140. Stone Game II                                |                         DP (postSum)                          |       
|                   1151. Minimum Swaps to Group All 1's Together                   |                  Sliding Window (count 1's)                   |  
|                     1152. Analyze User Website Visit Pattern                      |                 Brute force O(m<sup>3</sup>)                  | 
|                       1167. Minimum Cost to Connect Sticks                        |                              PQ                               |   
|                      1192. Critical Connections in a Network                      |                   Tarjan' Algo / lowdist[]                    |                  
|                         1202. Smallest String With Swaps                          |                              UF                               |              
|             1218. Longest Arithmetic Subsequence of Given Difference              |                              DP                               |           
|            1263. Minimum Moves to Move a Box to Their Target Location             |                  BFS (nested, box & player)                   |           
|                          1268. Search Suggestions System                          |                           Sort + BS                           |  
|                   1277. Count Square Submatrices with All Ones                    |                              DP                               |        
|             1293. Shortest Path in a Grid with Obstacles Elimination              |                 BFS (State class customized)                  | 
|               1319. Number of Operations to Make Network Connected                |                          Union Find                           |           
|                      1325. Delete Leaves With a Given Value                       |                          Post-order                           |             
| 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance |                       Dijkstra / Floyd                        |    
|                1353. Maximum Number of Events That Can Be Attended                |                       Sort + PQ(Greedy)                       |        
|                     1428. Leftmost Column with at Least a One                     |                   Top-Right move 2 pointers                   |
|              1481. Least Number of Unique Integers after K Removals               |                       PQ / Bucket Sort                        |  
|              1567. Maximum Length of Subarray With Positive Product               |                DP (posLen+negLen arrays/vars)                 |   
|                      1570. Dot Product of Two Sparse Vectors                      |                            HashMap                            |             
|              1628. Design an Expression Tree With Evaluate Function               |                          Stack + OOP                          |   
|                    1648. Sell Diminishing-Valued Colored Balls                    |                       Sort / PQ + Math                        | 
|                          1710. Maximum Units on a Truck                           |                         Sort + Greedy                         | 
|                          1730. Shortest Path to Get Food                          |                              BFS                              |    
|                  1868. Product of Two Run-Length Encoded Arrays                   |                         Two Pointers                          |
|                               1891. Cutting Ribbons                               |                         Binary Search                         | 
|                     1937. Maximum Number of Points with Cost                      |         DP, dp\[i - 1\] stores the comparison result          | 
|         2096. Step-By-Step Directions From a Binary Tree Node to Another          |                   LCA + DFS w/ Backtracking                   | 
|                2115. Find All Possible Recipes from Given Supplies                |      Topological sort `supplies(ingredients) -> recipes`      |
|                  2128. Remove All Ones With Row and Column Flips                  |                  Math, 0110 == 0110 == 1001                   | 
