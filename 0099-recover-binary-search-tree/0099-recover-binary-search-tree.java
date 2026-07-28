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
    TreeNode prev=null;
    TreeNode g1f=null;
    TreeNode g1s=null;
    TreeNode g2f=null;
    TreeNode g2s=null;int glt=0;
    void fun(TreeNode root){
        if(root==null) return;
        fun(root.left);
        if(prev==null)
        prev=root;
        else{
            if(root.val<prev.val){
                if(glt==0){
                    g1f=prev;
                    g1s=root;
                    glt++;
                }
                else{
                    g2f=prev;
                    g2s=root;
                    glt++;
                }
            }
            prev=root;
        }
        fun(root.right);
    }
    public void recoverTree(TreeNode root) {
        fun(root);
        if(glt==1){
           int temp=g1f.val;
            g1f.val=g1s.val;
            g1s.val=temp;
        } else{
            int temp=g1f.val;
            g1f.val=g2s.val;
            g2s.val=temp;
        }
    }
}