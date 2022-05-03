class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                flag = true;
            }
            else if(nums[i]<=0 || nums[i]>n){
                nums[i] = 1;
            }
        }
        if(flag==false) return 1;
        
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            int indx = val-1;
            nums[indx] = -Math.abs(nums[indx]);
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}