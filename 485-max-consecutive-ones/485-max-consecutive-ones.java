class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int msum = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                sum = 0;
                continue;
            }
            sum++;
            msum=sum>msum?sum:msum;
        }
        return msum; 
    }
}