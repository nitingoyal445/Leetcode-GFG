class Solution {
    //better approach // O(1) space
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int maxInRun = nums[0];
        int ans = 0;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i]>maxInRun){
                maxInRun = nums[i];
            }
            else if(nums[i]<leftMax){
                ans = i;
                leftMax = maxInRun;
            }
        }
        return ans+1;
    }
}