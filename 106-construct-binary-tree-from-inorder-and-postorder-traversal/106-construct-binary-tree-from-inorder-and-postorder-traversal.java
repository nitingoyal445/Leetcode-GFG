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
    public TreeNode constructTree(int[] post, int[] in, int postSt, int postEnd, int inSt, int inEnd){
        if(postSt > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        int indx = inSt;
        while(in[indx] != root.val){
            indx++;
        }
        int eleCount = indx-inSt;
        root.left = constructTree(post, in, postSt, postSt + eleCount-1, inSt, indx-1);
        root.right = constructTree(post, in, postSt + eleCount, postEnd-1, indx+1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
}