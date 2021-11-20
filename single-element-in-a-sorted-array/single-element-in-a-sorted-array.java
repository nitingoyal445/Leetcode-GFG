class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int indx = -1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            if((mid == 0 || mid == nums.length-1)||
               nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                indx = mid;
                break;
            }else if(nums[mid] == nums[mid+1]){
                if((hi-mid+1)%2 == 0){
                    hi = mid-1;
                }else{
                    lo = mid;
                }
            }else{
                if((mid-lo+1)%2 == 0){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
        }
        return nums[indx];
    }
}