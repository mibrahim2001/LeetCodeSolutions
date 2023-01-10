import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // we compare two list that are returned by pre-oder traversal of the two trees
        // if they are equal it means tree are equal and vice versa
        return preorderTraversal(p).equals(preorderTraversal(q));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // base condition
        if (root == null) {
            // return a null element when the node is null
            list.add(null);
            return list;
        }
        // add the value of node to list
        list.add(root.val);
        // recurse first on the left part then on the right part
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        // return the list
        return list;
    }
}