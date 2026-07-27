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
   private Stack<TreeNode> ascStack = new Stack<>();
    private Stack<TreeNode> descStack = new Stack<>();

    private void pushLeft(TreeNode node) {
        while (node != null) {
            ascStack.push(node);
            node = node.left;
        }
    }
    private void pushRight(TreeNode node) {
        while (node != null) {
            descStack.push(node);
            node = node.right;
        }
    }

    private TreeNode getSmall() {
        if (ascStack.isEmpty()) return null;
        TreeNode node = ascStack.pop();
        pushLeft(node.right);
        return node;
    }
    private TreeNode getBig() {
        if (descStack.isEmpty()) return null;
        TreeNode node = descStack.pop();
        pushRight(node.left); 
        return node;
    }
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        pushLeft(root);
        pushRight(root);

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while (i != null && j != null && i != j) {
            int sum = i.val + j.val;
            
            if (sum == k) {
                return true;
            }
            if (sum > k) {
                j = getBig();
            } else {
                i = getSmall();
            }
        }
        return false;
    }
}