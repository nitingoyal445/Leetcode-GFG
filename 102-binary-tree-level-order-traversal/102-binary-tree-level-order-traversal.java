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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        while(!queue.isEmpty()) {
            int tempCount = 0;
            List<Integer> nestedList = new ArrayList<>();
            while(counter != 0) {
                TreeNode treeNode = queue.poll();
                nestedList.add(treeNode.val);
                if (treeNode.left != null) {
                    tempCount++;
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempCount++;
                    queue.add(treeNode.right);
                }
                counter --;
            }
            answer.add(nestedList);
            counter = tempCount;
        }
        return answer;
    }
}