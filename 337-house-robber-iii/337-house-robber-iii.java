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
    
    public class RPair{
        int withRob;
        int withoutRob;
        
        public RPair(int withRob, int withoutRob){
            this.withRob = withRob;
            this.withoutRob = withoutRob;
        }
    }
    private RPair rob_rec(TreeNode root){
        if(root == null){
            return new RPair(0,0);
        }
        
        RPair left = rob_rec(root.left);
        RPair right = rob_rec(root.right);
        
        int a = left.withRob;
        int b = left.withoutRob;
        int a_ = right.withRob;
        int b_ = right.withoutRob;
        int c = root.val;
        
        //robbery on root, c+b+b_
        int withRobbery = c + b + b_;
        
        //no robbery , max(a,b)+max(a_,b_)
        int withoutRobbery = Math.max(a,b)+Math.max(a_,b_);
        
        return new RPair(withRobbery, withoutRobbery);
    }
    
    public int rob(TreeNode root) {
        RPair res = rob_rec(root);
        return Math.max(res.withRob, res.withoutRob);
    }
}