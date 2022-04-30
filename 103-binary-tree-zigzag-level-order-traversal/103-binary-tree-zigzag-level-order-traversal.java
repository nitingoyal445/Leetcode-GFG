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
import java.util.LinkedList;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = false;
        while(!queue.isEmpty()){
            int sz = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while(sz-->0){
                TreeNode rem = queue.remove();
                if(rem.left!=null) queue.add(rem.left);
                if(rem.right!=null) queue.add(rem.right);
                
                if(flag == false){
                    list.add(rem.val);
                }else{
                    list.addFirst(rem.val);
                }
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}