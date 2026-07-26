/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans=null;
    int fun(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return 0;
        int left=fun(node.left,p,q);
        int right=fun(node.right,p,q);
        int self=0;
        if(node==p || node==q) self=1;
        int tot=left+self+right;
        if(tot==2 && ans==null) ans=node;
        return tot;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root,p,q);
        return ans;
    }
}