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
    
    public TreeNode constructBST(int[] nums, int lo, int hi){
        if(lo>hi){
            return null;
        }
        int mid = lo+(hi-lo)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, lo, mid-1);
        root.right = constructBST(nums, mid+1, hi);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length-1);
    }
}