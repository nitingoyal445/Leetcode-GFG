class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target || nums[lo] == target || nums[hi] == target){
                return true;
            }
            else if(nums[mid]> nums[hi]) { // left part is sorted
                // if(target>nums[hi] && target < nums[lo]) return false;
                if(target>=nums[lo] && target<nums[mid]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            else if(nums[mid]<nums[lo]){
                // if(target>nums[hi] && target < nums[lo]) return false;
                if(target<=nums[hi] && target>nums[mid]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            else{
                hi--;
            }
        }
        return false;
    }
}