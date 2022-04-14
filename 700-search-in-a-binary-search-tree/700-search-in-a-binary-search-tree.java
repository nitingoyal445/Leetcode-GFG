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
    static TreeNode nod= null;
    public TreeNode searchBST(TreeNode root, int val) {
        nod= null;
        searchBST1(root, val);
        return nod;
    }
    
    public void searchBST1(TreeNode root, int val) {
        
        if(root==null){
            return;
        }
        if(root.val == val){
            nod = root;
            return;
        }
        searchBST1(root.left, val);
        searchBST1(root.right, val);
    }   
}