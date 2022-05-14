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
    static boolean isBal;
    public boolean isBalanced(TreeNode root) {
        isBal = true;
        if(root == null) return true;
        int n = helper(root);
        return isBal;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
        
        if(Math.abs(lh-rh)>1){
            isBal = false;
        }
        int ht = Math.max(lh,rh);
        return ht+1;   
    }
    
}