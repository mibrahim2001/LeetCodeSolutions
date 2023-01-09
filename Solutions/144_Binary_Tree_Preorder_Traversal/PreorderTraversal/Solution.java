package PreorderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);

        List<Integer> list = preorderTraversal(root2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
