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
    
    static int index=0;
    public TreeNode constructBST_pre(int[] pre, int leftRange, int rightRange){
        if(index>=pre.length || pre[index]<leftRange || pre[index]>rightRange){
            return null;
        }
        
        int val = pre[index++];
        TreeNode root= new TreeNode(val);
        root.left = constructBST_pre(pre, leftRange, val);
        root.right = constructBST_pre(pre, val, rightRange);
            
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        index=0;
        return constructBST_pre(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}