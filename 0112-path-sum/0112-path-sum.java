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
    boolean res=false;
    void fun(TreeNode root,int Sum,int k){
        if(root==null) return;
        Sum+=root.val;
        if(root.left==null && root.right==null){
            if(Sum==k)
            res=true;
            return;
        }
        fun(root.left,Sum,k);
        fun(root.right,Sum,k);
        return;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        res = false; 
        fun(root,0,targetSum);
        return res;
    }
}