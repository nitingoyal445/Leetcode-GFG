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
    public boolean findTarget(TreeNode root, int k) {
        LinkedList<Integer> list = inOrderTraversal(root, new LinkedList<>());
        
        int l = 0;
        int r = list.size()-1;
        
        while(l<r){
            if(list.get(l)+list.get(r) == k){
                return true;
            }else if(list.get(l)+list.get(r) < k){
                l++;
            }else if(list.get(l)+list.get(r) > k){
                r--;
            }
        }
        return false;
    }
    
    public LinkedList<Integer> inOrderTraversal(TreeNode root, LinkedList<Integer> inOrderList){
        if(root == null){
            return inOrderList;
        }
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
        return inOrderList;
    }
}