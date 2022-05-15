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
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            res=0;
            while(sz-->0){
                TreeNode rem = queue.poll();
                res+=rem.val;
                if(rem.left!=null) queue.add(rem.left);
                if(rem.right!=null) queue.add(rem.right);
            }
        }
        return res;
    }
}