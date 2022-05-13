class Solution {
    public int search(int[] nums, int target) {
        
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public int binarySearch(int[] nums, int lo, int hi, int target){
        
        if(lo>hi){
            return -1;
        }
        int mid = lo+(hi-lo)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid]<target){
            return binarySearch(nums, mid+1, hi, target);
        }else{
            return binarySearch(nums, lo, mid-1, target);
        }
    }
}