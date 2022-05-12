class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            max_sum = sum>max_sum?sum:max_sum;
        }
        return max_sum;
    }
}