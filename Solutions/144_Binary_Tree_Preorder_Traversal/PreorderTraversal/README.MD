# Intuition

This code performs a preorder traversal of a binary tree. In a preorder traversal, the root node is visited first, then the left subtree, and finally the right subtree.

# Approach

The code uses recursion to traverse the tree. It first adds the root node's value to the list, and then recursively calls itself on the left and right subtrees.

# Complexity

- Time complexity:
  The time complexity of this code is O(n), where n is the number of nodes in the tree. This is because each node in the tree is visited exactly once.

- Space complexity:
  The space complexity of this code is O(n), where n is the number of nodes in the tree. This is because at any given time, the recursive call stack could potentially hold the value of every node in the tree.

# Code

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
```
