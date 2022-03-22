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
    
    public TreeNode constructTree(int[] pre, int[] in, int preSt, int preEnd, int inSt, int inEnd){
        if(preSt > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preSt]);
        int indx = inSt;
        while(in[indx] != root.val){
            indx++;
        }
        int eleCount = indx - inSt;
        root.left = constructTree(pre, in, preSt+1, preSt + eleCount, inSt, indx);
        root.right = constructTree(pre, in, preSt+eleCount+1, preEnd, indx+1, inEnd);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}