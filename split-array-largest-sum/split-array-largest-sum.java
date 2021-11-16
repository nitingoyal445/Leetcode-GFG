class Solution {
    
    private boolean isSumPossible(int[] nums, int mid, int m){
        int mCount = 1;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                mCount++;
                sum = nums[i];
            }
        }
        return mCount<=m;
    }
    
    public int splitArray(int[] nums, int m) {
        
        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max = Math.max(nums[i], max);
        }
        
        int lo = max;
        int hi = sum;
        int largestSum = Integer.MAX_VALUE;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            
            if(isSumPossible(nums, mid, m)){
                largestSum = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return largestSum;
    }
}