class Solution {
    public int maxSubArray(int[] nums) {
        int cmax = nums[0];
        int omax = nums[0];
        for(int i=1;i<nums.length;i++){
            cmax = Math.max(cmax + nums[i], nums[i]);
            if(cmax>omax){
                omax = cmax;
            }
        }
        return omax;
    }
}