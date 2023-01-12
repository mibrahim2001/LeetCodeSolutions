# Intuition

This code is trying to find the number of subtrees in a tree that have a specific label (or alphabet). It does this by creating an adjacency list to store the edges of the tree, and then traversing the tree using a depth-first search to count the number of subtrees with the specified label.

# Approach

The code starts by creating an adjacency list to store the edges of the tree. It then initializes an array to keep track of the number of subtrees with the specified label and a boolean array to keep track of which nodes have been visited. The function then calls the findNumberOfLabel function, which uses a depth-first search to traverse the tree and count the number of subtrees with the specified label.

# Complexity

- Time complexity:
  O(n) where n is the number of nodes in the tree. This is because the code is using depth-first search to traverse the tree, which has a time complexity of O(n) for a tree.

- Space complexity:
  O(n) where n is the number of nodes in the tree. This is because the code is using an adjacency list to store the edges of the tree and an array to keep track of the number of subtrees with the specified label. The space complexity for the adjacency list and the array is O(n) each, resulting in a total space complexity of O(n).

# Code

```
import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] result;
    List<List<Integer>> adj;
    boolean[] visited;

    // This function takes in the number of nodes in a tree, the edges that connect
    // the nodes and the labels of the nodes
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // Creating an adjacency list to store the edges
        adj = new ArrayList<>(n);
        result = new int[n];
        // initializing the adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // populating the adjacency list with the edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // keep track of visited nodes
        visited = new boolean[n];
        // calling the findNumberOfLabel function to count the subtrees starting from
        // the root node
        findNumberOfLabel(0, labels);
        return result;
    }

    // findNumberOfLabel function to traverse the tree and count the subtrees
    int[] findNumberOfLabel(int node, String labels) {
        // Declare an array which can store number of labels (or alphabets)
        int countOfLabels[] = new int[26];
        // Make visited for this node true
        visited[node] = true;
        // traverse the neighbours of the current node
        for (int neigbour : adj.get(node)) {
            // if the neigbour is not visited lets give it a visit
            if (!visited[neigbour]) {
                // Recursively get the count of labels from sub tree
                int[] neighbourCountOfLabels = findNumberOfLabel(neigbour, labels);
                // Update the count of labels for the current node
                for (int i = 0; i < countOfLabels.length; i++) {
                    countOfLabels[i] += neighbourCountOfLabels[i];
                }
            }
        }
        // Increment the count of label for the current node
        countOfLabels[labels.charAt(node) - 'a']++;
        // Store the count of labels for the current node in the result array
        result[node] = countOfLabels[labels.charAt(node) - 'a'];

        return countOfLabels;
    }

}
```
