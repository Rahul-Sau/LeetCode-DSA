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
    TreeNode ans=null;
    TreeNode fun(TreeNode node, int k){
        if(node==null) return null;
        if(node.val==k) {
            ans=node;
            return node;
        }
        if(node.val>k)
        fun(node.left,k);
        else
        fun(node.right,k);
        return node;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        fun(root,val);
        return ans;
    }
}