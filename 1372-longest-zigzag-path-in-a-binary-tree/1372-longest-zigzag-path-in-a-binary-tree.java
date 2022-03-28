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
    static int len = 0;
    public class ZPair{
        int lStart;
        int rStart;
        ZPair(int lStart, int rStart){
            this.lStart = lStart;
            this.rStart = rStart;
        }
    }
    public ZPair longestZigZag_(TreeNode root){
        if(root == null){
            return new ZPair(-1, -1);
        }   
        ZPair left = longestZigZag_(root.left);
        ZPair right = longestZigZag_(root.right);
        ZPair mpair = new ZPair(left.rStart+1, right.lStart+1);
        len = Math.max(len, Math.max(mpair.lStart, mpair.rStart));
        return mpair;
    }
    public int longestZigZag(TreeNode root) {
        len = 0;
        longestZigZag_(root);
        return len;
    }
}