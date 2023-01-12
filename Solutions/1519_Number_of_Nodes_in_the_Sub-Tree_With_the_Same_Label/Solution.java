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