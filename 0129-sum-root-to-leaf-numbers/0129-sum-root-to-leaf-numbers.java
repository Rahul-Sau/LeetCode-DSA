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
    int res=0;
    void fun(TreeNode root,int Sum){
        if(root==null) return;
        Sum=Sum*10+root.val;
        if(root.left==null && root.right==null){
            res+=Sum;
            return;
        }
        fun(root.left,Sum);
        fun(root.right,Sum);
        return;
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        fun(root, 0);
        return res;
    }
}