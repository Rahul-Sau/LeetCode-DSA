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
    List<List<Integer>> res=new ArrayList<>();
    void fun(TreeNode root,int Sum,int targetSum,List<Integer> diary){
        if(root==null) return;
        Sum+=root.val;
        diary.add(root.val);
        if (root.left == null && root.right == null) {
            if(Sum==targetSum){
                res.add(new ArrayList<>(diary));}
                diary.remove(diary.size()-1);
                return;
        }
            fun(root.left,Sum,targetSum,diary);
            fun(root.right,Sum,targetSum,diary);
            diary.remove(diary.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        if(root==null) return res;
        fun(root,0,targetSum,new ArrayList<>());
        return res;
    }
}