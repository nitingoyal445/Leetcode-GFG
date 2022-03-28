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
    
    class WPair{
        TreeNode node;
        int index;
        
        WPair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<WPair> qu = new LinkedList<>();
        qu.add(new WPair(root, 0));
        int maxWidth = 0;
        while(qu.size()>0){
            int size = qu.size();
            int lmi = qu.peek().index;  // left most index
            int rmi = 0;              // right most index
            while(size-->0){
                WPair rem = qu.remove();
                rmi = rem.index;
                if(rem.node.left!=null) qu.add(new WPair(rem.node.left, 2*rem.index+1));
                if(rem.node.right!=null) qu.add(new WPair(rem.node.right, 2*rem.index+2));
                maxWidth = Math.max(maxWidth, rmi-lmi+1);
            }
        }
        return maxWidth;
    }
}