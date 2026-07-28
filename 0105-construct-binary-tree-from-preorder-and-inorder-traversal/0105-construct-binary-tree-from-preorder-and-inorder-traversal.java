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
    Map<Integer,Integer> f=new HashMap<>();
            int idx=0;
            TreeNode fun(int[] pre, int low, int high) {
            if (low > high) return null;
            TreeNode node=new TreeNode(pre[idx]);
            idx++;
            int id=f.get(node.val);
            node.left=fun(pre,low,id-1);
            node.right=fun(pre,id+1,high);
            return node;
            }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
        f.put(inorder[i],i);}
        return fun(preorder,0,inorder.length-1);
    }
}