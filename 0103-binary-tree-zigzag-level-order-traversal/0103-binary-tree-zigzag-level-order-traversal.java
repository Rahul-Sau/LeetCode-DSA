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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int lefttoright=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res=new ArrayList<>();
        if (root == null) {
            return res; 
        }
        while(!q.isEmpty()){
            int lvlsize=q.size();
            int first=0;
            int last=lvlsize-1;
            Integer[] temp = new Integer[lvlsize];
            while(lvlsize>0){
                TreeNode t=q.poll();
                if(lefttoright==1){
                temp[first]=t.val;
                first++;}
                if(lefttoright==0){
                temp[last]=t.val;
                last--;}
                if(t.left!=null)
                q.offer(t.left);
                if(t.right!=null)
                q.offer(t.right);
                lvlsize--;
            }
            res.add(Arrays.asList(temp));
            lefttoright=1-lefttoright;
        }
        return res;
    }
}