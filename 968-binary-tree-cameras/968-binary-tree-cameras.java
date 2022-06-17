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
    
    // state 0 => camera is present
    // state 1 => I am covered
    // state 2 => I am unsafe
    
    static int camera = 0;
    public int countCameraNeeded(TreeNode root){
        if(root==null){
            return 1; //null is safe , parent try to safe yourself
        }
        int leftState = countCameraNeeded(root.left);
        int rightState = countCameraNeeded(root.right);
        
        //post area
        if((leftState == 1) &&(rightState == 1)){
            //root is unsafe
            return 2;
        }else if(leftState ==2 || rightState==2 ){
            //camera is required
            camera++;
            return 0;
        }else{
            return 1;
        }
        
    }
    public int minCameraCover(TreeNode root) {
        camera = 0;
        int finalState = countCameraNeeded(root);
        if(finalState == 2){
            camera++;
        }
        return camera;
    }
}