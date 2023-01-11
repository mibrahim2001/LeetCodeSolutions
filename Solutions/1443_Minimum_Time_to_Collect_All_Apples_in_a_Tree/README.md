# Intuition

The problem is to find the minimum time needed to collect all apples in a tree where some nodes have apples. The time taken is the sum of the steps taken to move from one node to another. The steps are the number of edges between two nodes.

# Approach

The code uses a depth-first search (DFS) approach to solve the problem. It starts at the root node (0th index) and recursively calls the helper function for each neighbor of the current node. The adjacency list is used to represent the tree and the helper function, minTimeToCollectApples, takes in the current node index, adjacency list, hasApple list and the parent node index as inputs. It calculates the total time taken by adding the time taken by each descendant of the current node. It then checks whether the current node is the root node, or if it has an apple or any of its descendants have an apple, and adds 2 time if that is the case. The final time is returned as the result.

# Complexity

- Time complexity:
  As it uses DFS, it visits each node once so the time complexity is O(n)

- Space complexity:
  The code uses an adjacency list to represent the tree, so the space complexity is O(n + e), where n is the number of nodes, and e is the number of edges.

# Code

```
class Solution {
    // Function to find the minimum time to collect all apples in a tree represented by edges and hasApple.
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Create an adjacency list to represent the tree
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        // populate the adjacency list with undirected edges
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // call to helper function to find the minimum time
        return minTimeToCollectApples(0, adj, hasApple, 0);
    }
    // Helper function to find the minimum time to collect all apples from the given node index and its descendants
    int minTimeToCollectApples(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        // variable to keep track of total time taken
        int total = 0;
        // for each neighbor of current node
        for(int nbr : adj.get(index)){
            // if the neighbor is the parent node, then we skip
            if (nbr == parent)
             continue;
            // we recursively call the helper function for each neighbor
            total += minTimeToCollectApples(nbr, adj, hasApple, index);
        }
        // If current node is not the root (0th) node, and it has an apple or any of its descendant has
        // then we need to add 2 time for moving to and from it
        if( index != 0 && (hasApple.get(index) || total > 0))
          total += 2;
        return total;
    }
}

```
