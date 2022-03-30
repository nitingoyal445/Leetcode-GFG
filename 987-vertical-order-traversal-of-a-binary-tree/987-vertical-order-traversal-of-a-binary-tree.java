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
    static int lh=0;
    static int rh=0;
    private void width(TreeNode node, int count){
        if(node == null) return;
        
        if(count<lh){
            lh=count;
        }else if(count>rh){
            rh=count;
        }
        width(node.left, count-1);
        width(node.right, count+1);  
    }
    
    class VPair implements Comparable<VPair>{
        TreeNode node;
        int v_index;
        VPair(TreeNode node, int v_index){
            this.node = node;
            this.v_index = v_index;
        }
        public int compareTo(VPair o){
            if(this.v_index == o.v_index){
                return this.node.val - o.node.val;
            }else{
                return this.v_index - o.v_index;
            }
        } 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<VPair> ppq = new PriorityQueue<>(); // parent priority queue
        PriorityQueue<VPair> cpq = new PriorityQueue<>(); // child priority queue
        lh=0;
        rh=0;
        width(root, 0);
        ppq.add(new VPair(root, Math.abs(lh)));
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<=rh-lh;i++){
            res.add(new ArrayList<>());
        }
        while(ppq.size()>0){
            int sz = ppq.size();
            while(sz-->0){
                VPair rem = ppq.remove();
                res.get(rem.v_index).add(rem.node.val);
                if(rem.node.left!=null) cpq.add(new VPair(rem.node.left, rem.v_index-1));
                if(rem.node.right!=null) cpq.add(new VPair(rem.node.right, rem.v_index+1));
            }
            ppq = cpq;
            cpq = new PriorityQueue<>();
        }
        return res;
    }
}