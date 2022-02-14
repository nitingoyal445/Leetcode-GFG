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
    static int depth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        int max = Math.max(a,b);
        return max+1;
    }
}