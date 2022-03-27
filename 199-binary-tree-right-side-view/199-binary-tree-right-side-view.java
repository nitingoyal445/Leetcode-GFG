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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        que.add(root);
        while(que.size()!=0){
            int size = que.size();
            list.add(que.peek().val);
            while(size-->0){
                TreeNode rn = que.remove();
                if(rn.right!=null) que.add(rn.right);
                if(rn.left!=null) que.add(rn.left);
            }   
        }
        return list;
    }
}