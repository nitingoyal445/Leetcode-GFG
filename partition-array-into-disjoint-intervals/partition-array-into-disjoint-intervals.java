class Solution {
    //variation of "Max Chunks To Make Array Sorted 2" question
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        //1. right min creation
        int[] rightmin = new int[n];
        
        rightmin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightmin[i] = Math.min(nums[i], rightmin[i+1]);
        }
        
        //2. travel and solve, also maintain left max simontaneously
        int leftmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<n-1;i++){
            leftmax = Math.max(leftmax, nums[i]);
            if(leftmax<=rightmin[i+1]){
                ans = i;
                break;
            }
        }
        return ans+1;
    }
}