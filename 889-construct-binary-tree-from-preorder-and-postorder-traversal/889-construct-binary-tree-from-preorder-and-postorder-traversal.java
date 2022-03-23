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
    
    public static TreeNode constructTree(int[] pre, int[] post, int preSt, int preEnd, int postSt, int postEnd){
        if(preSt == preEnd){
            return new TreeNode(pre[preSt]);
        }
        
        if(preSt > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preSt]);
        int ele = pre[preSt+1];
        int index = postSt;
        while(post[index] != ele){
            index++;
        }
        int eleCount = index - postSt+1;
        
        root.left = constructTree(pre, post, preSt+1, preSt + eleCount, postSt, index);
        root.right = constructTree(pre, post, preSt+eleCount+1, preEnd, index+1, postEnd-1);
        
        return root;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
}